import code
import json
import os
import readline
import sys

from octopus.server.DBInterface import ResultTransformer
from octopus.shell.completer.octopus_rlcompleter import OctopusShellCompleter
from octopus.shell.config.config import config
from octopus.shell.octopus_shell_utils import reload as _reload


class ScriptInputProvider:
    def __init__(self):
        self.lines = []

    def pushText(self, text):
        self.pushLines(text.splitlines())

    def pushLines(self, lines):
        self.lines = lines + self.lines

    def next(self):
        return self.lines.pop(0)

    def empty(self):
        return self.lines == []

    def iterate(self):
        while not self.empty():
            yield self.next()


class OctopusInteractiveConsole(code.InteractiveConsole):
    def __init__(self, octopus_shell, locals=None):
        def reload(path=config["steps"]["dir"]):
            _reload(octopus_shell, path)

        def include(path):
            f = open(path, 'r')
            self.input_lines.pushText(f.read())
            f.close()

        super().__init__(locals={"reload": reload, "include": include}, filename="<console>")
        self.octopus_shell = octopus_shell
        self.json_enabled = False

    def _preprocess(self, source, filename, symbol):
        self.input_lines = ScriptInputProvider()
        self.input_lines.pushText(source)
        lines = source.splitlines()
        scriptlines = []
        codeblock = []
        line_no = 0
        for l in self.input_lines.iterate():
            if len(l) > 0 and l[0] == '!':
                codeblock.append(l[1:])
            else:
                if len(codeblock) > 0:
                    c = code.compile_command("\n".join(codeblock), filename, 'exec')
                    codeblock = []
                    if c == None:
                        raise Exception("Incomplete command in block ending at line {}".format(line_no))
                    super().runcode(c)
                scriptlines.append(l)
            line_no += 1
        return "\n".join(scriptlines)

    def runsource(self, source, filename="<input>", symbol="single"):

        source = self._preprocess(source, filename, symbol)

        if not source:
            return False

        if source[0] == '!':
            return super().runsource(source[1:], filename, symbol)
        try:
            if source == "quit":
                self._save_history()
                # terminate shell at server side
                self.octopus_shell.quit()
                # terminate shell at client side
                return super().runsource("exit()", filename, symbol)
            else:
                response = self.octopus_shell.run_command(source)
        except Exception as e:
            if "[MultipleCompilationErrorsException]" in str(e):
                # incomplete input
                return True
            response = [str(e)]

        if not response:
            return False

        if self.json_enabled:
            response = ResultTransformer().transform(response)
            response = [json.dumps(response, sort_keys=True)]

        for line in response:
            self.write(line)
            self.write('\n')

        return False

    def write(self, data):
        sys.stdout.write(data)

    def interact(self, host="localhost", port=6000):
        self._load_prompt()
        self._load_banner()
        self._init_readline()
        self._load_history()
        super().interact(self.banner)
        self._save_history()

    def init_file(self):
        return config['readline']['init']

    def hist_file(self):
        return config['readline']['hist']

    def _load_banner(self):
        base = os.path.dirname(__file__)
        path = "data/banner.txt"
        fname = os.path.join(base, path)
        try:
            with open(fname, 'r') as f:
                self.banner = f.read()
        except:
            self.banner = "octopus shell\n"

    def _load_prompt(self):
        sys.ps1 = "> "

    def _init_readline(self):
        readline.parse_and_bind("tab: complete")
        try:
            init_file = self.init_file()
            if init_file:
                readline.read_init_file(os.path.expanduser(self.init_file()))
        except FileNotFoundError:
            pass
        readline.set_completer(OctopusShellCompleter(self.octopus_shell).complete)

    def _load_history(self):
        try:
            hist_file = self.hist_file()
            if hist_file:
                readline.read_history_file(os.path.expanduser(hist_file))
        except FileNotFoundError:
            pass

    def _save_history(self):
        hist_file = self.hist_file()
        if hist_file:
            readline.write_history_file(os.path.expanduser(hist_file))

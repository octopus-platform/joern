import code
import os
import readline
import sys

from octopus.shell.completer.octopus_rlcompleter import OctopusShellCompleter
from octopus.shell.config.config import config
from octopus.shell.octopus_shell_utils import reload as _reload


class OctopusInteractiveConsole(code.InteractiveConsole):
    def __init__(self, octopus_shell, locals=None):
        def reload(path=config["steps"]["dir"]):
            _reload(octopus_shell, path)

        super().__init__(locals={"reload": reload}, filename="<console>")
        self.octopus_shell = octopus_shell

    def runsource(self, source, filename="<input>", symbol="single"):
        if not source:
            return False

        if source[0] == '!':
            return super().runsource(source[1:], filename, symbol)
        try:
            response = self.octopus_shell.run_command(source)
            if source == "quit":
                self._save_history()
                return super().runsource("exit()", filename, symbol)
        except Exception as e:
            if "[MultipleCompilationErrorsException]" in str(e):
                # incomplete input
                return True
            response = [str(e)]

        if not response:
            return False

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

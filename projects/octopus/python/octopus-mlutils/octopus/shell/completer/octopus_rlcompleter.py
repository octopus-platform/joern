import readline

from octopus.shell.octopus_shell_utils import get_variables, get_stepnames, get_object_methods


class OctopusShellCompleter(object):
    def __init__(self, shell):
        self.shell = shell
        self.context = None
        self.matches = None
        readline.set_completer_delims(".)(}{")

    def complete(self, text, state):
        if state == 0:
            self.set_context()
            if self.context == 'groovy':
                self.matches = self._get_groovy_matches(text)
            elif self.context == 'gremlin':
                self.matches = self._get_gremlin_matches(text)
            else:
                self.matches = []

        try:
            return self.matches[state]
        except IndexError:
            return None

    def set_context(self):
        line = readline.get_line_buffer()
        for c in reversed(line):
            if c in '.':
                self.context = "gremlin"
                return
            if c in ')}':
                self.context = "complete"
                return
            elif c in '({':
                self.context = "groovy"
                return

        self.context = "groovy"

    def _get_groovy_matches(self, text):
        total = get_variables(self.shell)
        return [match for match in total if match.startswith(text)]

    def _get_gremlin_matches(self, text):
        buffer = readline.get_line_buffer()
        tail = buffer.rsplit('.', 1)[0]
        variables = get_variables(self.shell)
        steps = get_stepnames(self.shell)
        if tail:
            methods = get_object_methods(self.shell, tail)
        total = variables + steps + methods
        return [match for match in total if match.startswith(text)]

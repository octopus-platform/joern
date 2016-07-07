import os, sys

from octopus.shell.octopus_console import OctopusInteractiveConsole
from octopus.shell.onlinehelp.online_help import OnlineHelp
from octopus.shell.octopus_shell_utils import reload as _reload

from joern.shell.config.config import config

class JoernInteractiveConsole(OctopusInteractiveConsole):
    def __init__(self, octopus_shell):
        def reload(path=config["queries"]["libdir"]):
            _reload(octopus_shell, path)

        super().__init__(octopus_shell=octopus_shell, locals={"reload": reload})
        self.help = OnlineHelp(config["queries"]["docdir"])

    def init_file(self):
        return config['readline']['init']

    def hist_file(self):
        return config['readline']['hist']

    def _load_banner(self):
        base = os.path.dirname(__file__)
        path = "data/josh_banner.txt"
        fname = os.path.join(base, path)
        try:
            with open(fname, 'r') as f:
                self.banner = f.read()
        except:
            self.banner = "josh --- joern shell\n"

    def _load_prompt(self):
        sys.ps1 = "josh> "

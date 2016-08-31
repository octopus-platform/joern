
from argparse import ArgumentParser

class CmdLineTool:
    
    def __init__(self, description):
        self.description = description
        self._initializeOptParser()

    def _initializeOptParser(self):
        self.argParser = ArgumentParser(description = self.description)
    
    def run(self):
        """
        Run the tool. Call this function after all additional
        arguments have been provided
        """
        self._parseCommandLine()
        self._runImpl()

    # @Override
    def _runImpl(self):
        pass

    def _parseCommandLine(self):
        self.args = self.argParser.parse_args()

    def _usage(self):
        self.argParser.print_help()
    


import sys
from argparse import FileType
from octopus.shelltool.CmdLineTool import CmdLineTool

""" A Unix-style pipe tool, which reads from stdin if it is not a
tty-like device or optionally from a provided file and accepts
switches.
"""

class PipeTool(CmdLineTool):
    
    def __init__(self, description):
        CmdLineTool.__init__(self, description)
        
        self.argParser.add_argument('-f', '--file', nargs='?',
                                    type = FileType('r'), default=sys.stdin,
                                    help='read input from the provided file')

        self.argParser.add_argument('-o', '--out', nargs='?', type=
                                    FileType('w'), default=sys.stdout,
                                    help = 'write output to provided file')
    
    def _runImpl(self):

        if self.args.file != sys.stdin or not sys.stdin.isatty():
            self._processStream()
        else:
            self._usage()
    
    def output(self, s):
        self.args.out.write(s)
    
    def _processStream(self):
        self.streamStart()
        for line in self.args.file:
            self.processLine(line.rstrip())
        self.streamEnd()

    def processLine(self, line):
        """ This function is called for each line read from the input
        source. Note that the newline character has already been
        removed when the function is called. Override this method to
        implement your tool"""
        pass

    def streamStart(self):
        """ Called when before reading the first item from the
        stream. Override."""
        pass
            
    def streamEnd(self):
        """ Called after reading the last item from the
        stream. Override."""
        pass
    

if __name__ == '__main__':
    
    tool = PipeTool("foo")
    tool.run()
    

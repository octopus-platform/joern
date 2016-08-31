#!/usr/bin/env python2

import sys, os
from octopus.shelltool.PipeTool import PipeTool

""" A tool processing lines where the first field is interpreted as a
key. Lines are accumulated until the key changes or the end of the
file is encountered. Tab is the only delimiter."""

class DemuxTool(PipeTool):
    
    def __init__(self, DESCRIPTION):
        PipeTool.__init__(self, DESCRIPTION)
        self.currentKey = ''
        self.lines = []

    # @Override
    def processLine(self, line):
        record = line.split('\t')
        if(len(record) < 2 ):
            sys.stderr.write('Warning: input line does not contain key\n')
            return
        
        k = record[0]
        if self.currentKey != '' and k != self.currentKey:
            self.processLines()
            self.lines = []
        
        self.currentKey = k
        self.lines.append(line)
    
    # This function is called when lines have been accumulated.
    # Override to implement functionality of specific tools.
    def processLines(self):
        print(self.lines)
        
    # @Override
    def streamEnd(self):
        if self.lines != []:
            self.processLines()
    

if __name__ == '__main__':
    tool = DemuxTool('foo')
    tool.run()

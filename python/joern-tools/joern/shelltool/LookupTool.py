#!/usr/bin/env python3

from joern.shelltool.TraversalTool import TraversalTool

class LookupTool(TraversalTool):

    # @Override

    def __init__(self, DESCRIPTION):
        TraversalTool.__init__(self, DESCRIPTION)

    # @Override
    def queryFromLine(self, line):
        return line
    
    # @Override

    def outputResult(self, result):
        for r in result:
            self._outputRecord(r)

    def _outputRecord(self, record):
        
        self.output(str(record) + '\n')
        return

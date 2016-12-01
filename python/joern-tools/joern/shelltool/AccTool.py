#!/usr/bin/env python2

from joern.shelltool.LookupTool import LookupTool

DESCRIPTION = """Accumlator tool that runs queries in batches"""

BATCH_SIZE = 128

class AccTool(LookupTool):

    def __init__(self, DESCRIPTION):
        LookupTool.__init__(self, DESCRIPTION)
        self.nodeIds = []

    def processLine(self, line):

        nodeId = line
        self.nodeIds.append(nodeId)

        if len(self.nodeIds) == BATCH_SIZE:
            self.processBatch(self.nodeIds)
            self.nodeIds = []

    # @Override
    def processBatch(self, nodeIds):
        pass

    def streamEnd(self):

        if len(self.nodeIds) != 0:
            self.processBatch(self.nodeIds)

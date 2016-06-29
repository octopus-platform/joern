#!/usr/bin/env python2

import os

from joerntools.view.ParseLocationString import parseLocationOrFail
from joerntools.shelltool.PipeTool import PipeTool

DESCRIPTION = """ Opens emacs at the location specified by a location
string """

class EmOpen(PipeTool):
    def __init__(self):
        PipeTool.__init__(self, DESCRIPTION)
        
    # @Override
    def processLine(self, line):
        (filename, startLine, a, b, c) = parseLocationOrFail(line)
        os.system('emacs %s --eval "(goto-line %s)"' % (filename, startLine))

if __name__ == '__main__':
    tool = EmOpen()
    tool.run()

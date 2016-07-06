import csv
from joern.csvAST.CSVRowAccessors import getCSVRowType

class CSVProcessor:
    def __init__(self):
        self.handlers = dict()
        self.defaultHandler = None
        
        self.reader = None
    
    def processCSVRows(self, csvLines):
        
        self.reader = csv.reader(csvLines, delimiter="\t",
                                 quotechar=None, escapechar=None)
        
        for row in self.reader:
            self._processCSVRow(row)
        
    def _processCSVRow(self, row):
        
        if self.defaultHandler:
            executeOtherHandlers = self.defaultHandler(row)
            if not executeOtherHandlers: return
        
        lineType = getCSVRowType(row)
        handler = self._getHandlerForType(lineType)
        if not handler: return
        handler(row)

    def registerChildHandler(self, level, childHandler):
        self.parentLevel = level
        self.defaultHandler = childHandler
    
    def unregisterChildHandler(self):
        self.parentLevel = None
        self.defaultHandler = None

    def _getHandlerForType(self, lineType):
        try:
            return self.handlers[lineType]
        except:
            return None

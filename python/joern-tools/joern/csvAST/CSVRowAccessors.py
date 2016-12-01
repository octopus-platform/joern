# TODO: adapt to output of subTree.py

ID = 0
NODE_ID = 1
LEVEL = 2
ROW_TYPE = 3
CODE = 4

def getCSVRowType(row):
    return row[ROW_TYPE]

def getCSVRowStartPos(row):
    return row[START_POS].split(':')

def getCSVRowEndPos(row):
    return row[END_POS].split(':')

def getCSVRowLevel(row):
    return row[LEVEL]


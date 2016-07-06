
import argparse, sys

def parseLocationOrFail(line):
    try:
        x = parseLocationString(line)
        (filename, startLine, startPos, startIndex, stopIndex) = x
    except ValueError:
        print('Invalid location line.')
        sys.exit()
    return x

def parseLocationString(values):
    x = values.split(':')
    for i in range(1,len(x)):
        x[i] = int(x[i])
    return x

class ParseLocationString(argparse.Action):
    
    def __call__(self, parser, namespace, values, option_string=None):
        
        try:
            parsedLine = parseLocationString(values)
            (filename, startLine, startPos, startIndex, stopIndex) = parsedLine
        except ValueError:
            parser.error("invalid location string")
        
        setattr(namespace, 'filename', filename)
        setattr(namespace, 'location', '%d:%d:%d:%d' % tuple(parsedLine[1:]) )
        setattr(namespace, 'startLine', startLine)
        setattr(namespace, 'startPos', startPos)
        setattr(namespace, 'startIndex', startIndex)
        setattr(namespace, 'stopIndex', stopIndex)
        

#!/usr/bin/env python2

import os

from mlutils.termDocMatrix.NameDictMapToMatrix import NameDictMapToMatrix

def usage():
    print '<projectRoot>'

def main(projectRoot, tfidf=True):
    
    nameDictMapFilename =  projectRoot + 'func2SubtreesMap.pickl'
    allSymbolsFilename = projectRoot + 'allSubtreesDict.pickl'
    termDocMatrixFilename = projectRoot + 'termDocMatrix.pickl'
    
    # if os.path.exists(termDocMatrixFilename):
    #    print 'Term by Document Matrix already exists, skipping.'
    #    return
    
    converter = NameDictMapToMatrix()
    converter.convertFromFiles(nameDictMapFilename, allSymbolsFilename)
    
    if tfidf:
        converter.termDocumentMatrix.tfidf()   
    converter.save(projectRoot)

if __name__ == '__main__':
    import sys
    
    print len(sys.argv)
    if len(sys.argv) != 2:
        usage()
        sys.exit()
    
    projectRoot = sys.argv[1]
    if projectRoot[-1] != '/': projectRoot += '/'
   
    main(projectRoot) 

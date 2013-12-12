import sys, pickle

from mlutils.termDocMatrix.TermDocumentMatrix import TermDocumentMatrix
from mlutils.distanceMatrix.dataMatrixToDistMatrix import DataMatrixToDistMatrix


def usage():
    print '<projectRoot>'

def loadFunctionVectors(projectRoot):
    projectRoot = sys.argv[1]
    if projectRoot[-1] != '/': projectRoot += '/'
    functionVectorFilename = projectRoot + 'H.pickl'
    return pickle.load(file(functionVectorFilename))
    

def main(projectRoot, metric):
    
    functionVectors = loadFunctionVectors(projectRoot)
    converter = DataMatrixToDistMatrix(projectRoot)
    converter.convert(functionVectors, metric)
    converter.save(metric)

if __name__ == '__main__':
    projectRoot = sys.argv[1]
    metric = sys.argv[2]
    main(projectRoot, metric)
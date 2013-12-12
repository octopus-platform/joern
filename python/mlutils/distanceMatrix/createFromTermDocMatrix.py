import sys, pickle

from mlutils.termDocMatrix.TermDocumentMatrix import TermDocumentMatrix
from mlutils.distanceMatrix.dataMatrixToDistMatrix import DataMatrixToDistMatrix


def usage():
    print '<projectRoot>'

def loadTermDocMatrix(projectRoot):
    projectRoot = sys.argv[1]
    if projectRoot[-1] != '/': projectRoot += '/'
    termDocMatrixFilename = projectRoot + 'termDocMatrix.pickl'
    return pickle.load(file(termDocMatrixFilename)).matrix
    

def main(projectRoot, metric):
    
    matrix = loadTermDocMatrix(projectRoot)
    converter = DataMatrixToDistMatrix(projectRoot)
    converter.convert(matrix, metric)
    converter.save(metric)

if __name__ == '__main__':
    projectRoot = sys.argv[1]
    metric = sys.argv[2]
    main(projectRoot, metric)
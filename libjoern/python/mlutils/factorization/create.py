import sys, pickle

from mlutils.termDocMatrix.TermDocumentMatrix import TermDocumentMatrix
from MatrixFactorizer import MatrixFactorizer


def usage():
    print '<projectRoot> <rank> <algorithm>'

def loadTermDocMatrix(projectRoot):
    if projectRoot[-1] != '/': projectRoot += '/'
    termDocMatrixFilename = projectRoot + 'termDocMatrix.pickl'
    return pickle.load(file(termDocMatrixFilename)).matrix
    
def normalizeProjectRoot(projectRoot):
    if projectRoot[-1] != '/': projectRoot += ('/')
    return projectRoot

def main(projectRoot, rank, algorithm):
    
    matrix = loadTermDocMatrix(projectRoot)
    converter = MatrixFactorizer()
    
    if rank == 0:
        converter.factorize(matrix, algo = algorithm)
    else:
        converter.factorize(matrix, [rank], algorithm)
    
    converter.save(projectRoot)

if __name__ == '__main__':
    projectRoot = normalizeProjectRoot(sys.argv[1])
    rank = int(sys.argv[2])
    algorithm = sys.argv[3]

    main(projectRoot, rank, algorithm)
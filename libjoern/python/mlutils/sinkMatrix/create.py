
from SinkMatrixCreator import SinkMatrixCreator
import pickle, os

def main(projectRoot, sinkName):
    sinkMatrixCreator = SinkMatrixCreator(projectRoot)
    termDocMatrix = sinkMatrixCreator.createMatrixForSink(sinkName)
    
    outputDir = projectRoot + 'sinks'
    if not os.path.exists(outputDir): os.mkdir(outputDir)
    outputDir += '/' + sinkName
    if not os.path.exists(outputDir): os.mkdir(outputDir)
    
    outputFilename = outputDir + '/termDocMatrix.pickl'
    pickle.dump(termDocMatrix, file(outputFilename, 'w'))

def usage():
    print '<projectRoot> <sink>'

if __name__ == '__main__':
    import sys
    
    projectRoot = sys.argv[1]
    sink = sys.argv[2]
     
    main(projectRoot, sink)
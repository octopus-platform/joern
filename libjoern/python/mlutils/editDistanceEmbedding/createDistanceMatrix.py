
import sys, pickle
import converter
import Pygram
import numpy
import os.path

editDistances = None
termDocMatrix = None

def normalizeProjectRoot(projectRoot):
    if projectRoot[-1] != '/': projectRoot += '/'
    return projectRoot

def loadLocations(projectRoot):
    termDocMatrixFilename = projectRoot + 'termDocMatrix.pickl'
    termDocMatrix = pickle.load(file(termDocMatrixFilename))
    locations = termDocMatrix.index2Doc
    return locations

def loadEditDistances(projectRoot):
    editDistancePicklFilename = projectRoot + 'editDistances.pickl'
    editDistances = pickle.load(file(editDistancePicklFilename))
    return editDistances

def distanceMatrixFromLocations(projectRoot, locations):
    global editDistances
    global termDocMatrix
    
    if locations == []: return None
    
    editDistancePicklFilename = projectRoot + 'editDistances.pickl'
    if os.path.exists(editDistancePicklFilename):
        print 'editDistances.pickl exists'
        
        if editDistances == None:
            editDistances = loadEditDistances(projectRoot)
        
        if termDocMatrix == None:
            termDocMatrixFilename = projectRoot + 'termDocMatrix.pickl'
            termDocMatrix = pickle.load(file(termDocMatrixFilename))
        
        indices = [termDocMatrix.doc2Index[location] for location in locations]
        D = editDistances[:,indices]
        D = D[indices,:]
    else:
    
        profiles = [Pygram.Profile(converter.locationToPygramTree(location)) for location in locations]
    
        D = numpy.zeros((len(profiles), len(profiles)))
        for i in xrange(len(profiles)):
            p1 = profiles[i]
            DTmp = [p1.edit_distance(profiles[j]) for j in xrange(i+1, len(profiles))]
            D[i, i+1:] = DTmp
            D[i+1:,i] = DTmp
        
    return D
    
def main(projectRoot):
    projectRoot = normalizeProjectRoot(projectRoot)
    locations = loadLocations(projectRoot)
    D = distanceMatrixFromLocations(projectRoot, locations)
    pickle.dump(D, file(projectRoot + 'editDistances.pickl', 'w')) 
    
if __name__ == '__main__':
    main(sys.argv[1])
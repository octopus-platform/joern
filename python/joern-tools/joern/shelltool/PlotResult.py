#!/usr/bin/env python

from octopus.shelltool.ResultProcessor import BaseResultProcessor,NodeResultPropertyCleaner

class NodeResult(NodeResultPropertyCleaner):
    def getElementType(self):
        return 'node'
    def getId(self):
        return self.result['id']
    def getProperties(self):
        props = self.properties()
        props['id'] = self.getId()
        return props

class EdgeResult(BaseResultProcessor):
    def getElementType(self):
        return 'edge'
    def getDest(self):
        return self.result['inV']
    def getSrc(self):
        return self.result['outV']
    def getId(self):
        return self.result['id']
    def getLabel(self):
        return self.result['label']
    def getProperties(self):
        props = self.properties()
        props['id'] = self.getId()
        props['label'] = self.getLabel()
        return props



#!/usr/bin/env python

from octopus.shelltool.ResultProcessor import BaseResultProcessor

class NodeResult(BaseResultProcessor):
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
        return self.result['outV']
    def getSrc(self):
        return self.result['inV']
    def getKey(self):
        return self.result['id']
    def getLabel(self):
        return self.result['label']
    def getProperties(self):
        return { "key": self.result['id'], "label" : self.result['label'] }



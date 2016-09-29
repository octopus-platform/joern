#!/usr/bin/env python3

import unittest
from PlotConfiguration import *
from PlotResult import *
from io import StringIO

class ANodeResult:
    def __init__(self):
        self.data = { 'properties' : {} }
    def get(self):
        return NodeResult(self.data)
    def withId(self,i):
        self.data['id'] = i
        return self
    def withProperty(self,key,value):
        self.data.setdefault('properties',{})[key]= [ { "id":"x", "value" : value } ]
        return self

class AnEdgeResult:
    def __init__(self):
        self.data = {'properties' : {} }
    def get(self):
        return EdgeResult(self.data)
    def withId(self,key):
        self.data['id'] = key
        return self
    def withSrc(self,src):
        self.data['inV'] = src
        return self
    def withDest(self,dest):
        self.data['outV'] = dest
        return self
    def withLabel(self,label):
        self.data['label'] = label
        return self
    def withProperty(self,key,value):
        self.data.setdefault('properties',{})[key]= value
        return self

class TestPlotConfiguration(unittest.TestCase):
    def readConfigFromString(self,cfg,data):
        f = StringIO(data)
        cfg.parse(f)
    def testEmptyConfiguration(self):
        cfg = PlotConfiguration()
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [ ] )
        self.assertEqual( cfg.getElementLayout(nr), {} )
    def testConfigurationGeneralRule(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id
node.layout=*:shape=rectangle,style=filled
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [[123]] )
        self.assertEqual( cfg.getElementLayout(nr), {"shape":"rectangle", "style":"filled"} )
    def testConfigurationGeneralRuleMultipleDisplayItemsWithSpecs(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [[123],['isCFGNode','True']] )
    def testConfigurationMultiRule(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:&id
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [["id",123]] )
    def testConfigurationMultiRuleAddOptions(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:&id
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:+isCFGNode,code
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').withProperty('code','a ++').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [["id",123],["True"],["a ++"]] )
    def testConfigurationMultiRuleOverrideOptions(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:&id
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:+-id,id,isCFGNode,code
node.layout=isCFGNode.True:+fillcolor=blue
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').withProperty('code','a ++').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [[123],["True"],["a ++"]] )
        self.assertEqual( cfg.getElementLayout(nr), {"shape":"rectangle","style":"filled","fillcolor":"blue"} )
    def testConfigurationMultiRulePropertyWildcards(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:&id
node.display=id.*:isCFGNode
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [["True"]] )
    def testConfigurationEmptyValue(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:
node.layout=isCFGNode.True:
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [] )
        self.assertEqual( cfg.getElementLayout(nr), {} )
    def testConfigurationNonexistingValue(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:nonexistent
node.layout=isCFGNode.True:nonexistent
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        # empty config means show all fields
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [] )
        self.assertEqual( cfg.getElementLayout(nr), {} )

    def testConfigurationAppendEmptyValue(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
node.display=*:id,&isCFGNode
node.layout=*:shape=rectangle,style=filled
node.display=isCFGNode.True:+
node.layout=isCFGNode.True:+
""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [[123],["isCFGNode","True"]] )
        self.assertEqual( cfg.getElementLayout(nr), {"shape":"rectangle","style":"filled"} )

    def testConfigurationWildcardDisplayNoKey(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""node.display=*:*""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [[123],["True"]] )
    def testConfigurationWildcardDisplayWithKey(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""node.display=*:&*""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [["id",123],["isCFGNode","True"]] )
    def testConfigurationWildcardDisplayAndHide(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""node.display=*:&*,-id""")
        nr = ANodeResult().withId(123).withProperty('isCFGNode','True').get()
        self.assertCountEqual( cfg.getElementDisplayItems(nr) , [["isCFGNode","True"]] )
    def testConfigurationForEdges(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
edge.display=*:&*,-id
edge.layout=label.USE:color=red,fontcolor=blue
""")
        er = AnEdgeResult().withId(123).withLabel("USE").get()
        self.assertCountEqual( cfg.getElementDisplayItems(er), [["label","USE"]] )
        self.assertCountEqual( cfg.getElementLayout(er), {"color":"red","fontcolor":"blue" } )
    def testConfigurationWithComments(self):
        cfg = PlotConfiguration()
        self.readConfigFromString(cfg,"""
# edge.display=*:&*,-id
# edge.layout=label.USE:color=red,fontcolor=blue
""")
        er = AnEdgeResult().withId(123).withLabel("USE").get()
        self.assertCountEqual( cfg.getElementDisplayItems(er), [] )
        self.assertCountEqual( cfg.getElementLayout(er), {} )
if __name__=="__main__":
    unittest.main()

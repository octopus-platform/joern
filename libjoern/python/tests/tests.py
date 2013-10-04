import unittest


import sys, os

sys.path.append(os.getcwd())
from libjoern import JoernSteps

class JoernStepsTests(unittest.TestCase):

    def setUp(self):
        self.j = JoernSteps()

    def tearDown(self):
        pass

    def testCallRetrieval(self):
        
        query = """ getCallsTo('bar').code """
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)

    def testLeftValueFlowCaption(self):
        
        query = """
        getCallsTo('bar')
        .astNodeToBasicBlock().outE('REACHES').var
        """
        x = self.j.executeGremlinCmd(query)
        
        self.assertTrue(len(x) == 2)
        self.assertEquals(x[0], "x")
        self.assertEquals(x[1], "x")

    
    def testTaintSourceFlowCaption(self):
        
        query = """
        getCallsTo('taint_source')
        .astNodeToFunction().filter{it.functionName == 'test_call_tainting'}
        .back(2)
        .astNodeToBasicBlock().outE('REACHES').var
        """
        
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)
        self.assertEquals(x[0], "y")

    def testTwoTaintedSources(self):
        
        query = """
        getCallsTo('second_taint_source')
        .astNodeToBasicBlock().outE('REACHES').var
        """
        
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)
        self.assertEquals(x[0], "z")

    
        query = """
        getCallsTo('taint_source')
        .astNodeToFunction().filter{it.functionName == 'two_taint_sources'}
        .back(2)
        .astNodeToBasicBlock().outE('REACHES').var
        """
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)
        self.assertEquals(x[0], "y")
    
    def testPlusEqualsUse(self):
        query = """
        getFunctionByName('plusEqualsUse')
        .functionToBasicBlocks().out('USE').code"""
        
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 2)
    
    def testIdentifierDeclDEFLink(self):
        query = """
        getFunctionByName('udg_test_simple_decl').functionToASTNodes()
        .filter{it.type == 'IdentifierDecl'}.out('DEF').code

        """
        x = self.j.executeGremlinCmd(query)

        self.assertEquals(len(x), 1)
        self.assertEquals(x[0], 'x')

    
    def testParameterrDEFLink(self):
        query = """
        getFunctionByName('udg_test_param_decl').functionToASTNodes()
        .filter{it.type == 'Parameter'}.out('DEF').code

        """
        x = self.j.executeGremlinCmd(query)

        self.assertEquals(len(x), 1)
        self.assertEquals(x[0], 'x')

        

def main():
    unittest.main()

if __name__ == '__main__':
    main()

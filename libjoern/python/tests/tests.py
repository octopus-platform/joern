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

    
    def testParameterDEFLink(self):
        query = """
        getFunctionByName('udg_test_param_decl').functionToASTNodes()
        .filter{it.type == 'Parameter'}.out('DEF').code

        """
        x = self.j.executeGremlinCmd(query)

        self.assertEquals(len(x), 1)
        self.assertEquals(x[0], 'x')

    def testUseFromArg(self):
        query = """
        getFunctionByName('udg_test_def_tainted_call').functionToASTNodes()
        .filter{it.type == 'Argument'}.out('USE').code

        """
        x = self.j.executeGremlinCmd(query)

        self.assertEquals(len(x), 1)
        self.assertEquals(x[0], 'x')

    def testUseFromArgMemberAccess(self):
        query = """
        getFunctionByName('udg_test_struct_field_use')
        .functionToASTNodes()
        .filter{it.type == 'Argument'}
        .out('USE').code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 2)
        
    def testAssignToArrayField(self):
        query = """
        getFunctionByName('udg_test_assign_to_array_field')
        .functionToASTNodes()
        .filter{it.type == 'AssignmentExpr'}
        .out('DEF').code
        """
        x = self.j.executeGremlinCmd(query)
        # At some point, we want to make this DEF(*x)
        # instead.
        self.assertEquals(x[0], 'arr')

    def testAssignToExpressionDef(self):
        query = """
        getFunctionByName('udg_test_assign_to_expression')
        .functionToASTNodes()
        .filter{it.type == 'AssignmentExpr'}
        .out('DEF').code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(x[0], 'a')
        self.assertEquals(x[1], 'b')
        

    # This one currently fails.
    # def testAssignToExpressionUSE(self):
    #     query = """
    #     getFunctionByName('udg_test_assign_to_expression')
    #     .functionToASTNodes()
    #     .filter{it.type == 'AssignmentExpr'}
    #     .out('USE').code
    #     """
    #     x = self.j.executeGremlinCmd(query)
    #     self.assertEquals(x[0], 'a')
    #     self.assertEquals(x[1], 'b')


    def testDataFlowFromRegex_positive(self):
         query = """
         
         sources  = [Pattern.compile('taint_source')]
         
         getFunctionByName('test_dataFlowFromRegex')
         .functionToASTNodes().filter{it.type == 'Argument' && it.code =='y'}
         .dataFlowFromRegex('taint_source')
         .transform{ g.v(it[0]) } // source
         .code
         
         """
         x = self.j.executeGremlinCmd(query)
         self.assertEquals(len(x), 1)
         self.assertTrue(x[0].startswith('taint_source'))

    def testDataFlowFromRegex_negative(self):
         query = """
         
         sources  = [Pattern.compile('taint_source')]
         
         getFunctionByName('test_dataFlowFromRegex')
         .functionToASTNodes().filter{it.type == 'Argument' && it.code =='y'}
         .dataFlowFromRegex('something_else')
         .transform{ g.v(it[0]) } // source
         .code
         
         """
         x = self.j.executeGremlinCmd(query)
         self.assertTrue(len(x) == 0)

    def testDataFlowFromRegex_untainted_source(self):
         query = """
         
         sources  = [Pattern.compile('taint_source')]
         
         getFunctionByName('test_dataFlowFromUntainted')
         .functionToASTNodes().filter{it.type == 'Argument' && it.code =='y'}
         .dataFlowFromRegex('not_a_taint_source')
         .transform{ g.v(it[0]) } // source
         .code
         
         """
         x = self.j.executeGremlinCmd(query)
         self.assertTrue(len(x) == 0)


    def testIsNotSanitizedByRegex_positive(self):
        query = """
        getFunctionByName('test_isNotSanitizedByRegex')
        .functionToCallsTo('sink').callToArgumentN('0')
        .dataFlowFromRegex('taint_source')
        .isNotSanitizedByRegex('foo') 
        .transform{ g.v(it[0]) } // source
        .code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)
        self.assertTrue(x[0].startswith('taint_source'))

    def testIsNotSanitizedByRegex_negative(self):
        query = """
        getFunctionByName('test_isNotSanitizedByRegex')
        .functionToCallsTo('sink').callToArgumentN('0')
        .dataFlowFromRegex('taint_source')
        .isNotSanitizedByRegex('memset') 
        .transform{ g.v(it[0]) } // source
        .code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 0)

    def testMissingCheckLocalTaintTemplate(self):
        query = """
        
        setSinkArgument('sink.*', '0', 'y')
        .sideEffect{ sinkCallCode = sinkCode(it) ; argCode = sinkArgCode(it); }
        
        .astNodeToFunction().filter{it.functionName.equals('test_isNotSanitizedByRegex')}
        .back(2)
        .dataFlowFromRegex('taint_source')
        .isNotSanitizedBy{ it.filter{it.code.contains('foo')} }
        .sideEffect{ (sinkId, sourceId) = it}
        
        .transform{ g.v(sinkId) }
        .functionAndFilename().sideEffect{ (funcName, fileName) = it;}
        .transform{[fileName, funcName, sinkCallCode, argCode]}
        """
        x = self.j.executeGremlinCmd(query)
        self.assertTrue(len(x) == 1)

    def testMissingCheckLocalTaintTemplate2(self):
        query = """
        getParameterByRegex('.*aUniqueParamName.*')
        .sideEffect{ taintedVar = parameterName(it);}
        .transform{ [it, taintedVar] }
        .dataFlowToRegex('sink')
        .sideEffect{ (sourceId, sinkId, v) = it }
        // get those sink calls where the third argument is tainted
        .transform{ g.v(sinkId) }
        .basicBlockToAST().subASTsOfType('CallExpression').callToArgumentN('0')
        .filter{ it.code.contains(v) }
        .transform{ [sourceId, sinkId] }.dedup()
        .isNotSanitizedByRegex('foo')

        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 1)

    def test_checksSymbol(self):
        query = """
        getFunctionByName('test_checksSymbol')
        .sideEffect{ sanitizerExpr = { exists( checksSymbol(it.astNodeToBasicBlock(), 'count')) } }
        .filter{ noConditionMatches(it, sanitizerExpr) }
        .functionName
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 0)
        
    def testUDGStructDEF(self):
        query = """
        getFunctionByName('ddg_test_struct').functionToASTNodes()
        .filter{it.type == 'AssignmentExpr'}.astNodeToBasicBlock()
        .out('DEF').code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 1)
        self.assertEquals(x[0], 'foo . bar')
    
    def testUDGStructUSE(self):
        query = """
        getFunctionByName('ddg_test_struct').functionToASTNodes()
        .filter{it.type == 'AssignmentExpr'}.astNodeToBasicBlock()
        .out('USE').code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 1)
        self.assertTrue(x[0] == 'foo')


    def testDDGStruct(self):
        query = """
        getFunctionByName('ddg_test_struct').functionToASTNodes()
        .filter{it.type == 'IdentifierDecl'}.astNodeToBasicBlock()
        .out('REACHES').code
        """
        x = self.j.executeGremlinCmd(query)
        self.assertEquals(len(x), 2)

    




def main():
    unittest.main()

if __name__ == '__main__':
    main()


// Node Keys

Object.metaClass.NODE_TYPE = 'type'
Object.metaClass.NODE_NAME = 'name'
Object.metaClass.NODE_CODE = 'code'
Object.metaClass.NODE_CHILDNUM = 'childNum'
Object.metaClass.NODE_ISCFGNODE = 'isCFGNode'

// Node Values

Object.metaClass.TYPE_CALL = 'CallExpression'
Object.metaClass.TYPE_CALLEE = 'Callee'
Object.metaClass.TYPE_FUNCTION = 'Function'
Object.metaClass.TYPE_ARGLIST = 'ArgumentList'
Object.metaClass.TYPE_ASSIGNMENT = 'AssignmentExpr'
Object.metaClass.TYPE_FILE = 'File'

Object.metaClass.TYPE_IDENTIFIER_DECL_STMT = 'IdentifierDeclStatement'
Object.metaClass.TYPE_PARAMETER = 'Parameter'
Object.metaClass.TYPE_SYMBOL = 'Symbol'

// Edge types

Object.metaClass.AST_EDGE = 'IS_AST_PARENT'
Object.metaClass.CFG_EDGE = 'FLOWS_TO'

Object.metaClass.USES_EDGE = 'USE'
Object.metaClass.DEFINES_EDGE = 'DEF'
Object.metaClass.DATA_FLOW_EDGE = 'REACHES'

Object.metaClass.FUNCTION_TO_AST_EDGE = 'IS_FUNCTION_OF_AST'
Object.metaClass.FUNCTION_TO_CFG_EDGE = 'IS_FUNCTION_OF_CFG'

Object.metaClass.FILE_TO_FUNCTION_EDGE = 'IS_FILE_OF'

// Edge keys

Object.metaClass.DATA_FLOW_SYMBOL = 'var'

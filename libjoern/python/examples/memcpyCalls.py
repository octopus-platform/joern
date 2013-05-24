
import sys, os
sys.path.append(os.getcwd())
from libjoern import JoernSteps

def printRecords(records):
    for record in records:
        node = (record[0])
        print node

j = JoernSteps()

# (1) Retrieve all AST-nodes containing a call to memcpy
# by using the node index

records = j.executeCypherQuery('START funcCall=node:astNodeIndex(type="CallExpression") ' + 
                               'MATCH (funcCall)-[r:IS_AST_PARENT]->(callee) '
                               'WHERE r.n = "0" AND callee.code = "memcpy"' +
                               'RETURN funcCall ORDER by ID(funcCall)')[0]

# (2) Retrieve the corresponding function signatures

nodeIds = ','.join([str(r[0].id) for r in records])

query = 'START funcCall=node('
query += nodeIds
query += ') MATCH func-[r:IS_FUNCTION_OF_AST_NODE]->funcCall RETURN func.signature ORDER BY ID(funcCall)'

records = j.executeCypherQuery(query)[0]

# (1) and (2) in a single query

records = j.executeCypherQuery('START funcCall=node:astNodeIndex(type="CallExpression") ' + 
                               'MATCH (func)-[r1:IS_FUNCTION_OF_AST_NODE]->(funcCall)' +
                               '-[r2:IS_AST_PARENT]->(callee) ' +
                               'WHERE r2.n = "0" AND callee.code = "memcpy"' +
                               'RETURN func.signature ORDER by ID(funcCall)')[0]

printRecords(records)




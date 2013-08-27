import sys, os

sys.path.append(os.getcwd())
from libjoern import JoernSteps

j = JoernSteps()

# (*) Looking up nodes by type:
# Retrieve code of all assignment expressions

cmd = """ queryNodeIndex('type:"AssignmentExpr"').code
"""

for x in j.executeGremlinCmd(cmd): print x

# (*) Alternative: Retrieve entire nodes including
#     all properties
# Warning: This is more expensive than specifying
# the properties you are interested in

cmd = """ queryNodeIndex('type:"AssignmentExpr"')
"""

for x in j.executeGremlinCmd(cmd):
    print x['data']['code']

# (*) AND-query on two key-value pairs:
# Retrieve all functions where name matches *create*

cmd = """ queryNodeIndex('type:"Function" AND functionName:*create*').functionName """

for x in j.executeGremlinCmd(cmd): print x

# (*) Use result of an index lookup for a subsequent index lookup:
# Retrieve all assignments in functions where name matches *create*

cmd = """
queryNodeIndex('type:"Function" AND functionName:*create*').id
  .transform{ 'functionId:"' + it + '" AND type:AssignmentExpr' }
  .queryNodeIndex().code
"""

for x in j.executeGremlinCmd(cmd): print x

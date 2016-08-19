#!/usr/bin/env python3

from octopus.server.DBInterface import DBInterface

projectName = 'coreutils.tar.gz'
query = "queryNodeIndex('type:Function').name"

db = DBInterface()
db.connectToDatabase(projectName)

result = db.runGremlinQuery(query)
for x in result:
    print(x)

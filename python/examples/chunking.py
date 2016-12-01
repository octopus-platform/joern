#!/usr/bin/env python3

from octopus.server.DBInterface import DBInterface

projectName = 'testCode.tar.gz'
query = "queryNodeIndex('type:Function').id"

db = DBInterface()
db.connectToDatabase(projectName)

ids = db.runGremlinQuery(query)

CHUNK_SIZE = 256
for chunk in db.chunks(ids, CHUNK_SIZE):

    query = """ idListToNodes(%s).astNodes().id """ % (chunk)
    for r in db.runGremlinQuery(query):
        print(r)

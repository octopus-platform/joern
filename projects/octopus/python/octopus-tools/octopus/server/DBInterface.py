from octopus.server.python_shell_interface import PythonShellInterface

import os, json

class DBInterface:

    def __init__(self):
        self.transformer = ResultTransformer()
        self.jsonEnabled = True;

    def disable_json(self):
        self.jsonEnabled = False;

    def connectToDatabase(self, databaseName = 'octopusDB'):
        self.j = PythonShellInterface()
        self.j.setDatabaseName(databaseName)
        self.j.connectToDatabase()

        if self.jsonEnabled:
            self.j.runGremlinQuery('toggle_json')

    def runGremlinQuery(self, query):
        result = self.j.runGremlinQuery(query)

        if not self.jsonEnabled:
            return result

        return self.transformer.transform(result)

    def chunks(self, ids, chunkSize):
        return self.j.chunks(ids, chunkSize)


class ResultTransformer(object):

    def transform(self, jsonMessage):

        if not len(jsonMessage) == 1:
            raise

        o = json.loads(jsonMessage[0])
        resultData = o['result']['data']
        if not isinstance(resultData, list):
            resultData = [resultData]
        return resultData

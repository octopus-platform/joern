import sys, os
import base64
import http.client
import urllib

SERVER_HOST = 'localhost'
SERVER_PORT = '2480'

class OctopusImporter:
    def __init__(self):
        pass

    def importFile(self, filename):
        self.filename = filename
        self.createProject()
        self.uploadFile()
        self.executeImporterPlugin()

    def createProject(self):
        self.projectName = os.path.split(self.filename)[-1]
        print('Creating project: %s' % (self.projectName))

        conn = self._getConnectionToServer()
        conn.request("GET", "/manageprojects/create/%s" % (self.projectName))

    def _getConnectionToServer(self):
        return http.client.HTTPConnection(SERVER_HOST + ":" + SERVER_PORT)

    def uploadFile(self):
        print('Uploading file: %s' % (self.filename))

        with open(self.filename, mode='rb') as file:
            fileContent = file.read()

        base64Content = base64.b64encode(fileContent)

        headers = {"Content-type": "text/plain;charset=us/ascii"}
        conn = self._getConnectionToServer()
        conn.request("POST", "/manageprojects/uploadfile/%s/binary" % (self.projectName), base64Content, headers)
        response = conn.getresponse()

    def executeImporterPlugin(self):
        print('Executing importer plugin')
        conn = self._getConnectionToServer()
        conn.request("POST", "/executeplugin/", self.importerPluginJSON % (self.projectName))
        response = conn.getresponse()


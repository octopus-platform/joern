import sys, os
import http.client
import urllib

from ftplib import FTP

SERVER_HOST = 'localhost'
SERVER_PORT = '2480'
FTP_PORT = 23231

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

        ftp = FTP()
        ftp.connect(SERVER_HOST, FTP_PORT)
        ftp.login()
        filenameToWriteTo = os.path.join(self.projectName, "binary")
        ftp.storbinary('STOR ' + filenameToWriteTo, open(self.filename, 'rb'))
        ftp.close()

    def executeImporterPlugin(self):
        print('Executing importer plugin')
        conn = self._getConnectionToServer()
        conn.request("POST", "/executeplugin/", self.importerPluginJSON % (self.projectName))
        response = conn.getresponse()

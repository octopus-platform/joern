import sys, os
import http.client
import urllib

from octopus.server.project_manager import ProjectManager
from octopus.server.plugin_executor import PluginExecutor

class OctopusImporter:
    def __init__(self):
        pass

    def importFile(self, filename):
        self.filename = filename

        self.initProjectManager()
        self.initPluginExecutor()

        self.createProject()
        self.uploadFile()
        self.executeImporterPlugin()

    def initProjectManager(self):
        self.projectManager = ProjectManager()
        self.projectManager.connect()

    def initPluginExecutor(self):
        self.pluginExecutor = PluginExecutor()

    def createProject(self):
        self.projectName = os.path.split(self.filename)[-1]
        print('Creating project: %s' % (self.projectName))
        print(self.projectManager.create(self.projectName))

    def uploadFile(self):
        print('Uploading file: %s' % (self.filename))
        self.projectManager.upload(self.projectName, self.filename, "binary")

    def executeImporterPlugin(self):
        print('Executing importer plugin')
        print('plugin name: %s\n' % self.pluginName)
        pluginSettings = { 'projectName' : self.projectName }
        print(self.pluginExecutor.execute(self.pluginName, self.pluginClass, pluginSettings))

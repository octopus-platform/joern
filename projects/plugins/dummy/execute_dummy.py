#!/usr/bin/env python3

from octopus.plugins.plugin import OctopusPlugin
from octopus.server.orientdb.orientdb_plugin_executor import OrientDBPluginExecutor

class DummyPlugin(OctopusPlugin):

    def __init__(self, executor):

        super().__init__(executor)
        self._pluginname = 'dummy.jar'
        self._classname = 'joern.plugins.dummy.DummyPlugin'

    def __setattr__(self, key, value):
        if key in ['myParameter', 'projectName']:
            self._settings[key] = value
        else:
            super().__setattr__(key, value)

if __name__ == '__main__':

    server_host = 'localhost'
    server_port = 2480

    plugin_executor = OrientDBPluginExecutor(server_host, server_port)
    plugin = DummyPlugin(plugin_executor)

    plugin.myParameter = 'hello world'
    plugin.projectName = 'coreutils.tar.gz'
    plugin.execute()

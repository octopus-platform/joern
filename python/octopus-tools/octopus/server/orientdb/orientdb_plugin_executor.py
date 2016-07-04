import json

from octopus.server.orientdb.orientdb_server_command import OrientDBServerCommand


class OrientDBPluginExecutor(object):
    def __init__(self, server_host, server_port):
        self.command = OrientDBServerCommand(server_host, server_port)

    def execute(self, pluginname, classname, settings=None):
        data = {"plugin": pluginname, "class": classname, "settings": settings}
        json_data = json.dumps(data)
        return self.post(json_data)

    def post(self, json_data):
        return self.command.execute_post_command("/executeplugin/", json_data)

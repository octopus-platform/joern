import base64
from octopus.server.server_command import ServerCommand

class ProjectManager(object):

    def __init__(self, server_host, server_port):
        self.command = ServerCommand(server_host, server_port)

    def create(self, project_name):
        return self.command.execute_get_command("/manageprojects/create/{}".format(project_name))

    def delete(self, project_name):
        return self.command.execute_get_command("/manageprojects/delete/{}".format(project_name))

    def list(self):
        return self.command.execute_get_command("/manageprojects/list")

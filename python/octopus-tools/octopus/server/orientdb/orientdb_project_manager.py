import base64

from octopus.server.orientdb.orientdb_server_command import OrientDBServerCommand
from octopus.server.project_manager import ProjectManager


class OrientDBProjectManager(ProjectManager):
    def __init__(self, server_host, server_port):
        self.command = OrientDBServerCommand(server_host, server_port)

    def create(self, project_name):
        return self.command.execute_get_command("/manageprojects/create/{}".format(project_name))

    def delete(self, project_name):
        return self.command.execute_get_command("/manageprojects/delete/{}".format(project_name))

    def list(self):
        return self.command.execute_get_command("/manageprojects/list")

    def upload_file(self, project_name, file):
        file_content = file.read()
        content_type = "text/plain;charset=us/ascii"

        name = "/manageprojects/uploadfile/{}/binary".format(project_name)
        body = base64.b64encode(file_content)
        headers = {"Content-type": content_type}

        return self.command.execute_post_command(name, body, headers)

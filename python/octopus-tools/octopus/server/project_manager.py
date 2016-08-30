import os, base64
from ftplib import FTP

from octopus.server.server_command import ServerCommand

SERVER_HOST = 'localhost'
SERVER_PORT = '2480'
FTP_PORT = 23231

class ProjectManager(object):

    def __init__(self, server_host = SERVER_HOST, server_port = SERVER_PORT):
        self.server_host = server_host
        self.server_port = server_port
        self.ftp_port = FTP_PORT

    def connect(self):
        self.command = ServerCommand(self.server_host, self.server_port)

    def create(self, project_name):
        return self.command.execute_get_command("/manageprojects/create/{}".format(project_name))

    def delete(self, project_name):
        return self.command.execute_get_command("/manageprojects/delete/{}".format(project_name))

    def list(self):
        return self.command.execute_get_command("/manageprojects/list")

    def upload(self, project_name, filename, dst_filename = None):

        if dst_filename == None:
            dst_filename = os.path.split(filename)[-1]

        ftp = FTP()
        ftp.connect(self.server_host, self.ftp_port)
        ftp.login()
        filename_to_write_to = os.path.join(project_name, dst_filename)
        ftp.storbinary('STOR ' + filename_to_write_to, open(filename, 'rb'))
        ftp.close()
        return "uploaded"

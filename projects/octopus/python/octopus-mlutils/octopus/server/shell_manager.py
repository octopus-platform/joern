from octopus.server.server_command import ServerCommand

class ShellManager(object):

    def __init__(self, server_host, server_port):
        self.command = ServerCommand(server_host, server_port)

    def create(self, project_name, shellname = 'noname'):
        response = self.command.execute_get_command("/manageshells/create/{}/{}".format(project_name, shellname))

        try:
            port = int(response)
        except:
            print(response)
            raise Exception("Error creating shell. Does the project exist?")

        return port

    def list(self, project_name=None, shell_port=None, filter_occupied=False):
        response = self.command.execute_get_command("/manageshells/list")
        if not response:
            return
        for shell in response.split('\n'):
            port, dbName, name, occupied = shell.split('\t')
            port = int(port)
            occupied = True if occupied == 'true' else False
            if (not project_name or name == project_name) \
                    and (not shell_port or port == shell_port) \
                    and (not filter_occupied or not occupied):
                yield port, dbName, name, ('occupied' if occupied else 'free')

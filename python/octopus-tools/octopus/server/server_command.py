import http.client


class ServerCommand(object):
    def __init__(self, server_host="localhost", server_port="2480"):
        self._server_host = server_host
        self._server_port = server_port
        self._connection = None

    def _connect(self):
        self._connection = http.client.HTTPConnection("{}:{}".format(self._server_host, self._server_port))

    def _disconnect(self):
        self._connection.close()

    def execute_post_command(self, name, body=None, headers={}):
        self._connect()
        self._connection.request("POST", name, body, headers)
        response = self._connection.getresponse().read().decode().strip()
        self._disconnect()
        return response

    def execute_get_command(self, name):
        self._connect()
        self._connection.request("GET", name)
        response = self._connection.getresponse().read().decode().strip()
        self._disconnect()
        return response

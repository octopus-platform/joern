import re
import socket


class OctopusShellConnection(object):
    def __init__(self, host, port):
        self._socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self._host = host
        self._port = port

    def connect(self):
        self.socket.connect((self.host, self.port))

    def request(self, request):
        request = "{}\0".format(request.strip())
        request = request.encode()
        self.socket.sendall(request)

    def getresponse(self):
        response = b""
        while True:
            chunk = self.socket.recv(2048)
            response += chunk
            try:
                if response[-1] == 0x00:
                    break
            except:
                pass

        response = response[:-1].decode().strip()
        return response

    def run_command(self, command):
        self.request(command)
        response = self.getresponse()
        if re.match("\[.*Exception\]", response):
            raise RuntimeError(response)
        return response.split('\n')

    def quit(self):
        self.run_command("quit")

    def toggle_json(self):
        self.run_command("toggle_json")

    def close(self):
        self._socket.close()

    @property
    def socket(self):
        return self._socket

    @property
    def host(self):
        return self._host

    @property
    def port(self):
        return self._port

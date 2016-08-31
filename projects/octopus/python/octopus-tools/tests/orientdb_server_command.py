import unittest

from octopus.server.server_command import ServerCommand

class TestServerCommand(unittest.TestCase):

    def testUnreachableServer(self):

        self.hostname = 'localhost'
        self.port = '1337'

        cmd = ServerCommand(self.hostname, self.port)
        self.assertRaises(ConnectionRefusedError, cmd.execute_get_command, "foo")

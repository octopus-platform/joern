
import unittest

from octopus.server.orientdb.orientdb_server_command import OrientDBServerCommand

class TestOrientDBServerCommand(unittest.TestCase):

    def testUnreachableServer(self):

        self.hostname = 'localhost'
        self.port = '1337'

        cmd = OrientDBServerCommand(self.hostname, self.port)
        self.assertRaises(ConnectionRefusedError, cmd.execute_get_command, "foo")

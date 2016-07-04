import unittest

from octopus.server.orientdb.orientdb_shell_mananger import OrientDBShellManager


class TestOrientDBShellManager(unittest.TestCase):
    def testUnreachableServer(self):
        self.hostname = 'localhost'
        self.port = '1337'

        shell_manager = OrientDBShellManager(self.hostname, self.port)
        shells = shell_manager.list()
        self.assertRaises(ConnectionRefusedError, list, shells)

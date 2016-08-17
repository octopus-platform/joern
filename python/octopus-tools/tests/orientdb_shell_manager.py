import unittest

from octopus.server.shell_mananger import ShellManager


class TestShellManager(unittest.TestCase):
    def testUnreachableServer(self):
        self.hostname = 'localhost'
        self.port = '1337'

        shell_manager = ShellManager(self.hostname, self.port)
        shells = shell_manager.list()
        self.assertRaises(ConnectionRefusedError, list, shells)

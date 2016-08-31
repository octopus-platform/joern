import unittest

from octopus.server.python_shell_interface import PythonShellInterface


class TestPythonShellInterface(unittest.TestCase):

    def setUp(self):
        self.databaseName = 'testDatabase'
        self.hostname = 'localhost'
        self.port = '2480'

    def testUnreachableServer(self):

        self.port = '1337'
        self.assertRaises(ConnectionRefusedError, self._connectToDatabase)

    def testConnect(self):
        self._connectToDatabase()

    def testGremlinQuery(self):
        self._connectToDatabase()
        retList = self.shell_interface.runGremlinQuery("g")
        self.assertEqual(len(retList), 1)

    def _connectToDatabase(self):
        self._configureShellInterface()
        self.shell_interface.connectToDatabase()

    def _configureShellInterface(self):
        self.shell_interface = PythonShellInterface()
        self.shell_interface.setHost(self.hostname)
        self.shell_interface.setPort(self.port)
        self.shell_interface.setDatabaseName(self.databaseName)


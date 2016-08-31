class OctopusPlugin(object):
    def __init__(self, executor):
        self._executer = executor
        self._pluginname = None
        self._classname = None
        self._settings = {}

    def execute(self):
        return self._executer.execute(self._pluginname, self._classname, self._settings)

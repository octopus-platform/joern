import sys
from distutils.core import setup

if (sys.version_info.major, sys.version_info.minor) < (3, 4):
    sys.exit("Python < 3.4 not supported.")

setup(
    name='octopus-pylib',
    version='0.1',
    packages=['octopus', 'octopus.server', 'octopus.server.orientdb', 'octopus.plugins'],
    url='https://github.com/octopus-platform/octopus-pylib',
    license='LGPLv3',
)

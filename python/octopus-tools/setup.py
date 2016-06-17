import sys
from distutils.core import setup

if (sys.version_info.major, sys.version_info.minor) < (3, 4):
    sys.exit("Python < 3.4 not supported.")

setup(
    name='octopus-tools',
    version='0.1',
    license='LGPLv3',
    scripts=['scripts/octopus-project']
)

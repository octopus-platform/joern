import sys
from distutils.core import setup

if (sys.version_info.major, sys.version_info.minor) < (3, 4):
    sys.exit("Python < 3.4 not supported.")

setup(
    name='octopus-tools',
    version='0.1',
    license='LGPLv3',
    url='https://github.com/octopus-platform/octopus-tools',
    packages=['octopus', 'octopus.server', 'octopus.plugins', 'octopus.shell',
              'octopus.shell.completer', 'octopus.shell.onlinehelp', 'octopus.shell.config', 'octopus.importer',
              'octopus.shelltool'],
    package_dir={
        'octopus.shell': 'octopus/shell',
        'octopus.shell.config': 'octopus/shell/config'
    },
    package_data={
        'octopus.shell': ['data/banner.txt'],
        'octopus.shell.config': ['data/octopus_shell.ini']
    },
    scripts=['scripts/octopus-project', 'scripts/octopus-plugin', 'scripts/octopus-shell', 'scripts/octopus-csvimport', 'scripts/octopus-dgsimport']
)

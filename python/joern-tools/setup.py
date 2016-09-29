import os, sys

from setuptools import setup, find_packages
import os, fnmatch

if (sys.version_info.major, sys.version_info.minor) < (3, 4):
    sys.exit("Python < 3.4 not supported.")

def read(fname):
    return open(os.path.join(os.path.dirname(__file__), fname)).read()

def getScripts():
    x = []
    for (dirpath, dirnames, filenames) in os.walk('scripts'):
        if os.path.split(dirpath)[1] not in ['data']:
            x.extend(os.path.join(dirpath,f) for f in filenames)
    return x

setup(
    name = "joern",
    version = "0.3",
    author = "Fabian Yamaguchi",
    author_email = "f.yamaguchi@tu-braunschweig.de",
    description = "Tools for code analysis based on joern.",
    license = "GPLv3",
    url = "http://github.com/octopus-platform/joern-tools/",
    long_description = read('README.md'),
    packages = find_packages(),
    data_files=[ ('EGG-INFO/scripts/data', ['scripts/plotting/data/plotconfig.cfg'])],
    scripts = getScripts(),
    install_requires = ['pygraphviz', 'chardet'],
    zip_safe = False
)

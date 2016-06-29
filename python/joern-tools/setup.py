import os

from setuptools import setup, find_packages
import os, fnmatch

def read(fname):
    return open(os.path.join(os.path.dirname(__file__), fname)).read()

def getScripts():
    x = []
    for (dirpath, dirnames, filenames) in os.walk('tools'):
        x.extend(os.path.join(dirpath,f) for f in filenames)
    return x

setup(
    name = "joerntools",
    version = "0.1",
    author = "Fabian Yamaguchi",
    author_email = "fyamagu@gwdg.de",
    description = "Tools for code analysis based on joern.",
    license = "GPLv3",
    url = "http://github.com/fabsx00/joern-tools/",
    long_description = read('README.md'),
    packages = find_packages(),
    package_data={"joerntools": ['steps/*',]},
    scripts = getScripts(),
    install_requires = ['joern >= 0.1', 'pygraphviz', 'chardet'],
    dependency_links = ['https://github.com/fabsx00/python-joern/tarball/master/#egg=joern-0.1'],
    zip_safe = False
)


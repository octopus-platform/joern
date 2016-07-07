import configparser
import os

USER_CONFIG_FILE = os.path.expanduser('~/.josh.ini')
GLOBAL_CONFIG_FILE = os.path.join(os.path.dirname(__file__), 'data', 'josh.ini')

config = configparser.ConfigParser()
config.read([GLOBAL_CONFIG_FILE, USER_CONFIG_FILE])

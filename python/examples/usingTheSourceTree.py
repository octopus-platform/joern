import sys, os

sys.path.append(os.getcwd())
from libjoern import JoernSteps

j = JoernSteps()

# Get all child-directories of the root directory

cmd = """ g.v(0).out('IS_PARENT_DIR_OF').filepath """

for x in j.executeGremlinCmd(cmd): print x

# Get all directories:

cmd = """ queryNodeIndex('type:Directory').filepath """

for x in j.executeGremlinCmd(cmd): print x

# Get all subdirectories of a given directory

dirname = '/home/fabs/sourceCode/targets/pidgin-2.10.7/libpurple'

cmd = """ queryNodeIndex('filepath:%s').out().filter{it.type == 'Directory'}.filepath""" % (dirname)

for x in j.executeGremlinCmd(cmd): print x

# Get names of all functions contained in a specified file:

filename = 'filepath:/home/fabs/sourceCode/targets/pidgin-2.10.7/libpurple/protocols/jabber/iq.c'

cmd = """ queryNodeIndex('%s').out('IS_FILE_OF').filter{ it.type == 'Function'}.functionName
""" % (filename)

for x in j.executeGremlinCmd(cmd): print x

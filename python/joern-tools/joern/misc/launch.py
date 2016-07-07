
import subprocess
import os

def launch(cmd):
    """
    Run the shell command `cmd` and return an iterator
    for stdout.
    """

    proc = subprocess.Popen(cmd,stdout=subprocess.PIPE, shell=True)
    return proc.stdout

def runUntilCompletion(cmd):
    os.system(cmd)

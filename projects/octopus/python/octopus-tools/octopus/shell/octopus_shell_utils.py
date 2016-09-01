import os


def reload(shell, path):
    if os.path.isdir(path):
        reload_dir(shell, path)
    elif os.path.isfile(path):
        reload_file(shell, path)


def reload_dir(shell, directory):
    for dirpath, dirnames, filenames in os.walk(directory):
        dirnames[:] = [d for d in dirnames if not d.startswith('.')]
        filenames[:] = [f for f in filenames if not f.startswith('.')]
        for filename in filenames:
            _, ext = os.path.splitext(filename)
            if ext == ".groovy":
                reload_file(shell, os.path.abspath(os.path.join(dirpath, filename)))


def reload_file(shell, filename):
    print("loading file {} ...".format(filename), end=' ')
    try:
        with open(filename, 'r') as f:
            shell.run_command(f.read())
    except IOError:
        print("failed")
    else:
        print("done")

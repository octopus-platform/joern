import os
import xml.etree.ElementTree as ET


class OnlineHelp(object):
    def __init__(self, docdir):
        self.help = None
        self._load_documentation(docdir)

    def _load_documentation(self, docdir):
        self.help = ET.fromstring('<doc></doc>')

        for dirpath, dirnames, filenames in os.walk(docdir):
            dirnames[:] = [d for d in dirnames if not d.startswith('.')]
            filenames[:] = [f for f in filenames if not f.startswith('.')]
            for filename in filenames:
                _, ext = os.path.splitext(filename)
                if ext == ".xml":
                    self._load_docfile(os.path.abspath(os.path.join(dirpath, filename)))

    def _load_docfile(self, filename):
        root = ET.parse(filename).getroot()
        if root.tag == "doc":
            for children in root:
                self.help.append(children)

    def get_help_for_step(self, stepname):
        for step in self.help:
            if step.get('name') == stepname:
                return StepRecord(step)
        return None


class Record(object):
    def __init__(self, tag):
        self._tag = tag

    def __repr__(self):
        return ET.tostring(self._tag).decode().strip()


class HelpRecord(Record):
    @property
    def tag(self):
        return self._tag.tag

    @property
    def name(self):
        return self._tag.get('name')

    @property
    def description(self):
        return self._tag.find('description').text

    @property
    def argumentlist(self):
        args = self._tag.find('argumentlist')
        if args:
            return sorted([ArgumentRecord(arg) for arg in args], key=lambda arg: arg.pos)
        else:
            return []


class StepRecord(HelpRecord):
    def __str__(self):
        arg_name_list = [arg.name for arg in self.argumentlist]
        if self.argumentlist:
            arg_desc_list = ["\t{}".format(str(arg)) for arg in self.argumentlist]
        else:
            arg_desc_list = ["\tNone"]
        mapping_list = ["\t{}".format(str(map)) for map in self.mappings]

        header_fmt = "Help for {name}({arglist}) ({tag})"
        header = header_fmt.format(
            name=self.name,
            arglist=', '.join(arg_name_list),
            tag=self.tag)

        return "{}\n\n{}\n\nArguments\n{}\nMappings\n{}\n".format(
            header,
            self.description,
            "\n".join(arg_desc_list),
            "\n".join(mapping_list)
        )

    @property
    def mappings(self):
        mappings = self._tag.findall('mapping')
        if mappings:
            return [MappingRecord(mapping) for mapping in mappings]
        else:
            return [MappingRecord(ET.fromstring("<mapping></mapping>"))]


class ArgumentRecord(Record):
    @property
    def name(self):
        return self._tag.get('name')

    @property
    def description(self):
        return self._tag.find('description').text

    @property
    def pos(self):
        return int(self._tag.get('pos'))

    def __str__(self):
        return "{}: {}".format(self.name, self.description)


class MappingRecord(Record):
    @property
    def inpipe(self):
        inpipe = self._tag.findall('in')
        if inpipe:
            return [i.text for i in inpipe]
        else:
            return ["*"]

    @property
    def outpipe(self):
        outpipe = self._tag.findall('out')
        if outpipe:
            return [o.text for o in outpipe]
        else:
            return ["*"]

    def __str__(self):
        return "{{{}}} --> {{{}}}".format(
            ', '.join(self.inpipe),
            ', '.join(self.outpipe))

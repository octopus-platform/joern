#!/usr/bin/env python2

import sys, os
from TraversalTool import TraversalTool

class LookupTool(TraversalTool):
    
    # @Override

    def __init__(self, DESCRIPTION):
        TraversalTool.__init__(self, DESCRIPTION)
        
        self.argParser.add_argument('-c', '--complete',
                                    action='store_true',
                                    default=False,
                                    help = """ Output the complete
                                    node, not just its ID.""")
        
        self.argParser.add_argument('-g', '--gremlin',
                                    action='store_true',
                                    default=False, help = """query is
                                    a gremlin traversal as opposed to a lucene
                                    query""")

        
        self.argParser.add_argument('-a', '--attributes',
                                    nargs='+', type = str,
                                    help="""Attributes of interest""",
                                    default = [])

    # @Override
    def queryFromLine(self, line):
        
        if self.args.gremlin:
            return line
        
        luceneQuery = line
        if luceneQuery.startswith('id:'):
            id = luceneQuery.split(':')[1]
            query = 'g.v(%s)' % (id)
        else:
            query = """queryNodeIndex('%s')""" % (luceneQuery)
        
        return self.addOutputTransformation(query)
        

    def addOutputTransformation(self, query):
        """
        Calculate the output transformation term based on command line
        options.
        """

        if self.args.complete:
            return query + '.transform{ [it.id, it]}'
        elif self.args.attributes != []:
            term = '.transform{ [it.id, ['
            for attr in self.args.attributes:
                term += 'it.%s,' % (attr)
            term = term[:-1]
            term += ']]}'
            return query + term
        else:
            return query + '.transform{[it.id, []]}'
    

    # @Override

    def outputResult(self, result):
        for r in result:
            self._outputRecord(r)

    
    def _outputRecord(self, record):
        
        if self.args.gremlin:
            self.output(str(record) + '\n')
            return

        id, node = record
        
        if type(node) == list:
            keys = self.args.attributes
            keyValPairs = [(keys[i] + ':' + str(node[i])) for i in range(len(keys))]
        else:
            node = node.properties
            keys = [k for k in node]
            keyValPairs = [str(k) + ':' + str(node[k]) for k in keys]
            keyValPairs.sort()
        
        keyValPairs = [k.replace('\t', '') for k in keyValPairs]
        
        self.output('%s\t%s\n' % (id, '\t'.join(keyValPairs)))
    
    

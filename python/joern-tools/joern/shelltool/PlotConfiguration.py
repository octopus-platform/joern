#!/usr/bin/env python3

import re

class PlotConfiguration:
    def __init__(self):
        self.config = []
    def _matchRulePattern(self,pattern_type,pattern_rule,element_properties):
        if pattern_rule == '*': return True
        k,v = pattern_rule.split('.',maxsplit=1)
        prop = element_properties.get(k)
        if not prop: return False
        if v == '*': return True
        if v == prop: return True
        return False
    def getLayout(self,element_type,element_properties):
        layout_params = {}
        for pt_elt,pt_type,pt_rule,pt_val in self.config:
            if pt_elt == element_type and pt_type == 'layout':
                if self._matchRulePattern(pt_type,pt_rule,element_properties):
                    layout_params = self.createLayoutParams(layout_params,pt_val)
        return layout_params
    def getElementLayout(self,graph_element):
        return self.getLayout(graph_element.getElementType(),graph_element.getProperties())
    def getDisplayItems(self,element_type,element_properties):
        display_items = []
        for pt_elt,pt_type,pt_rule,pt_val in self.config:
            if pt_elt == element_type and pt_type == 'display':
                if self._matchRulePattern(pt_type,pt_rule,element_properties):
                    display_items = self.createDisplayItems(display_items,element_properties,pt_val)
        return [ x[1] for x in display_items ]
    def getElementDisplayItems(self,graph_element):
        """return a list of items to display that can be formatted. It is a
        list of lists containing [key,value] or [value]."""
        return self.getDisplayItems(graph_element.getElementType(),graph_element.getProperties())
    def _getItemsFromSpec(self,spec,data,withkey=False):
        if spec == "*":
            if withkey:
                return [(k,[k,v]) for k,v in data.items()]
            else:
                return [(k,[v]) for k,v in data.items()]
        try:
            if withkey:
                return [ (spec,[ spec, data[spec] ]) ]
            return [ (spec,[ data[spec] ]) ]
        except KeyError:
            return []
    def createDisplayItems(self,current_items,element_properties,values):
        if len(values)>0 and values[0] == "+":
            items = current_items
            key_specs = values[1:].split(",")
        else:
            items = []
            key_specs = values.split(",")
        for ks in key_specs:
            if ks == '': continue
            if ks[0] == '&':
                items += self._getItemsFromSpec(ks[1:],element_properties,withkey=True)
            elif ks[0] == '-':
                # remove spec from items
                items = [ x for x in items if x[0] != ks[1:] ]
                pass
            else:
                items += self._getItemsFromSpec(ks,element_properties,withkey=False)
        return items
    def createLayoutParams(self,current_items,values):
        if len(values)>0 and values[0]=="+":
            layout_items = current_items
            vs = values[1:].split(",")
        else:
            layout_items = {}
            vs = values.split(",")
        l = [ tuple(v.split("=",maxsplit=1)) for v in vs if v != '']
        layout_items.update( dict([ v for v in l if len(v)==2 ]) )
        return layout_items

    def _parseConfigLine(self,line):
        try:
            pattern_selector,pattern = line.split('=',maxsplit=1)
            pattern_element,pattern_type = pattern_selector.split('.',maxsplit=1)
            pattern_rule,pattern_value = pattern.split(':',maxsplit=1)
            return [ pattern_element, pattern_type, pattern_rule, pattern_value ]
        except ValueError:
            return None
    def parse(self,configfile):
        for l in configfile.readlines():
            if re.match(r'^\s*#',l): continue
            rule = self._parseConfigLine(l.strip())
            if rule:
                self.config.append(rule)


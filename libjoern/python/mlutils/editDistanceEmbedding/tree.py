#!/usr/bin/env python
# -*- coding: utf-8 -*-
#Author: Tim Henderson and Tyler Goeringer
#Email: tim.tadh@gmail.com and tyler.goeringer@gmail.com
#For licensing see the LICENSE file in the top level directory.

class Node(object):
    """A generic representation of a tree node. Includes a string label and a
    list of a children."""

    def __init__(self, label):
        """Creates a node with the given label. The label must be a string for
        use with the PQ-Gram algorithm."""
        self.label = label
        self.children = list()

    def addkid(self, node, before=False):
        """Adds a child node. When the before flag is true, the child node will
        be inserted at the beginning of the list of children, otherwise the
        child node is appended.  """
        if before:  self.children.insert(0, node)
        else:   self.children.append(node)
        return self
        
##### Helper Methods #####
        
def split_tree(root, delimiter=""):
    """Traverses a tree and explodes it based on the given delimiter. Each node
    is split into a null node with each substring as a separate child. For
    example, if a node had the label "A:B:C" and was split using the delimiter
    ":" then the resulting node would have "*" as a parent with the children
    "A", "B", and "C". By default, this explodes each character in the label as
    a separate child node. Relies on split_node."""
    if(delimiter == ''):
        sub_labels = [x for x in root.label]
    else:
        sub_labels = root.label.rsplit(delimiter)
    if len(sub_labels) > 1: # need to create a new root
        new_root = Node("*", 0)
        for label in sub_labels:
            new_root.children.append(Node(label, 0))
        heir = new_root.children[0]
    else: # root wasn't split, use it as the new root
        new_root = Node(root.label, 0)
        heir = new_root
    for child in root.children:
        heir.children.extend(split_node(child, delimiter))
    return new_root

def split_node(node, delimiter):
    """Splits a single node into children nodes based on the delimiter
    specified."""
    if(delimiter == ''):
        sub_labels = [x for x in node.label]
    else:
        sub_labels = node.label.rsplit(delimiter)
    sub_nodes = list()
    for label in sub_labels:
        sub_nodes.append(Node(label, 0))
    if len(sub_nodes) > 0:
        for child in node.children:
            sub_nodes[0].children.extend(split_node(child, delimiter))
    return sub_nodes


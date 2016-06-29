#!/bin/bash
# Get k nearest neighbors for second entry in the TOC and output code

sed -n '2p' ./bagOfWords/TOC | ./knn.py --dirname bagOfWords/ | ./location.py

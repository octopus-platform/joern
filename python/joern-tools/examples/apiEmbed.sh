#!/bin/bash

# Represent all functions using 'memcpy' by its Callees and the types of parameters and local variables

echo 'type:Parameter AND code:"TIFFDirEntry * dir"' | ./lookup.py --attributes functionId | awk '{split($2,a,":"); print "functionId:" a[2]}' | ./lookup.py --attributes type functionId code | egrep 'type:(Callee|ParameterType|IdentifierDeclType)' | awk '{split($3, a, ":"); split($4,b,":"); print a[2] "\t" b[2]}' | ./demux.py --outputDir bagOfWords

sally -n 1 --input_format=dir bagOfWords/data/ bagOfWords/embedding.libsvm --hash_file bagOfWords/feats.gz --vect_embed=cnt


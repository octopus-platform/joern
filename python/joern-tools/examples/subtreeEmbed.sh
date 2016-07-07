echo 'type:Symbol' | ./lookup.py --attributes functionId | head -n 10 | awk '{split($2,a,":"); print a[2]}' | ./getAst.py | ./astlabel.py | ./ast2features.py | ./demux.py

sally -n 1 --input_format=dir out/data/ out/embedding.libsvm --hash_file out/feats.gz --vect_embed=tfidf

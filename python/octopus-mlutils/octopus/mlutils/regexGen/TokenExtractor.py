import polygraph.sig_gen.lcseq_tree as lcseq_tree

class TokenExtractor:

    def __init__(self):
        self.seqExtractor = lcseq_tree.LCSeqTree(pname="Token Subsequence", fname="lcseq",
                                                 kfrac=1, tokenize_all=True,
                                                 tokenize_pairs=False,
                                                 minlen=2, do_cluster=False,
                                                 k = 1)
        
    def extract(self, M):
        """
        Extract tokens common to the strings in M.
        Appends and extra '$' of string to mark
        the end of the string
        """

        tokens = self.seqExtractor.train(M)[0].tuplesig
        retval = list(tokens)
        retval.append('$')
        return retval
        

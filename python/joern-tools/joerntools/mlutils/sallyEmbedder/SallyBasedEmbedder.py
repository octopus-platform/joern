
import subprocess
import shlex

class SallyBasedEmbedder:
    
    def embed(self, directory, embType = 'tfidf'):

        cmd = (
                'sally '
                '--quiet '
                '--input_format dir '
                '--output_format libsvm '
                '--ngram_len 1 '
                '--ngram_delim %0a '
                '--vect_embed {vect_embed} '
                '--hash_file {directory}/feats.gz '
                '{directory}/data '
                '{directory}/embedding.libsvm '
        ).format(
                vect_embed = embType,
                directory = directory
        )

        subprocess.check_call(shlex.split(cmd))

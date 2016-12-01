echo 'type:Callee AND code:memcpy' | lookup.py -a functionId | awk '{split($2,a,":"); print a[2]; }'

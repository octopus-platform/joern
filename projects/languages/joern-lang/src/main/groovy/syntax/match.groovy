
/**
   Match descriptions as presented in the paper. Please note, that
   tradeoffs in efficiency are made for increased robustness and ease
   of formulation.
 */

/** 
    
*/

addStep('_match', { def args -> def p = args[0];
 delegate.astNodes().filter(p)
})

/**
 Walk the tree into the direction of the root
 stopping at the enclosing statement and output
 all parents that match the supplied predicate. Note, that this may
 include the enclosing statement node.
*/

addStep('matchParents', { def args -> def p = args[0];
    delegate.until(__.start().has(NODE_ISCFGNODE, 'True'))
            .emit() // no filtering here, because we filter at the end
            .repeat(__.start().parents())
            .unfold()
            .filter(p) // must filter here, because enclosing statement node is implicitly emitted.
})

/**
   
*/

addStep('arg', { def args -> def f = args[0]; def i = args[1];
    delegate.astNodes()
    .has('type','CallExpression')
    .where( out(AST_EDGE).has('type','Callee').values('code').is(P.eq(f)))
    .out(AST_EDGE).has('type','ArgumentList')
    .ithChildren(i)
})

/**
   
*/

addStep('param', { def args -> def x = args[0];
    delegate.astNodes().has('type','Parameter').has('code',textRegex(x))
})

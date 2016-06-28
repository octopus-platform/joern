
/**
   Match descriptions as presented in the paper. Please note, that
   tradeoffs in efficiency are made for increased robustness and ease
   of formulation.
 */

/** 
    
*/

_match = { def args -> def p = args[0];
  _().astNodes().filter(p)
}

matchChildren = { def args -> def p = args[0]; def q={false}; if(args.size() > 1) q = args[1];
  _().children().loop(1){ !q(it.object) }{ p(it.object) }
}

/**
 Walk the tree into the direction of the root
 stopping at the enclosing statement and output
 all parents that match the supplied predicate. Note, that this may
 include the enclosing statement node.
*/

matchParents = { def args -> def p = args[0]; def q={false}; if(args.size() > 1) q = args[1];
  _().parents().loop(1){it.object.isCFGNode != 'True' && !q(it.object) }{ p(it.object) }
}


/**
   
*/

arg = { def args -> def f = args[0]; def i = args[1];
  _().astNodes().filter{ it.type == 'CallExpression' && it.code.startsWith(f)}
  .out(AST_EDGE).filter{ it.childNum == '1' }.out(AST_EDGE).filter{ it.childNum == i}
}

/**
   
*/

param = { def args -> def x = args[0];
  p = { it.type == 'Parameter' && it.code.matches(x) } 
  _()._match(p)
  
}

////////////////////////////////////////////////////////////////////
// = User-defined Gremlin steps for code analysis. = The "language"
// joern offers on top of Gremlin to allow you to formulate complex
// queries without too much pain.  If you have a good idea for a
// custom step, for example from reoccuring patterns in your queries,
// make a proposal and I'm likely to include it.
///////////////////////////////////////////////////////////////////

import java.util.regex.*;
import com.tinkerpop.blueprints.pgm.impls.neo4j.util.*;


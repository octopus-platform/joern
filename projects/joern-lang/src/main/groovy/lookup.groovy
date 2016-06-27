queryNodeIndex = { luceneQuery ->

	queryStr = 'SELECT * FROM V WHERE [childNum,code,filepath,functionId,key,location,name,nodeType] LUCENE "' + luceneQuery + '"';
	query = new com.orientechnologies.orient.core.sql.OCommandSQL(queryStr);
	g.getRawGraph().command(query).execute().toList()._().transform{ g.v(it.getIdentity()) }
}

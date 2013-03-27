package lucene;

import org.apache.lucene.document.Field;

public class LuceneUtils
{
	public static Field createField(String name, String value)
	{
		return new Field(name, value, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES);
	}
}

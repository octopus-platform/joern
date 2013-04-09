package lucene;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

public class LuceneUtils
{
	public static Field createField(String name, String value)
	{		
		return new Field(name, value, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS);
	}

	public static NumericField createIDField(String name, int id)
	{
		return new NumericField(name, Field.Store.YES, true).setIntValue(id);
	}
}

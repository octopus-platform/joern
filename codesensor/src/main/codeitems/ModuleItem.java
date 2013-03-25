package main.codeitems;

import java.util.LinkedList;
import java.util.List;

public class ModuleItem extends CodeItem
{
	List<CodeItem> items = new LinkedList<CodeItem>();
	String filename;
	
	public void addItem(CodeItem item)
	{
		items.add(item);
	}
}

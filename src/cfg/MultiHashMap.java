package cfg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MultiHashMap
{
	HashMap<Object, List<Object>> hashMap =
			new HashMap<Object, List<Object>>();
	
	public Iterator<Entry<Object, List<Object>>> getEntrySetIterator()
	{
		return hashMap.entrySet().iterator();
	}
	
	public void add(Object key, Object val)
	{
		List<Object> valList = hashMap.get(key);
		if(valList == null){
			valList = new LinkedList<Object>();
			hashMap.put(key, valList);
		}
		valList.add(val);
	}

	public void addMultiHashMap(MultiHashMap otherHashMap)
	{
		Set<Entry<Object, List<Object>>> entrySet = otherHashMap.hashMap.entrySet();
		Iterator<Entry<Object, List<Object>>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<Object, List<Object>> pair = it.next();
			Iterator<Object> it2 = pair.getValue().iterator();
			while(it2.hasNext()){
				add(pair.getKey(), it2.next());
			}
		}
	}
	
	public void remove(Object key, Object val)
	{
		List<Object> dstList = hashMap.get(key);
		if(dstList == null)
			return;
		dstList.remove(val);
	}
	
	public void removeAllForKey(Object key)
	{
		hashMap.put(key, new LinkedList<Object>());
	}
	
	public int size()
	{
		int s = 0;
		Set<Entry<Object, List<Object>>> entrySet = hashMap.entrySet();
		Iterator<Entry<Object, List<Object>>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<Object, List<Object>> pair = it.next();
			s += pair.getValue().size();
		}
		return s;
	}
	
	public List<Object> getListForKey(BasicBlock src)
	{
		return hashMap.get(src);
	}
	
}

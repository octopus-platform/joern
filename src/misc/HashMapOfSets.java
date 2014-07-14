package misc;

// This is the same as MultiHashMap. Only difference is
// that LinkedList has been replaced by HashSet.
// Clean this up at some point and use a generic to
// reduce duplication.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapOfSets
{

	public HashMap<Object, HashSet<Object>> hashMap = new HashMap<Object, HashSet<Object>>();

	public Iterator<Entry<Object, HashSet<Object>>> getEntrySetIterator()
	{
		return hashMap.entrySet().iterator();
	}

	public Iterator<Object> getKeySetIterator()
	{
		return hashMap.keySet().iterator();
	}

	public void add(Object key, Object val)
	{
		HashSet<Object> valList = hashMap.get(key);
		if (valList == null)
		{
			valList = new HashSet<Object>();
			hashMap.put(key, valList);
		}
		valList.add(val);
	}

	public void addHashMapOfSets(HashMapOfSets otherHashMap)
	{
		Set<Entry<Object, HashSet<Object>>> entrySet = otherHashMap.hashMap
				.entrySet();
		Iterator<Entry<Object, HashSet<Object>>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Entry<Object, HashSet<Object>> pair = it.next();
			Iterator<Object> it2 = pair.getValue().iterator();
			while (it2.hasNext())
			{
				add(pair.getKey(), it2.next());
			}
		}
	}

	public void remove(Object key, Object val)
	{
		HashSet<Object> dstList = hashMap.get(key);
		if (dstList == null)
			return;
		dstList.remove(val);
	}

	public void removeAllForKey(Object key)
	{
		hashMap.put(key, new HashSet<Object>());
	}

	public int size()
	{
		int s = 0;
		Set<Entry<Object, HashSet<Object>>> entrySet = hashMap.entrySet();
		Iterator<Entry<Object, HashSet<Object>>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Entry<Object, HashSet<Object>> pair = it.next();
			s += pair.getValue().size();
		}
		return s;
	}

	public HashSet<Object> getListForKey(Object k)
	{
		return hashMap.get(k);
	}

}

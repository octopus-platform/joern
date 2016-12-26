package misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MultiHashMap<K, V>
{

	private HashMap<K, List<V>> hashMap = new HashMap<K, List<V>>();

	public Set<Entry<K, List<V>>> entrySet()
	{
		return hashMap.entrySet();
	}

	public Set<K> keySet()
	{
		return hashMap.keySet();
	}

	public boolean containsKey(K key)
	{
		return hashMap.containsKey(key);
	}

	public Iterator<Entry<K, List<V>>> getEntrySetIterator()
	{
		return entrySet().iterator();
	}

	public Iterator<K> getKeySetIterator()
	{
		return keySet().iterator();
	}

	/**
	 * Associates the specified value with the specified key. If the map
	 * previously contained a mapping for the key, the new value is appended.
	 * 
	 * @param key
	 *            key with which the specified value is to be associated
	 * 
	 * @param values
	 *            value to be associated with the specified key
	 */
	public void add(K key, V value)
	{
		if (containsKey(key))
		{
			hashMap.get(key).add(value);
		}
		else
		{
			List<V> list = new LinkedList<V>();
			list.add(value);
			hashMap.put(key, list);

		}
	}

	/**
	 * Associates the specified values with the specified key. If the map
	 * previously contained a mapping for the key, the new values are appended.
	 * 
	 * @param key
	 *            key with which the specified values are to be associated
	 * 
	 * @param values
	 *            values to be associated with the specified key
	 */
	public void addAll(K key, List<V> values)
	{
		if (containsKey(key))
		{
			hashMap.get(key).addAll(values);
		}
		else
		{
			hashMap.put(key, values);
		}
	}

	public void addAll(MultiHashMap<K, V> otherMap)
	{
		for (Entry<K, List<V>> entry : otherMap.entrySet())
		{
			addAll(entry.getKey(), entry.getValue());
		}
	}

	@Deprecated
	/**
	 * @deprecated
	 * Use addAll instead.
	 */
	public void addMultiHashMap(MultiHashMap<K, V> otherHashMap)
	{
		Set<Entry<K, List<V>>> entrySet = otherHashMap.entrySet();
		Iterator<Entry<K, List<V>>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Entry<K, List<V>> pair = it.next();
			Iterator<V> it2 = pair.getValue().iterator();
			while (it2.hasNext())
			{
				add(pair.getKey(), it2.next());
			}
		}
	}

	/**
	 * Removes the value from list associated with the specified key if it
	 * exists.
	 * 
	 * @param key
	 * @param value
	 * @return true if the map was modified otherwise false.
	 */
	public boolean remove(K key, V value)
	{
		if (containsKey(key))
		{
			return get(key).remove(value);
		}
		return false;
		// List<V> dstList = hashMap.get(key);
		// if (dstList == null)
		// return false;
		// dstList.remove(val);
		// return true;
	}

	@Deprecated
	/**
	 * @deprecated
	 * Use removeAll instead.
	 */
	public void removeAllForKey(K key)
	{
		hashMap.put(key, new LinkedList<V>());
	}

	/**
	 * Removes the mapping for the specified key from this map if present.
	 * 
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 */
	public List<V> removeAll(K key)
	{
		return hashMap.remove(key);
	}

	@Deprecated
	/**
	 * @deprecated
	 * Use totalSize instead.
	 */
	// this could return hashMap.size()
	public int size()
	{
		int s = 0;
		Set<Entry<K, List<V>>> entrySet = hashMap.entrySet();
		Iterator<Entry<K, List<V>>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Entry<K, List<V>> pair = it.next();
			s += pair.getValue().size();
		}
		return s;
	}

	/**
	 * Calculates the total count of all values in this map.
	 * 
	 * @return the total count of all values.
	 */
	public int totalSize()
	{
		int size = 0;
		for (List<V> values : hashMap.values())
		{
			size += values.size();
		}
		return size;
	}

	@Deprecated
	/**
	 * @deprecated
	 * Use get instead.
	 */
	public List<V> getListForKey(K k)
	{
		return hashMap.get(k);
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this
	 *         map contains no mapping for the key
	 */
	public List<V> get(K key)
	{
		return hashMap.get(key);
	}

}

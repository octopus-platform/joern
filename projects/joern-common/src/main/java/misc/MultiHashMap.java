package misc;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Malte TODO:
 * Consider deprecating this class entirely and using org.apache.commons.collections4.MultiValuedMap instead.
 */
public class MultiHashMap<K, V> implements Map<K, List<V>> {

	private HashMap<K, List<V>> hashMap = new HashMap<K, List<V>>();

	
	/* Methods prescribed by Map interface */
	/* *********************************** */

	@Override
	public int size() {
		return this.hashMap.size();
	}
	
	@Override
	public boolean isEmpty() {
		return this.hashMap.isEmpty();
	}
	
	@Override
	public boolean containsKey(Object key) {
		return this.hashMap.containsKey(key);
	}
	
	@Override
	public boolean containsValue(Object value) {
		return this.hashMap.containsValue(value);
	}
	
	@Override
	public List<V> get(Object key) {
		return this.hashMap.get(key);
	}
	
	/**
	 * Associates the specified list of values with the specified key in this map.
	 * 
	 * Note:
	 * If the map previously contained a mapping for the key, the old list of values is *replaced* by
	 * the specified list of values.
	 * In order to *add* all values from a specified list of values to a list of values previously
	 * contained for a key, use addAll(K,List<V>) instead.
	 */
	@Override
	public List<V> put(K key, List<V> value) {
		return this.hashMap.put(key, value);
	}
	
	/**
	 * Removes *all* values associated with the specified key.
	 * 
	 * Note:
	 * In order to remove only a specific key-value mapping, use removeMapping(K,V) instead.
	 */
	@Override
	public List<V> remove(Object key) {
		return this.hashMap.remove(key);
	}	
	
	/**
	 * Copies all of the mappings from the specified map to this map.
	 * The effect of this call is equivalent to that of calling put(k, v) on this map
	 * once for each mapping from key k to value v in the specified map.
	 * 
	 * Note:
	 * If the map previously contained a mapping for a key also contained in the specified map,
	 * the old list of values is *replaced* by the list of values in the specified map.
	 * In order to *add* all values contained in the list of values for a key k in the specified map
	 * to the list of values for the same key k in this map (if it exists), use addAll(Map<? extends K, ? extends List<V>>) instead.
	 */
	@Override
	public void putAll(Map<? extends K, ? extends List<V>> m) {
		this.hashMap.putAll(m);
	}

	@Override
	public void clear() {
		this.hashMap.clear();
	}
	
	@Override
	public Set<K> keySet() {
		return this.hashMap.keySet();
	}
	
	@Override
	public Collection<List<V>> values() {
		return this.hashMap.values();
	}

	@Override
	public Set<Entry<K, List<V>>> entrySet() {
		return this.hashMap.entrySet();
	}

	
	/* Standard methods */
	/* **************** */
	
	
	@Override
	public boolean equals(Object o) {
		if( o instanceof Map)
			return entrySet().equals(((Map<?,?>)o).entrySet());
		return false;
	}

	@Override
	public int hashCode() {
		int ret = 0;
		for( Entry<K,List<V>> e : entrySet())
			ret += e.hashCode();
		return ret;
	}

	@Override
	public String toString() {
		
		return this.hashMap.toString();
	}


	/* Methods implemented by MultiHashMap in addition to those prescribed by Map */
	/* ************************************************************************** */

	/**
	 * Removes a key-value mapping from the map.
	 * 
	 * The item is removed from the collection mapped to the specified key. Other values attached to that key are unaffected.
	 * 
	 * If the last value for a key k is removed, returns an empty collection for a subsequent get(k).
	 * 
	 * @param key   the key to remove from
	 * @param value the item to remove
	 * 
	 * @return true if the mapping was removed, false otherwise
	 */
	public boolean removeMapping(K key, V value) {
		
		if(containsKey(key))
			return get(key).remove(value);
		return false;
	}	
	
	/**
	 * Associates the specified value with the specified key. If the map
	 * previously contained a mapping for the key, the new value is *appended*.
	 * 
	 * @param key
	 *            key with which the specified value is to be associated
	 * 
	 * @param values
	 *            value to be associated with the specified key
	 *            
	 * @return true if the map changed as a result of this put operation, or false otherwise
	 */
	public boolean add(K key, V value) {
		
		if(containsKey(key))
			return this.hashMap.get(key).add(value);
		else {
			List<V> list = new LinkedList<V>();
			list.add(value);
			List<V> oldlist = put(key, list);
			return null == oldlist ? true : !oldlist.equals(list);
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
	 *            
 	 * @return true if the map changed as a result of this put operation, or false otherwise
	 */
	public boolean addAll(K key, List<V> values) {
		
		if(containsKey(key))
			return this.hashMap.get(key).addAll(values);
		else {
			this.hashMap.put(key, values);
			return true;
		}
	}
	
	/**
	 * Adds all of the mappings from the specified map to this map.
	 * The effect of this call is equivalent to that of calling addAll(k, v) on this map
	 * once for each mapping from key k to value v in the specified map.
	 * 
 	 * @return true if the map changed as a result of this put operation, or false otherwise
	 */
	public boolean addAll(Map<? extends K, ? extends List<V>> map) {
		
		boolean ret = false;
		
		for( K key : map.keySet())
			ret = addAll( key, map.get(key));
		
		return ret;
	}
	
	/**
	 * Calculates the total count of all values in this map.
	 * 
	 * @return the total count of all values.
	 */
	public int totalSize() {
		
		int size = 0;
		
		for(List<V> values : values())
			size += values.size();
		
		return size;
	}
	
}

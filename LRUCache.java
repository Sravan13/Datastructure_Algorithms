import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.*/

public class LRUCache {
	
	LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
	int capacity ;

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
		
	}
	

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	    
	public int get(int key) {
		
		if(cache.containsKey(key)) {
			int value = cache.remove(key);
			cache.put(key, value);
			return value;
		}else {
			return -1;
		}
	        
	}
	    
	public void put(int key, int value) {
		
		if(cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key, value);
		}else {
			
			if(cache.size() == capacity) {
				Set<Entry<Integer, Integer>> entries = cache.entrySet();
				Entry<Integer, Integer>  tempEntry = entries.iterator().next();
				cache.remove(tempEntry.getKey());
			}
			
			cache.put(key, value);
		}
	        
	}

}

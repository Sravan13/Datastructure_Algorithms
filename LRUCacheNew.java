import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCacheNew {
	
	LinkedHashSet<Integer> cache = null;
	int capacity = 0;
	
	LRUCacheNew(int capacity){
		this.capacity = capacity;
		cache = new LinkedHashSet<>();
	}
	
	private boolean get(int item) {
		
		if(!cache.contains(item)) return false;
		
		cache.remove(item);
		cache.add(item);
		
		return true;
		
	}
	
	public void refer(int item){
		
		if(!get(item)) {
			
			if(cache.size() == capacity) {
				cache.remove(cache.iterator().next());
			}
			cache.add(item);
			
		}
		
	}
	
	public void display() {
		
		LinkedList<Integer> linkedList = new LinkedList<>(cache);
		
		Iterator<Integer> itr = linkedList.descendingIterator();
		 while (itr.hasNext())
	            System.out.print(itr.next() + " ");
		
	}

	public static void main(String[] args) {
		
		LRUCacheNew ca = new LRUCacheNew(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
	}

}

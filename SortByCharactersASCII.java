import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class SortByCharactersASCII {

	public static void main(String[] args) {
		SortByCharactersASCII frequency = new SortByCharactersASCII();
		frequency.frequencySort("Sravan");
	}
	
	public String frequencySort(String s) {
		
		PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(s.length(), new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
				int num = o1.compareTo(o2);
				return num == 0 ? 0 : num >= 1 ? -1 : 1;
			}
		});
		
		for(char c : s.toCharArray()) {
			priorityBlockingQueue.add((int)c);
		}
		
		StringBuffer sb = new StringBuffer();
		while(!priorityBlockingQueue.isEmpty()) {
			sb.append((char)priorityBlockingQueue.poll().intValue());
		}
		
        return sb.toString();
    }

}

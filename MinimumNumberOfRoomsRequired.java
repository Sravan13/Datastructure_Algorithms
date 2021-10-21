import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2
 */
public class MinimumNumberOfRoomsRequired {

	public static void main(String[] args) {
		
		
		//int [][] arr = {{30, 75}, {0, 50}, {60, 150}};
		//int [][] arr = {{0, 30}, {5, 10}, {15, 20}};
		int [][] arr = {{5, 7}, {0, 7}, {5, 9}};
		MinimumNumberOfRoomsRequired roomsRequired = new MinimumNumberOfRoomsRequired();
		roomsRequired.getMinimumRoomsRequired(arr);

	}
	
	public int getMinimumRoomsRequired(int [][] rooms){
		
		List<RoomInterval> roomIntervals = new ArrayList<RoomInterval>();
		for(int i=0;i<rooms.length;i++) {
			roomIntervals.add(new RoomInterval(rooms[i][0], rooms[i][1]));
		}
		
		Comparator<RoomInterval> c = (RoomInterval o1, RoomInterval o2) -> {
				
				if(o1.getEnd() == o2.getEnd()) {
					return o1.getStart() - o2.getStart();
				}else {
					return o1.getEnd() - o2.getEnd();
				}
				
		};
			
		Collections.sort(roomIntervals, c);
		
		PriorityQueue<RoomInterval> pq = new PriorityQueue<>(c);
		
		for(RoomInterval roomInterval : roomIntervals) {
			
			if(pq.isEmpty()) {
				pq.add(roomInterval);
			}else {
				
				RoomInterval  peekInterval = pq.peek();
				
				while(peekInterval.getEnd() < roomInterval.getStart()) {
					pq.poll();
					
					if(pq.isEmpty()) break;
					
					peekInterval = pq.peek();
				}
				
				pq.add(roomInterval);
				
			}
		}
		
		return pq.size();
		
		
	}
	
	

}

class RoomInterval {
	
	int start;
	int end;
	
	public RoomInterval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}

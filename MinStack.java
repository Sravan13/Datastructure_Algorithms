import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinStack {
	
	Stack<Integer> originalStack = new Stack<>();
	Stack<Pojo> minStack = new Stack<>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		
		minStack.getMin();
		minStack.pop();
		
		minStack.getMin();
		minStack.pop();
		
		minStack.getMin();
		minStack.pop();
		
		minStack.getMin();
		
	}
	

    public MinStack() {
        
    }
    
    public void push(int x) {
    	
    	originalStack.push(x);	
    	if( minStack.isEmpty() || ( x < minStack.peek().getKey() ) ) {		
    		minStack.push(new Pojo(x));
    	}else if(x == minStack.peek().getKey()) {
    		Pojo tempPojo = minStack.peek();
    		tempPojo.setValue(tempPojo.getValue()+1);
    	}else {
    		
    		Stack<Pojo> queue = new Stack<>();
    		
    		boolean isGreater = false;
    		  		   		
    		while(!minStack.isEmpty()) {
    			  			
    			if(x == minStack.peek().getKey()) {
    				minStack.peek().setValue(minStack.peek().getValue()+1);
    				isGreater = false;
    				break;
    			}else if(x < minStack.peek().getKey()) {
    				minStack.push(new Pojo(x));
    				isGreater = false;
    				break;
    			}else {   				
    				Pojo pojo = minStack.pop();        			
        			queue.add(pojo);
        			isGreater = true;
    			}
    			
    		}
    		
    		if(isGreater) {
    			minStack.push(new Pojo(x));
    		}
    		
    		while(!queue.isEmpty()) {
    			Pojo p = queue.pop();
    			minStack.push(p);    			
    		}
    		
    	}
        
    }
    
    public void pop() {
    	int x = originalStack.pop();
    	
    	Stack<Pojo> queue = new Stack<>();
    	
    	while(!minStack.isEmpty()) {
			
			Pojo tempPojo = minStack.pop();			
						
			if(x == tempPojo.getKey()) {
				
				if( tempPojo.getValue()-1 > 0 ) {
					tempPojo.setValue(tempPojo.getValue()-1);
					queue.add(tempPojo);
				}
				
				break;
			}else {
				queue.add(tempPojo);	
			}
		}
    	
    	while(!queue.isEmpty()) {
			Pojo tempPojo = queue.pop();
			minStack.push(tempPojo);    			
		}
    }
    
    public int top() {
    	return originalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek().getKey();
    }
    
    

}

class Pojo {
	
	int key;
	int value;
	
	
	
	public Pojo(int key) {
		super();
		this.key = key;
		this.value = 1;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}

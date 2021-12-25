/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side 
 * of x in array. Elements for which no greater element exist, consider next greater element as -1. The next greater elements should be printed in 
 * same order as input array.

	Examples: 
	Input : arr[] = [4, 5, 2, 25} 
	Output : 5 25 25 -1
	
	Input : arr[] = [4, 5, 2, 25, 10} 
	Output : 5 25 25 -1 -1 
 */

public class NextGenerationElementForEveryElement {

	public static void main(String[] args) {
	    
	    //int [] arr = {4, 5, 2, 25} ;
	    //int [] arr = {25, 4, 5, 2, 10};
	    int arr[] = {4, 5, 2, 25, 10};
		nextGenerationElementForEveryElement(arr);
		
	}
	
   public static int [] nextGenerationElementForEveryElement(int [] arr){
       
       int [] targetArr = new int[arr.length];
       int size = arr.length;
       targetArr[size-1] = -1;
       
       for(int i=size-2;i>=0;i--){
           
           if(arr[i] < arr[i+1]){
               targetArr[i] = arr[i+1];
           }else{
               targetArr[i] = arr[i] < targetArr[i+1] ?  targetArr[i+1] : -1;
           }
       }
       
       for(int i=0;i<targetArr.length;i++){
           System.out.print(targetArr[i]+" ");
       }
       
       return targetArr;
        
    }

}

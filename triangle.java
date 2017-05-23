import java.util.*;
public class Test1 {

	/*
	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below. 
	For example, given the following triangle 
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]

	The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11). 
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
	*/

	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	    ArrayList<Integer> d=new ArrayList<>();
	    d.add(triangle.get(0).get(0));
	    for(int i=1;i<triangle.size();i++) {
	    	int begin=d.get(0).intValue();
	    	int end=d.get(i-1).intValue();
	    	for(int j=1;j<i;j++) {
	            int num1=d.get(j-1).intValue();
	            int num2=d.get(j).intValue();
	            int min=num1;
	            if(num2<min) {
	            	min=num2;
	            }
	            d.set(j,min+triangle.get(i).get(j).intValue());
	        }
	    	int now1=triangle.get(i).get(i).intValue();
	    	d.add(end+now1);
            int now=triangle.get(i).get(0).intValue();
	    	d.set(0,begin+now);
	    }
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<d.size();i++) {
	    	if(min>d.get(i)) {
	    		min=d.get(i);
	    	}
	    }
	    return min;
	}
}
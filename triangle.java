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
	    int []d=new int [1];
	    d[0]=triangle.get(0).get(0).intValue();
	    for(int i=1;i<triangle.size();i++) {
	    	d=dp(d,triangle,i);
	    }
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<d.length;i++) {
	    	if(min>d[i]) {
	    		min=d[i];
	    	}
	    }
	    return min;
	}
	public static int [] dp(int []d,ArrayList<ArrayList<Integer>> triangle,int now) {
		int []p=new int [d.length+1];
		p[0]=d[0]+triangle.get(now).get(0).intValue();
		p[now]=d[now-1]+triangle.get(now).get(now).intValue();
    	for(int j=1;j<now;j++) {
	        int min=d[j-1];
	        if(d[j]<min) {
	        	min=d[j];
	        }
	        p[j]=min+triangle.get(now).get(j).intValue();
	    }
		return p;
	}
}
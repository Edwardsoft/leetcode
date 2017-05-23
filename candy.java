public static int candy(int[] ratings) {
	int []d=new int [ratings.length];
	for(int i=0;i<ratings.length;i++) {
		d[i]=1;
	}
	int sum=0;
	for(int i=1;i<ratings.length;i++) {
		if(ratings[i]>ratings[i-1]) {
			d[i]=d[i-1]+1;
			sum+=d[i];
		}
	}
	for(int i=ratings.length-1;i>0;i--) {
		if(ratings[i]<ratings[i-1]&&ratings[i]<ratings[i-1]) {
			d[i-1]=d[i]+1;
			sum+=d[i];
		}
	}
	sum+=d[0];
	return sum;
}
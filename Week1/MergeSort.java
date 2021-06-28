/*worst case time complexity O (n(log n)
 * Space complexity O  (n(log n) ) - if we do not clear the memory occupied by arrays after each level for left and right
 * Space complexity O  (n) - if we clear the memory occupied by arrays after each level for left and right
 * Divide and conquer
 * Recursive
 * Stable -> Preserves the relative order of the element
 * Not an In-place algorithm -> the extra space taken to store indices and other stuff is dependent on size of input array 
 * 
 * 
 * The idea here is to find a mid point in the array and break it down in left and left side array along the mid point. Then you take the left side 
 * array and find again mid point of it and break it down along the mid point. This will happen recursively. It will continue to happen until you array
 * size is less than 2. With this happening is the array we will have base left array and right array with one element and they will be combined with 
 * sorting. Now this chain will go up and combine the 2 sorted arrays to the final array.
 */

public class MergeSort
{
	public static void main(String[] args) {
		
		int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48};
		MSort(sample); 
		System.out.println("\n-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <-  the result should look like");
		for (int i = 0; i < sample.length; i++) {
			System.out.printf("%d, ",sample[i]);
		}
	}
	
	private static int[] MSort(int[] sample) {
		// TODO Auto-generated method stub
		if(sample.length<2)
		{
			return sample;
		}
		int mid=sample.length/2;
		int[] lside=new int[mid];
		int[] rside=new int[sample.length-mid];
		int i;
		for(i=0;i<mid;i++)
		{
			lside[i]=sample[i];
		}
		for(;i<sample.length;i++)
		{
			rside[i-mid]=sample[i];
		}
		
		//to print the iterations 
		System.out.println("\nlside");
		for (int e = 0; e < lside.length; e++) {
			System.out.printf("%d, ", lside[e]);
		}
		System.out.println("\nrside");
		for (int e = 0; e < rside.length; e++) {
			System.out.printf("%d, ", rside[e]);
		}
		
		MSort(lside);
		MSort(rside);
		
		Merge(lside,rside,sample);
		
		System.out.println("\nmerged");
		for (int e = 0; e < sample.length; e++) {
			System.out.printf("%d, ", sample[e]);
		}
		
		return sample;
	}
	
	private static void Merge(int[] sample1, int[] sample2,int[] sample) {
		
		int i=0,j=0,k=0;
		
		for( ;sample1.length>i && sample2.length>j;k++ )
		{
			if(sample1[i]<sample2[j])
			{
				sample[k]=sample1[i];
				i++;
			}
			else
			{
				sample[k]=sample2[j];
				j++;
			}
		}
		
		if(i==sample1.length)
		{
			for(;sample2.length>j;k++)
			{
				sample[k]=sample2[j];
				j++;
			}	
		}
		else
		{
			for(;sample1.length>i;k++)
			{
				sample[k]=sample1[i];
				i++;
			}	
		}
	}

}

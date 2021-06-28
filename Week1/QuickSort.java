/* worst case time complexity O (n*n)
 * most widely used alogirth for sorting
 * average case time complexity O (n(log n)
 * worst case O (n*n)
 * Divide and conquer
 * Recursive
 * Not stable
 * In-place algorithm -> takes almost a constant space of memory
 * Most practical choice for sorting
 */
public class QuickSort {

	public static void main(String[] args) throws InterruptedException {
		int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48};
//		int[] sample = { 7,2,1,6,8,5,3,4};
		QSort(sample,0,sample.length-1);
		
		System.out.println("\n-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <-  the result should look like");
		
		for (int i = 0; i < sample.length; i++) {
			System.out.printf("%d, ",sample[i]);
		}
	}

	private static void QSort(int[] sample,int start,int end) throws InterruptedException {
		
		if(start>end)
			return;
		
		
		int pindex=Partion(sample,start,end);
		//System.out.println("reached"+pindex);
		//Thread.sleep(5);
		
		QSort(sample,start,pindex-1);
		QSort(sample,pindex+1,end);
		
		
	}
	
	
//	private static int Partion(int[] sample, int start, int end) { //making middle element pivot
//		MFNJD
//		int pivot= (start+end)/2;
//		int pindex=start;
//		int flag=0;
//		
//		for(int i=start;i<=end;i++) 
//		{
//			if(i==pivot)
//				continue;
//			if(sample[pivot]>sample[i])
//			{
//				
//				if(pindex==pivot)
//				{
//					pindex++;
//					flag=1;
//				}
//				swap(sample,i,pindex);
//				pindex++;
//			}
//		}
//		if(flag==1)
//			pindex--;
//		swap(sample,pindex,pivot);
//		
//		System.out.println();
//		System.out.println(sample[pindex]+" is moved to index=" +pindex+"for "+start+" end "+end);
//		for (int e = 0; e < sample.length; e++) {
//			System.out.printf("%d, ", sample[e]);
//		}
//		return pindex;
//		
//	}

	private static void swap(int[] sample, int i, int j) {
		int temp=sample[i];
		sample[i]=sample[j];
		sample[j]=temp;
	}
	
	private static int Partion(int[] sample, int start, int end) {
		int pivot=sample[end];
		int pindex=start;
		
		for(int i=start;i<end;i++) // at end we have pivot
		{
			if(sample[i]<=pivot)
			{
				swap(sample,i,pindex);
				pindex++;
			}
		}
		
		swap(sample,end,pindex);
		
		//for printing the iterationss
		
		System.out.println(pivot+" is moved to index=" +pindex);
		for (int e = 0; e < sample.length; e++) {
			System.out.printf("%d, ", sample[e]);
		}
		
		System.out.println();
		
		return pindex;
	}
	
}

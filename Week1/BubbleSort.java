//time complexity O (n^2)
// best case O (n)
public class BubbleSort {
	/*starts by comparing the first element to next and then if the first element is bigger it is swapped. Now this element at position 2 is compared
	 * to next element, swapped if it bigger. This continues through out the array, this makes the largest element to bubble up to the last position.
	 * Now again we will will pass through the array again, this time to bubble up the second largest element. We will pass till n-1 position
	 * Each pass will bubble up the respective ordered largest number to the end of array. We will pass through only remaining elements.
	 * The moment we went through the array without a single pass, it means array is already sorted. No need of further passes
		*/
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			int[] sample = { 7, 55, 3, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 };
			int res[] = BSort(sample); 
			System.out.println("-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <- the result should look like");
			for (int i = 0; i < res.length; i++) {
				System.out.printf("%d, ", res[i]);
			}
		}
	
		private static int[] BSort(int[] sample) {
	
			for(int j=0;j<sample.length-1;j++)
			{
				// flag ensure the loop breaks when there has been no swap in one iteration which indirectly means array is already sorted
				int flag=0;
				for(int i=0;i<sample.length-j-1;i++)
				{
					if(sample[i]>sample[i+1])
					{
						int temp=sample[i];
						sample[i]=sample[i+1];
						sample[i+1]=temp;
						flag=1;  // makes sure that one swap has been made
					}
				}
				
				//to print the iterations 
				for (int e = 0; e < sample.length; e++) {
					System.out.printf("%d, ", sample[e]);
				}
				System.out.println();
				
				
				if(flag==0)
				{
					break;
				}
			}
			
			return sample;
		}
	
	}
	
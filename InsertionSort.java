//time complexity O (n^2)
// best case O (n)
public class InsertionSort {
	/* The idea here is to start from sorted array of size 1 and keep adding element to it and keep it sorted on each step.
	 * We start from second element in the array and see if array is sorted or not, then we add the third element and start
	 *  comparing it with the element in the already sorted array from end. We will keep shifting element 1 by 1 if they are greater 
	 *  than this element. Then in next iteration we will have 4th element and we will start comparing it with the already sorted array
	 *  from end and find a appropriate place for it. This was we sort the whole array by adding an element with each iteration to the 
	 *  sorted array to have the output as sorted array.
	 */
		public static void main(String[] args) {
	
			int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 };
			int res[] = ISort(sample); 
			System.out.println("-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <- the result should look like");
			for (int i = 0; i < res.length; i++) {
				System.out.printf("%d, ", res[i]);
			}
		}
	
		private static int[] ISort(int[] sample) {
			
			for(int i=1;i<sample.length;i++)
			{
				int temp=sample[i];
				int j;
				for(j=i;j>0;j--)
				{
					if(sample[j-1]>temp)
					{
						sample[j]=sample[j-1];
					}
					else
					{
						break; //break the loop if swapping didn't happen because that means number has made to the int jright position
					}
				}
				sample[j]=temp;
				
				//to print the iterations 
				for (int e = 0; e < sample.length; e++) {
					System.out.printf("%d, ", sample[e]);
				}
				System.out.println();
				
			}
			return sample;
		}
	
	}
	
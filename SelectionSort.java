//time complexity O (n^2)
public class SelectionSort {
	/* search for the least element in whole array, swaps it with element at 1st position. In next iteration searches for the least element from
	 * position 2 to n and the least element is swapped with position 2. This continues through out the array
	 */
		public static void main(String[] args) {
			int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 };
	
			System.out.println("55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 <- input array ");
			//int res[]=SelectionSort(sample); // time complexity is n*n
	
			//int res[] = SelectionSortInPlace(sample);  // time complexity is n*n
			
			int res[] = SelectionSortInPlace1(sample); // time complexity is n*n
	
			System.out.println("-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <- the result should look like");
			for (int i = 0; i < res.length; i++) {
				System.out.printf("%d, ", res[i]);
			}
	
		}
	
		// this method is improvised version of SelectionSortInPlace
		private static int[] SelectionSortInPlace1(int[] sample) {
	
			for (int i = 0; i < sample.length; i++) {
				int pmin = i; 
				for (int j = i+1; j < sample.length; j++) {
					if (sample[pmin] > sample[j]) {
						pmin=j;
					}
				}
				int temp=sample[pmin];
				sample[pmin]=sample[i];
				sample[i]=temp;
				
				
				//to print the iterations 
				for (int e = 0; e < sample.length; e++) {
					System.out.printf("%d, ", sample[e]);
				}
				System.out.println();
				
			}
			return sample;
		}
		
		// this method makes changes in the same array
		private static int[] SelectionSortInPlace(int[] sample) {
	
			for (int i = 0; i < sample.length; i++) {
				int pos = 0;
				int min = 99999; // setting it to a very high number
				for (int j = i; j < sample.length; j++) {
					if (min > sample[j]) {
						min = sample[j];
						pos = j;
					}
				}
				sample[pos] = sample[i];
				sample[i] = min;
			}
			return sample;
		}
	
		// this method requires extra memory for storing the extra array
		static int[] SelectionSort(int[] sample) {
			int res[] = new int[sample.length];
	
			int min = 99999; // setting it to a very high number
			for (int i = 0; i < sample.length; i++) {
				if (min > sample[i]) {
					min = sample[i];
				}
				res[0] = min;
			}
	
			for (int i = 1; i < sample.length; i++) {
				min = 99999; // setting it to a very high number
				for (int j = 0; j < sample.length; j++) {
					if (min > sample[j] && sample[j] > res[i - 1]) {
						min = sample[j];
					}
				}
				res[i] = min;
			}
			return res;
		}
	
	}
	
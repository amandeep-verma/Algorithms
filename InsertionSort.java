public class InsertionSort {

	public static void main(String[] args) {

		int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 };
		int res[] = BSort(sample); 
		System.out.println("-12, 0, 3, 4, 7, 48, 53, 55, 77, 123, 213, 299, 443, 543, 3303 <- the result should look like");
		for (int i = 0; i < res.length; i++) {
			System.out.printf("%d, ", res[i]);
		}
	}

	private static int[] BSort(int[] sample) {
		
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
					break; //break the loop if swapping didn't happen because that means number has made to the right position
				}
			}
			sample[j]=temp;
		}
		return sample;
	}

}

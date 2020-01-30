
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] sample = { 55, 3, 7, 3303, 443, -12, 53, 77, 123, 4, 543, 0, 213, 299, 48 };
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
			if(flag==0)
			{
				break;
			}
		}
		
		return sample;
	}

}

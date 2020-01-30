import java.util.Scanner;

public class BinarySearchAlgorithm {

	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		int[] sample= {4, 7, 8, 9, 10, 50, 60, 70, 75, 88, 93, 94, 95, 99, 103, 115};
		System.out.println("enter the element to find in the array");
		int element=sc.nextInt();
		Search(sample,element);
		
		//for checking each element
//		for(int i=0;i<sample.length-1;i++)
//		{
//			Search(sample,sample[i]);
//		}
	}

	private static void Search(int[] sample, int target) {
		int Array_size=sample.length;
		int start=0;
		int end=Array_size-1;
		int mid=0;
		while(end>=start)
		{
			mid=(start+end)/2;
			if(sample[mid]>target)
			{
				end=mid-1;
			}
			else if(sample[mid]<target)
			{
				start=mid+1;
			}
			else if(sample[mid]==target)
			{
				break;
			}
		}
		
		if(end>=start)
		{
			System.out.println("element "+target+" is at position-> "+mid);
		}
		else 
		{
			System.out.println("element "+target+" is not in the array");
		}
	}
}

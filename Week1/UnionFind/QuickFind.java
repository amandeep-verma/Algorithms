import java.util.Scanner;

/* initialization = O(n)
 * find = O(1)
 * union = O(n)
 * for n union commands on n objects = O(n^2)
 */

public class QuickFind {

	int[] id;
	
	//constructor
	QuickFind(int size)
	{
		id= new int[size];
		for(int i=0;i<size;i++)
		{
			id[i]=i;
		}
	}
	
	public boolean connected(int a,int b)
	{
		return id[a]==id[b];
	}
	
	public void union(int a, int b)
	{
		int ValueOfa=id[a];
		int ValueOfb=id[b];
		for(int i=0;i<id.length;i++)
		{
			if(id[i]==ValueOfa)
			{
				id[i]=ValueOfb;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		QuickFind qf= new QuickFind(N);
		
		while(true)
		{
			int p =sc.nextInt();
			int q =sc.nextInt();
			if(!qf.connected(p,q))
			{
				qf.union(p,q);
				System.out.println(p+" "+q);
			}
		}
	}
}
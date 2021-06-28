import java.util.Scanner;

/* initialization = O(n)
 * find = O(n) <- for a really big tree (worst case) 
 * union = O(n) <- also includes cost of finding roots
 * for n union commands on n objects = O(n^2)
 */

public class QuickUnion {
	int[] id;

	// constructor
	QuickUnion(int size) {
		id = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	public int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public boolean connected(int a, int b) {
		return root(id[a]) == root(id[b]);
	}

	public void union(int a, int b) {
		int rootOfa = root(a);
		id[rootOfa] = root(b);
	}
	
//	public void print()
//	{
//		for(int i=0;i<id.length; i++)
//		{
//			System.out.printf("%d ",i);
//		}
//		System.out.println();
//		for(int i=0;i<id.length; i++)
//		{
//			System.out.printf("%d ",id[i]);
//		}
//		System.out.println("\n");
//	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		QuickUnion qf = new QuickUnion(N);
		while (true) {
			int p =sc.nextInt();
			int q =sc.nextInt();
			if (!qf.connected(p, q)) {
				qf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
	}
}
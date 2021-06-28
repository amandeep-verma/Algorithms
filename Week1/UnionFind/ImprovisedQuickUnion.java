import java.util.Scanner;

/* initialization = O (n)
 * find = O log2(1)
 * union = O log2(n)
 */

public class ImprovisedQuickUnion {
	
	int[] id;
	int[] sz;
	// constructor
	ImprovisedQuickUnion(int size) {
		id = new int[size];
		sz = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
			sz[i]=1;
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
		int i=root(a);
		int j=root(b);
		if(i==j)
			return;
		if(sz[i] < sz[j])
		{
			id[i]=j;
			sz[j]+=sz[i];
		}
		else {
			id[j]=i;
			sz[i]+=sz[j];
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ImprovisedQuickUnion qf = new ImprovisedQuickUnion(N);
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

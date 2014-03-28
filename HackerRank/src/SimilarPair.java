import java.util.Scanner;
import java.util.Vector;

class Node {
	
	public Node()
	{
		this.val = -1;
		this.children = null;
	}
	int val;
	Vector<Node> children;
}


public class SimilarPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int distance = sc.nextInt();
		
		boolean[][] graph = new boolean[n+1][n+1];
		
		for(int i=0; i<n; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = true;
		}

	}

}

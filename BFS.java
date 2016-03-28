import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	public static void main(String[] ar)
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[][] mat = new int[n][n];
		boolean visited[] = new boolean[n];
		
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < n;j++)
			{
				mat[i][j] = cin.nextInt();
			}
		}
		
		bfs(mat,visited,0);
	}
	public static void bfs(int[][] mat,boolean[] visited,int source)
	{
		visited[source] = true;		
		int node = 0;
		int edge_list[];
		LinkedList<Integer> q = new LinkedList();
		q.add(source);
		
		while(q.size() != 0)
		{
			node = q.removeFirst();
			System.out.println(node);
			edge_list = mat[node];
			for(int i = 0;i < edge_list.length;i++)
			{
				if(edge_list[i] == 1 && !visited[i])
				{
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
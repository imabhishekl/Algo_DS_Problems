import java.util.Scanner;

public class DFSMatrix {
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
		
		dfs(mat,visited,0);
	}
	public static void dfs(int[][] mat,boolean[] visited,int source)
	{
		visited[source] = true;
		System.out.println("Source : " + source);
		int edge_list[] = mat[source];
		int n = visited.length;
		
		for(int i = 0;i < n;i++)
		{
			if(edge_list[i] == 1 && !visited[i])
				dfs(mat,visited,i);
		}
	}
}
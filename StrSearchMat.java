import java.util.Scanner;


public class StrSearchMat 
{
	static int n = 0;
	public static void main(String ar[])
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Enter the string : ");
		String in = cin.next();
		System.out.println();
		System.out.print("Enter the matrix size : ");
		n = cin.nextInt();
		System.out.println();
		char arr[][] = new char[n][n];
		
		for(int i = 0;i < n;i++)
		{			
			arr[i] = cin.next().toCharArray();			
		}		
		System.out.println(isStringPresent(arr,in.toCharArray()));		
		cin.close();
	}
	
	public static String isStringPresent(char[][] arr,char[] in)
	{
		for(int i = 0;i < n;i++)
		{
			for(int j = 0 ;j < n;j++)
			{
				if(dfs(arr,i,j,-1,-1,in,0))
					return "YES";				
			}
		}		
		return "NO";
	}
	
	public static boolean isValid(int r,int c,int nr,int nc)
	{
		if(r > -1 && c > -1 && r < nr && c < nc)
			return true;
		else
			return false;
	}
	
	public static boolean dfs(char[][] mat,int r,int c,int or,int oc,char[] in,int index)
	{
		System.out.println(r + ":" + c + ":" + index);
		if(index == in.length)
			return true;
		if(isValid(r,c,n,n) && (r != or || c != oc) && mat[r][c] == in[index])
		{			
			index++;
			if(dfs(mat,r,c + 1,r,c,in,index))
				return true;
			if(dfs(mat,r,c - 1,r,c,in,index))
				return true;
			if(dfs(mat,r + 1,c + 1,r,c,in,index))
				return true;
			if(dfs(mat,r + 1,c - 1,r,c,in,index))
				return true;
			if(dfs(mat,r - 1,c + 1,r,c,in,index))
				return true;
			if(dfs(mat,r - 1,c - 1,r,c,in,index))
				return true;
			if(dfs(mat,r + 1,c,r,c,in,index))
				return true;
			if(dfs(mat,r - 1,c,r,c,in,index))
				return true;
		}
		return false;		
	}
}
 
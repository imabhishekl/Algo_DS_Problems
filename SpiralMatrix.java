import java.util.Scanner;


public class SpiralMatrix 
{
	public static void main(String  args[])
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < n;j++)
			{
				arr[i][j] = cin.nextInt();
			}
		}
		
		/*while()
		{
			while()
			{
				
			}
			
			while()
			{
				
			}
			
			while()
		}*/
		
		cin.close();
	}
}

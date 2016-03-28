import java.util.Scanner;

public class ArrayMan1 {
	public static void main(String arg[]) 
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int arr[] = new int[n];
		int res = 0;
		
		for(int i = 0;i < n;i++)
		{
			arr[i] = cin.nextInt();
		}
		
		res = findElement(arr,n);
		System.out.println(res);
		cin.close();
	}
	public static int findElement(int[] arr,int n)
	{
		int res = 0;
		int left_max[] = new int[n];
		int right_min[] = new int[n];
		
		left_max[0] = arr[0];
		right_min[n -1] = arr[n - 1];
		
		for(int i = 1; i < n;i++)
			left_max[i] = (left_max[i - 1] > arr[i])?left_max[i - 1]:arr[i];
			
		if(left_max[n - 1] == right_min[n - 1])
			return (n -1);
		
		for(int i = (n - 1); i > 0 ;i--)
		{
			//System.out.println(i);
			right_min[i - 1] = (right_min[i] >arr[i - 1])?arr[i - 1]:right_min[i];
			if(right_min[i - 1] == left_max[i - 1])
				return (i - 1);
		}
		return res;
	}
}

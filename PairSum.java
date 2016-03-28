import java.util.HashSet;
import java.util.Scanner;


public class PairSum {
	public static void main(String args[])
	{
		Scanner cin = new Scanner(System.in);
		int len = cin.nextInt();
		int[] arr = new int[len];
		int sum = 0;
		
		for(int i = 0;i < len;i++)
		{
			arr[i] = cin.nextInt();
		}
		
		sum = cin.nextInt();
		HashSet<Integer> hs = new HashSet();
		
		for(int i = 0;i < len;i++)
		{
			if(hs.contains(sum - arr[i]))
			{
				System.out.println("Found");
				break;
			}
			hs.add(arr[i]);
		}
	}
}

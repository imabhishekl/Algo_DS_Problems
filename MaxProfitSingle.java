import java.util.Scanner;


public class MaxProfitSingle {
	
	public static void main(String arg[])
	{
		Scanner cin = new Scanner(System.in);
		int no = cin.nextInt();
		int[] arr = new int[no];
		
		for(int i = 0;i < no;i++)
			arr[i] = cin.nextInt();
		System.out.println(getMaxProfit(arr));
		cin.close();
	}

	public static int getMaxProfit(int[] stock)
	{
		int max_profit = stock[1] - stock[0];
		int min = stock[0];
		
		for(int i = 1;i < stock.length;i++)
		{
			if(stock[i - 1] > stock[i])
			{
				if(min > stock[i])
					min = stock[i];
				continue;
			}
			if(min > stock[i])
				min = stock[i];			
			max_profit = stock[i] - min;			
		}
		
		return max_profit;
	}
}

import java.util.Scanner;

public class MultiplyArr {
	
	public static void main(String strp[])
	{
		Scanner cin = new Scanner(System.in);
		int size = 0;
		int in_arr[],out_arr[];
		System.out.println("Please enter the size of the array for the problem");
		
		size = cin.nextInt();
		in_arr = new int[size];
		
		System.out.println("Please enter the content of array");
		
		for(int i = 0;i < size;i++)
			in_arr[i] = cin.nextInt();
		
		out_arr = computeOutputArr(in_arr);
		
		for(int i = 0;i < out_arr.length;i++ )System.out.print(out_arr[i] + " ");
		
		cin.close();
	}
	
	public static int[] computeOutputArr(int[] arr)
	{
		int prev_mult = 1;
		int after_mult = 1;
		int[] o_arr = new int[arr.length];
		
		System.out.println("In compute" + arr.length);
		
		o_arr[0] = 1;
		
		for(int i = 0;i < (arr.length - 1);i++)
		{
			System.out.println(prev_mult);
			o_arr[i + 1] = prev_mult*arr[i];
			prev_mult = prev_mult*arr[i];
		}
		System.out.println("In compute");
		for(int j = (arr.length - 1); j >= 0 ;j--)
		{
			System.out.println(after_mult);
			o_arr[j] = after_mult*o_arr[j];
			after_mult = after_mult*arr[j];
		}
		
		return o_arr;
	}

}

import java.util.Scanner;


public class QuickSort {
	public static void main(String []args)
	{
		Scanner cin = new Scanner(System.in);
		int len = cin.nextInt();
		int[] arr = new int[len];
				
		for(int i = 0;i < len;i++)
		{
			arr[i] = cin.nextInt();
		}
		qsort(arr, 0, len - 1);
		
		for(int i:arr)
			System.out.print(" " + i);
		
	}
	
	public static void qsort(int arr[],int start, int end)
	{
		if(start >= end)
			return;
		int pivot = partition(arr, start, end);
		System.out.println(pivot);
		qsort(arr, 0,pivot - 1);
		qsort(arr,pivot + 1,end);
	}
	
	public static int partition(int arr[],int start,int end)
	{
		int pivot = arr[start];
		int id1 = start + 1;
		int id2 = end;
		int temp = 0;
		
		while(id1 < id2)
		{
			//System.out.println("as");
			while(arr[id1] < pivot && id1 < id2)
				id1++;
			while(arr[id2] > pivot && id2 > id1)
				id2--;
			temp = arr[id1];
			arr[id1] = arr[id2];
			arr[id2] = temp;
		}
		
		if(id1 < end)
		{
			temp = arr[id1];
			arr[start] = arr[id2];
			arr[id2] = temp;
		}
		return id1;
	}
}
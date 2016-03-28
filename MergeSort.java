import java.util.Scanner;


class MergeSortAPI
{
	int arr[];
	int sort_arr[];
	
	public MergeSortAPI(int n) {
		// TODO Auto-generated constructor stub
		arr = new int[n];
		sort_arr = new int[n];
	}
	
	public void setArray(int arr[])
	{
		this.arr = arr;
	}
	
	public int merge_sort()
	{
		split(0,arr.length - 1);
		return 1;
	}
	
	public void print() 
	{
		for(int i : arr)
		{
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
	void split(int low,int high)
	{
		int middle;
		if(low < high)
		{
			middle = (low + high)/2;
			//System.out.println(low + ":" + middle + ":" + high);
			split(low, middle);
			split(middle + 1,high);
			merge(low,middle,high);
		}
	}
	
	void merge(int low,int middle,int high)
	{
		int i,j,k;
		//System.out.println("Merge : " + low + ":" + middle + ":" + high);
		for(i = low,j = middle + 1,k = low; i<= middle && j<= high ;)
		{			
			if(arr[i] <= arr[j])
			{				
				sort_arr[k] = arr[i];
				//System.out.println(arr[i] + ":" + arr[j] + ":" + sort_arr[k]);
				k++;
				i++;
			}
			else
			{		
				sort_arr[k] = arr[j];
				//System.out.println(arr[i] + ":" + arr[j] + ":" + sort_arr[k]);
				k++;
				j++;
			}
		}
		
		while(i <= middle)
		{			
			sort_arr[k] = arr[i];
			//System.out.println(sort_arr[k] + ":" + arr[i]);
			k++;
			i++;
		}
		while(j <= high)
		{
			sort_arr[k] = arr[j];
			//System.out.println(sort_arr[k] + ":" + arr[j]);
			k++;
			j++;
		}
		for(int ii = low;ii <= high;ii++)
		{
			arr[ii] = sort_arr[ii];
		}
		//print();
	}
}

public class MergeSort
{
	public static void main(String arg[])
	{
		Scanner cin = new Scanner(System.in);		
		int n = cin.nextInt();
		int array[] = new int[n];
		MergeSortAPI ms = new MergeSortAPI(n);
		
		for(int i = 0;i < n;i++)
		{
			array[i] = cin.nextInt();
		}
		
		ms.setArray(array);
		ms.merge_sort();
		ms.print();
		cin.close();
	}
}
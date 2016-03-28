import java.util.Scanner;

class HS
{
	int arr[];
	int size;
	int temp_size;
	
	void input_array(Scanner cin)
	{
		size = cin.nextInt();
		arr = new int[size];
		for(int i = 0;i < size;i++)
		{
			arr[i] = cin.nextInt();
		}
	}
	
	void HeapSort()
	{
		temp_size = size;
		CreateHeap();
		temp_size = size;
		int temp;
		
		while(temp_size > 1)
		{
			temp = arr[temp_size - 1];
			arr[temp_size - 1] = arr[0];
			arr[0] = temp;
			temp_size--;
			heapify(0);
			System.out.println(arr[0]);			
		}
	}
	
	void CreateHeap()
	{
		int last_internal_node = (temp_size - 1)/2;
		for(int i = last_internal_node;i >= 0;i--)
		{			
			heapify(i);
		}
	}
	
	void heapify(int parent)
	{
		int left = 2*parent + 1;
		int right = 2*parent + 2;
		int test = parent,temp;		
				
		if(left < temp_size && arr[left] > arr[parent])
			test = left;
		if(right < temp_size && arr[right] > arr[test])
			test = right;								
		
		if(arr[parent] < arr[test])
		{
			temp = arr[parent];
			arr[parent] = arr[test];
			arr[test] = temp;
			heapify(test);
		}
	}
	
	void printArray()
	{
		System.out.println();
		for(int i:arr)
			System.out.print(i + " ");
	}
}


public class HeapSort 
{
	public static void main(String[] args)
	{
		Scanner  cin = new Scanner(System.in);
		HS hs = new HS();
		hs.input_array(cin);
		hs.HeapSort();
		hs.printArray();
		cin.close();
	}
}

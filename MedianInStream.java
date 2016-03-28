import java.io.*;
import java.util.*;

public class MedianInStream {
    static int arr1[];
    static int arr2[];
    static int size;
    static int id1 = 0;
    static int id2 = 0;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static float median = 0;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner cin = new Scanner(System.in);
        size = cin.nextInt();
                
        arr1 = new int[size];
        arr2 = new int[size];
        
        for(int i = 0;i < size;i++)
        {
            calMedian(cin.nextInt());
            System.out.println(median);
        	//insert(cin.nextInt(), RIGHT);
        }       
        
        //printArray(arr2, id2);
    }
    
    public static void calMedian(int elem)
    {
        if(id1 == id2) /* Same number of element */
        {
            if(elem < getTop(LEFT))
            {
                insert(elem,LEFT); 
                median = getTop(LEFT);
            }
            else
            {
                insert(elem,RIGHT);
                median = getTop(RIGHT);
            }
        }
        else if(id1 < id2) /* Left heap contains less */
        {
            if(elem < getTop(LEFT))
            {    
                insert(elem,LEFT); 
            }
            else
            {
                insert(removeTop(RIGHT),LEFT);
                insert(elem,RIGHT);   
            }
            median = (float)(getTop(LEFT) + getTop(RIGHT))/2;
        }
        else /* Left heap contains more */
        {
            if(elem < getTop(LEFT))
            {    
                insert(elem,LEFT); 
            }
            else
            {
                insert(removeTop(RIGHT),LEFT);
                insert(elem,RIGHT);   
            }
            median = (getTop(LEFT) + getTop(RIGHT)/2);
        }
    }
    
    public static int getTop(int heapType)
    {
        switch(heapType)
        {
            case LEFT:
                return arr1[0];
            case RIGHT:
                return arr2[0];
             default:
            	 return -1;
        }
    }
    
    public static void insert(int elem,int heapType)
    {
    	switch(heapType)
    	{
    		case LEFT:
    			arr1[id1] = elem;
    			id1++;
    			heapifyToRoot(arr1, id1 - 1, LEFT);
    			break;
    		case RIGHT:
    			arr2[id2] = elem;
    			id2++;
    			heapifyToRoot(arr2, id2 - 1, RIGHT);
    			break;
    	}
        
    }
    
    public static int removeTop(int heapType)
    {
    	int ret;
    	switch (heapType) 
    	{
			case LEFT:
				ret = arr1[0];
				arr1[0] = arr1[id1 - 1];
				id1--;
				heapify(arr1,0, LEFT,id1);
				break;
			case RIGHT:
				ret = arr2[0];
				arr2[0] = arr2[id2 - 1];
				id2--;
				heapify(arr2,0, RIGHT,id2);
				break;
			default:
				return -1;
		}
    	return ret;
    }
    
    public static void heapify(int arr[],int parent,int type,int size)
    {
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int swap_index = parent;
        int temp;
        
        if(left < size && compare(arr[swap_index],arr[left],type))
            swap_index = left;
        if(right < size && compare(arr[swap_index],arr[right],type))
            swap_index = right;
        
        //System.out.println("Swap Index " + swap_index);
        
        if(swap_index != parent)
        {
            temp = arr[parent];
            arr[parent] = arr[swap_index];
            arr[swap_index] = temp;
            heapify(arr,swap_index,type,size);
        }
    }     
    
    public static boolean compare(int i,int j,int type)
    {
    	switch(type)
    	{
    		case LEFT:
    			return i < j;
    		case RIGHT:
    			return i > j;
    		default:
    			return false;
    	}
    }
    
    public static void heapifyToRoot(int arr[],int index,int type)
    {    	
    	int parent = (index - 1)/2;
        int swap_index = parent;
        int temp;
        //System.out.println("arr[" + swap_index + "] = " + arr[swap_index] + " and " + "arr[" + index + "] = " + arr[index]);
        
        if(compare(arr[swap_index],arr[index],type))
            swap_index = index;
        
        if(swap_index != parent)
        {
            temp = arr[parent];
            arr[parent] = arr[swap_index];
            arr[swap_index] = temp;
            if(swap_index != 0)
            	heapifyToRoot(arr,(swap_index - 1)/2,type);
        }
    }
    
    public static void printArray(int[] arr,int size)
	{
		System.out.println();
		for(int i = 0;i < size;i++)
			System.out.print(arr[i] + " ");
	}
}
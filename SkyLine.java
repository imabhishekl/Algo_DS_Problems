import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;

class SortedList
{
	LinkedList<Integer> list = new LinkedList();
	int size = 0;
	public void add(int value)
	{
		if(list.size() == 0 || list.getFirst() < value)
		{
			list.addFirst(value);
			return;
		}
		int prev = list.getFirst();
		
		for(int i = 1;i < list.size();i++)
		{
			if(prev <= value && value <= list.get(i))
			{
				list.add(i, value);
				return;
			}
			prev = list.get(i);
		}
		list.addLast(value);
	}
	
	public void remove(int value)
	{
		for(int i = 0;i < list.size();i++)
		{
			if(list.get(i) == value)
			{
				list.remove(i);
				return;
			}
		}
	}
	
	public int get(int index)
	{		
		if(list.size() == 0)
			return 0;
		return list.get(index);
	}
}

public class SkyLine 
{
	public static SortedList pq = new SortedList();
	
	public static void main(String arg[])
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		int start[] = new int[n];
		int end[] = new int[n];
		int height[] = new int[n];
		
		for(int i = 0;i < n;i++)
		{			
			start[i] = cin.nextInt();
			height[i] = cin.nextInt();
			end[i] = cin.nextInt();			
		}
		getSkyLine(start,height,end);
		
		cin.close();
	}
	
	public static void getSkyLine(int[] start,int[] height,int[] end)
	{
		int x_axis = start[0];	
		int number_of_set = start.length;
		int current_max = -1;
		boolean is_end = false;
		HashMap<Integer,Integer> hm = new HashMap();
		
		hm.put(end[0], 0);
		pq.add(height[0]);
		System.out.println("(" + x_axis + "," + height[0] + ")");
		x_axis++;
		
		for(int i = 1;!is_end || hm.size() > 0;)
		{			
			if(i == number_of_set)
			{
				is_end = true;
				i--;
			}
			if(start[i] == x_axis || hm.get(x_axis) != null) // found starting or ending of a building
			{
				if(hm.get(x_axis) == null && start[i] == x_axis) // starting
				{
					//System.out.println("Starting of building at " + x_axis);
					hm.put(end[i], i);
					current_max = pq.get(0);
					pq.add(height[i]);					
					if(pq.get(0) != current_max)// new building is taller then current current one					
					{
						System.out.println("(" + x_axis + "," + pq.get(0) + ")");
					}
					if(!is_end)i++;
				}
				else if(start[i] != x_axis && hm.get(x_axis) != null) // found end of building
				{					
					//System.out.println("Ending of building at " + x_axis + " with height " + hm.get(x_axis) + ":" + height[hm.get(x_axis)]);
					current_max = pq.get(0);
					pq.remove(height[hm.get(x_axis)]);
					hm.remove(x_axis);					
					if(pq.get(0) != current_max)
						System.out.println("(" + x_axis + "," + pq.get(0) + ")");
				}
				else if(start[i] == x_axis && hm.get(x_axis) != null)// found both start and end of building
				{
					hm.put(end[i], i);
					current_max = pq.get(0);
					pq.add(height[i]);					
					pq.remove(height[hm.get(x_axis)]);
					hm.remove(x_axis);
					
					if(pq.get(0) != current_max)// new building is taller then current current one					
					{
						System.out.println("(" + x_axis + "," + pq.get(0) + ")");
					}
					if(!is_end)i++;
				}				
			}			
			x_axis++;
		}		
	}
}
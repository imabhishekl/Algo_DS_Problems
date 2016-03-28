import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PQ 
{
	static class PQSort implements Comparator<Integer>
	{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	}
	public static void main(String ar[])
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = cin.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n,new PQSort());
		System.out.println(pq.size());
		for(int i = 0; i < n;i++)
		{
			pq.offer(cin.nextInt());
		}
		System.out.println(pq.size());
		for(int i =0; i < n;i++)
			System.out.println(pq.poll());
		cin.close();
	}
}

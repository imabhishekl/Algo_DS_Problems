import java.util.Scanner;

class Node
{
	int node_id;
	Node last = null;
	Node next = null;
	Node(int node_id)
	{
		this.node_id = node_id;
	}
}

public class CountFriends {
	static boolean visited[];
	static Node node_id_list[];	
	
	public static void main(String arg[])
	{
		Scanner cin = new Scanner(System.in);
		int no_of_node = cin.nextInt();
		int no_of_frndship = cin.nextInt();
		int r,c;
		Node tmp;
		//int adj_mtr[][] = new int[no_of_node][no_of_node];
		int no_of_broken_node;
		int group = 0;
		int node_id;
		node_id_list = new Node[no_of_node];		
		visited = new boolean[no_of_node];
		
		for(int i = 0;i < no_of_node;i++)
		{
			visited[i] = false;
		}
		
		for(int i = 0;i < no_of_node; i++)
		{
			node_id_list[i] = new Node(i);	
			node_id_list[i].last = node_id_list[i];
			visited[i] = false;
		}
		
		for(int i = 0; i < no_of_frndship;i++)
		{
			r = cin.nextInt();
			c = cin.nextInt();
			//adj_mtr[r][c] = 1;
			tmp = new Node(c);
			node_id_list[r].last.next = tmp;
			node_id_list[r].last = tmp;
			node_id_list[r].last.next = null;
			//System.out.println("NULL : " + node_id_list[r].last.next);
		}
		
		/*for(int i = 0;i < no_of_node;i++)
		{
			tmp = node_id_list[i];
			System.out.println();
			while(tmp != null)
			{
				System.out.print(tmp.node_id + "->");
				tmp=tmp.next;
			}			
		}*/
		
		no_of_broken_node = cin.nextInt();
		for(int i = 0;i < no_of_broken_node;i++)
		{
			node_id = cin.nextInt();
			node_id_list[node_id].next = null;
			node_id_list[node_id].last = node_id_list[node_id];
			visited[node_id] = true;
			group++;
			//System.out.println(" NULL" + node_id);
		}
		
		for(int i = 0;i < no_of_node;i++)
		{
			tmp = node_id_list[i];
			System.out.println();
			//System.out.println("len of node_id is " + getLength(node_id_list[i]));
			while(tmp != null)
			{
				System.out.print(tmp.node_id + "->");
				tmp=tmp.next;
			}			
		}
		
		for(int i = 0;i < no_of_node;i++)
		{
			if(!visited[i])
			{
				System.out.println("calling for node " + node_id_list[i].node_id + " len:" + getLength(node_id_list[i]));
				traverse(node_id_list[i]);
				group++;
			}
		}
		System.out.println("Output : " + group);
		cin.close();
	}
	
	public static int getLength(Node node) 
	{
		int len = 0;
		while(node!=null)
		{
			len++;
			node = node.next;
		}
		return len;
	}
	
	public static void traverse(Node node)
	{		
 		//System.out.println("called traverse for " + node);
		//stk.push(node_id_list[index].node_id);
		//new_index = index;
		if(!visited[node.node_id])
		{
			System.out.println("Marking node " + node.node_id);
			//visited[node.node_id] = true;
			while(node != null)
			{
				//System.out.println("Inside");
				//System.out.println("Checking the node " + node.node_id);
				if(!visited[node.node_id] )
				{
					visited[node.node_id] = true;
					System.out.println("Traverse : " + node.next);
					if(node.next != null)
						traverse(node_id_list[node.next.node_id]);
					else
						return;
				}
				node = node.next;
			}
		}
	}
}

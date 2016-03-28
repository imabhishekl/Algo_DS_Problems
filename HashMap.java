import java.util.ArrayList;

class CHashMap {
	class Node
	{
		String key;
		int value;
	}
	int curr_size = 0;
	int size = 10;
	
	CHashMap(int size)
	{
		this.size = size;
		arr = new ArrayList[size];
		for(int i = 0;i < size;i++)
		{
			arr[i] = new ArrayList<CHashMap.Node>();
		}
	}
	
	int getIndex(String key)
	{
		int index = 0;
		char in[] = key.toCharArray();
		for(char c:in)
			index +=c;
		return index;
	}
	
	//ArrayList<ArrayList<Node>> arr = new ArrayList(10);
	ArrayList<Node>[] arr;
	
	void put(String key,int value)
	{
		Node temp = new Node();
		temp.key = key;
		temp.value = value;
		int index = getIndex(key)%size;
		
		ArrayList<Node> list = arr[index];
		list.add(list.size(),temp);
		curr_size++;
	}
	
	int get(String key)
	{
		Node temp;
		int index = getIndex(key)%size;
		ArrayList<Node> list = arr[index];
		int len = list.size();
		
		for(int i = 0;i < len;i++)
		{
			temp = list.get(i);
			if(temp.key.equals(key))
			{
				curr_size--;
				return temp.value; 
			}
		}
		return -1;
	}
}

class HashMap
{
	public static void main(String[] arg)
	{
		CHashMap hm = new CHashMap(10);
		
		hm.put("asd", 1);
		//hm.put("cd", 2);
		//hm.put("d", 3);
		//hm.put("a", 4);
		
		System.out.println(hm.get("asd"));
	}
}
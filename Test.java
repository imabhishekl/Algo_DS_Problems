import java.util.LinkedList;

class Trie
{
    Trie next;
    char data;
    int contains_name = 0;
    
    Trie(char data)
    {
        this.data = data;
    }
}

public class Test {
	public static void main(String arg[])
	{
		LinkedList<Integer> list = new LinkedList();
		list.add(5);
		list.add(15);
		list.add(1);
		System.out.println(list.get(1));
		list.add(1,8);
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		list.add(32);
		//System.out.println(list.get(1));
		list.remove(1);
		//System.out.println(list.get(1));
		/*Trie t = new Trie('a');
		
		Trie curr = t;
		
		//curr.next = new Trie('b');
		
		if(t.next == null)
			System.out.println("Here");
		else
			System.out.println("K");*/
	}
}

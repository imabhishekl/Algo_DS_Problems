import java.util.Scanner;
import java.util.Stack;


public class RedundantBracketChecker {
	public static void main(String arg[])
	{
		Scanner cin = new Scanner(System.in);
		char in[] = cin.next().toCharArray();
		Stack<Character> st = new Stack<Character>();
		boolean found = false;
		
		for(int i = 0;i < in.length;i++)
		{
			if(in[i] != ')' || st.peek() != ')')
				st.push(in[i]);
			else
			{
				while(st.peek() != '(')
					st.pop();
				st.pop();
				if(st.size() != 0 && st.peek() == '(')
					found = true;
			}
		}
		System.out.println(found);
	}
}

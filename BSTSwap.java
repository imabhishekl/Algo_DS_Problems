
class TNode
{
	TNode left;
	TNode right;
	int data;
}

public class BSTSwap {
	public static void main(String ar[])
	{
		
	}
	
	public void check(TNode root,TNode parent)
	{
		if(root == null)
			return;		
		check(root.left,parent);
		if(parent != null)
		{
			if(parent.data > root.data)
			{
					/* store the reference of parent */
			}
		}
		parent = root;
		check(root.right,parent);		
	}
	
	public void inorder(TNode root)
	{
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
}

import java.util.Stack;

public class Homework1 {

	public static Node Tree;
	public static Stack<Character> NStack = new Stack<Character>();
	public static void main(String[] args)
	{
		String input = "251-*32*+";
		for(int i=0;i<input.length();i++)
		{
			NStack.add(input.charAt(i))	;
		}
		Tree = new Node(NStack.pop());
		infix(Tree);
		inorder(Tree);
		System.out.print(" = ");
		System.out.print(Calculate(Tree));

	}

	public static void inorder(Node b)
	{
		if (b.Numop == '+' || b.Numop == '-' || b.Numop == '*' || b.Numop == '/')
		{

			if(b!=Tree)
			{
				System.out.print("(");
			}
			inorder(b.Left);
			System.out.print(b.Numop);
			inorder(b.Right);
			if(b!=Tree)
			{
				System.out.print(")");
			}
		}else {
			if(b!=Tree)
			{
				System.out.print(b.Numop);
			}
		}

	}

	public static void infix(Node a) {

		if (a.Numop == '+' || a.Numop == '-' || a.Numop == '*' || a.Numop == '/') {
			a.Right = new Node(NStack.pop());
			infix(a.Right);
			a.Left = new Node(NStack.pop());
			infix(a.Left);
		}
	}
	public static class Node
	{
		Node Left;
		Node Right;
		Character Numop;

		public Node(Character b)
		{
			Numop =b;
		}
	}
	public static int Calculate(Node b)
	{
		if (b.Numop == '+' || b.Numop == '-' || b.Numop == '*' || b.Numop == '/')
		{
			if(b.Numop == '+')
			{
				return Calculate(b.Left)+Calculate(b.Right);
			}
			if(b.Numop == '-')
			{
				return Calculate(b.Left)-Calculate(b.Right);
			}
			if(b.Numop == '*')
			{
				return Calculate(b.Left)*Calculate(b.Right);
			}
			if(b.Numop == '/')
			{
				return Calculate(b.Left)/Calculate(b.Right);
			}
		}else return Integer.parseInt(b.Numop.toString());
		return 0;


	}


}

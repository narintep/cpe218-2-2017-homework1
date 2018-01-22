import java.util.Stack;


public class Homework1 {

	public static String text = "";
	public static Node Tree;
	public static Stack<Character> NStack = new Stack<Character>();
	public static void main(String[] args)
	{

		String input = args[0];
		for(int i=0;i<input.length();i++)
		{
			NStack.add(input.charAt(i))	;
		}
		Tree = new Node(NStack.pop());
		infix(Tree);
		inorder(Tree);
		System.out.print(text + "=");
		System.out.print(Calculate(Tree));
		Homework12.main(args);

	}





	public static String inorder(Node b)
	{
		if (b.Operand == '+' || b.Operand == '-' || b.Operand == '*' || b.Operand == '/')
		{

			if(b!=Tree)
			{
				//System.out.print("(");
				text+="(";
			}
			inorder(b.Left);
			//System.out.print(b.Operand);

			text+=b.Operand;
			inorder(b.Right);
			if(b!=Tree)
			{
				//System.out.print(")");
				text+=")";
			}
		}else {
			if(b!=Tree)
			{
				//System.out.print(b.Operand);
				text+=b.Operand;
			}
		}



		return text;

	}

	public static void infix(Node a) {

	if (a.Operand == '+' || a.Operand == '-' || a.Operand == '*' || a.Operand == '/') {
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
			Character Operand;
			public String toString()
			{
				return Operand.toString();
			}
			public Node(Character b)
			{
				Operand =b;
			}
	}
	public static int Calculate(Node b)
	{
		if (b.Operand == '+' || b.Operand == '-' || b.Operand == '*' || b.Operand == '/')
		{
			if(b.Operand == '+')
			{
				return Calculate(b.Left)+Calculate(b.Right);
			}
			if(b.Operand == '-')
			{
				return Calculate(b.Left)-Calculate(b.Right);
			}
			if(b.Operand == '*')
			{
				return Calculate(b.Left)*Calculate(b.Right);
			}
			if(b.Operand == '/')
			{
				return Calculate(b.Left)/Calculate(b.Right);
			}
		}else return Integer.parseInt(b.Operand.toString());
		return 0;


	}



}

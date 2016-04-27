import java.util.Stack;


public class MyStack extends Stack<Integer>{

	public String name;
	public MyStack(String name1)
	{
		//super();
		name  = name1;
	
	}
	public Integer push(Integer i)
	{
		if (super.isEmpty())
			super.push(i);
		else if (super.peek() < i)
			System.out.println("Cannot insert " + i + "into stack " + this.name);
		else
			super.push(i);
		return i;
	}
	
}

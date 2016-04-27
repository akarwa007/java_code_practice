import java.util.Arrays;


public class mergeLinkedList {

	Node L1;
	Node L2;

	public mergeLinkedList()
	{
	
	}
	public mergeLinkedList(int[] arr1 , int[] arr2)
	{
	   L1 = new Node(arr1[0]);
	   L1 = L1.CreateLLFrom(arr1);
	   L2 = new Node(arr2[0]);
	   L2 = L2.CreateLLFrom(arr2);
	   
	}
	public mergeLinkedList(Node LL1, Node LL2)
	{
		L1 = LL1;
		L2 = LL2;
	}
	public Node mergeRec(Node first , Node second)
	{
		Node result = null;
		if (first == null)
			return second;
		if (second == null)
			return first;
		
		if (first.data < second.data)
		{
			result = new Node(first.data);
			result.next = mergeRec(first.next,second);
		} else
		{
			result = new Node(second.data);
			result.next = mergeRec(first,second.next);	
		}
		return result;
	}
	public Node merge()
	{
		Node result = null;
		Node current = null;
		Node first = L1;
		Node second = L2;
		L1.print();
		System.out.println();
		L2.print();
		System.out.println();
		while ((first != null) & (second != null))
		{
			//System.out.println(first.data + "," + second.data);
			
			if (first.data < second.data)
			{
				if (result == null)
				{
					result = new  Node(first.data);
				    current = result;
				}
				else
				{
					current = current.InsertNode(first.data);
				}
				first = first.next;
			}
			else
			{
				if (result == null)
				{
					result = new Node(second.data);
				    current = result;
				}
				else
				{
					current = current.InsertNode(second.data);
				}
				second = second.next;
			}
		
			
		}
		if (first == null)
			current.next = second;
		if (second == null)
			current.next = first;
		return result;
		
	}
	//Driver program
	public static void main(final String[] args)
	{
		int[] arr1 = {1,3,5,7,9,11,12,23,45,56,67,68,79,100,101,102,103};
		int[] arr2 = {2,4,6,8,25,27,28,57,59,71,72,81,85,95};
		mergeLinkedList mLL = new mergeLinkedList(arr1,arr2);
		Node n = mLL.merge();
		n.print();
		n = mLL.mergeRec(mLL.L1, mLL.L2);
		System.out.println();
		n.print();
		System.out.println();
		String r = BinaryManipulations.Addition("110", "110");
		System.out.println(r);
		String r1 = BinaryManipulations.Add("110", "110");
		System.out.println(r1);
		String r2 = BinaryManipulations.Subtract("1010101", "1111");
		System.out.println(r2);
		String r3 = BinaryManipulations.Multiply("1010101", "1111");
		System.out.println(r3);
		//int i = BinaryManipulations.dsubseq("CODECRAFT");
		//System.out.println(i);
	}
	public class Node {
		Node next;
		int data;
		public Node(int i)
		{
			data = i;
			next = null;
		}
		public void print()
		{
			Node current = this;
			while(current != null)
			{
				System.out.print(current.data + ",");
				current = current.next;
			}
		}
		public Node InsertNode(int i)
		{
			next = new Node(i);
			return next;
		}
		public Node CreateLLFrom(int[] arr)
		{
			Node current = this;
			for(int i = 1; i < arr.length; i++)
			{
				current.next = new Node(arr[i]);
				current = current.next;
			}
			return this;
		}
	
	}
}

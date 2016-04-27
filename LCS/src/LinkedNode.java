
public class LinkedNode {
	LinkedNode next;
		int data;
		public LinkedNode(int i)
		{
			data = i;
			next = null;
		}
		public LinkedNode()
		{
			next = null;
		}
		public static LinkedNode LinkedNode(int[] iarr)
		{
			LinkedNode head = null;
			LinkedNode previous = null;
			
			for(int i : iarr)
			{
				if (head == null)
				{
					head = new LinkedNode(i);
			    	previous = head;
				}else
				{
					previous.next = new LinkedNode(i);
					previous = previous.next;
				}
			}
			return head;
		}
		public static void RemoveDupes(LinkedNode list1)
		{
			
		}
		public void print()
		{
			LinkedNode current = this;
			while(current != null)
			{
				System.out.print(current.data + ",");
				current = current.next;
			}
		}
		public LinkedNode InsertNode(int i)
		{
			next = new LinkedNode(i);
			return next;
		}
		public void InsertLast(int i)
		{
			LinkedNode ll  = new LinkedNode(i);
			LinkedNode last = this;
			while (last.next != null)
				last = last.next;
			last.next = ll;
		}
		public LinkedNode CreateLLFrom(int[] arr)
		{
			LinkedNode current = this;
			for(int i = 1; i < arr.length; i++)
			{
				current.next = new LinkedNode(arr[i]);
				current = current.next;
			}
			return this;
		}
	
	}
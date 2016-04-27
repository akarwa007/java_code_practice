import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Utilities {

	public static MyStack A = new MyStack("A");
	public static MyStack B = new MyStack("B");
	public static MyStack C = new MyStack("C");
	
	public static ArrayList<LinkedNode> aLL = new ArrayList<LinkedNode>();
	
	
	public static void main (final String[] args)
	{
	
	   Utilities.GetMedian();
	   String done = "fsdf";
	   done = done;
	   
	  
	}
	public static void GetMedian()
	{
		//read from stdin
		 //taking value as command line argument.
       Scanner in = new Scanner(System.in); 
       try {
		in = new Scanner(new File("/Users/alokkarwa/Documents/workspace/LCS/src/testcase.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       int N = in.nextInt();
       int i = 0;
       int min_count , max_count ;
       double median;
       BinaryHeap bh_min = new BinaryHeap(BinaryHeap.BinaryHeapType.MIN);
       BinaryHeap bh_max = new BinaryHeap(BinaryHeap.BinaryHeapType.MAX);
       min_count = 0;
       max_count = 0;
       median = 0;
       int min_extract , max_extract;
       while (N > 0)
       {
          i = in.nextInt();
          //System.out.println(i);
        
    	 if (i > bh_min.Peek())
    	 {
    		 bh_min.Insert(i);
    		 min_count++;
    		 //rebalance
    		 while (min_count >  max_count+1)
    		 {
    			 min_extract = bh_min.GetMinMax();
    			 bh_max.Insert(min_extract);
    			 min_count--;
    			 max_count++;
    		 }
    	 }
    	 else
    	 {
    		 bh_max.Insert(i);
    		 max_count++;
    		 //rebalance
    		 while (max_count >  min_count+1)
    		 {
    			 max_extract = bh_max.GetMinMax();
    			 bh_min.Insert(max_extract);
    			 max_count--;
    			 min_count++;
    		 }
    	 }
       if (min_count == max_count)
    	   median = (bh_min.Peek()+bh_max.Peek())/2.0;
       if (min_count > max_count)
    	   median = bh_min.Peek();
    	if (max_count > min_count)
    	   median = bh_max.Peek();
       System.out.println(median);
          N--;
       }
     
	}
	public static LinkedNode llshuffle()
	{
		int[] arr1 = {1,3,5,7,9};
		LinkedNode ll1 = LinkedNode.LinkedNode(arr1);
		int[] arr2 = {2,4,6,8,10,12};
		LinkedNode ll2 = LinkedNode.LinkedNode(arr2);
		boolean turn =  false;
		boolean keepturning = true;
		int j = 0;
		int i = 1;
		LinkedNode a1 = ll1;
		LinkedNode a2 = ll2;
		
		LinkedNode result = new LinkedNode(a1.data);
		a1 = a1.next;
		while((a1!=null) || (a2!=null))
		{
			if ((a1 == null) || (a2 == null))
				  keepturning = false;
			System.out.println(turn);
			if (turn)
			{
				result.InsertLast(a1.data);
				a1 = a1.next;
			}
			else
			{
				result.InsertLast(a2.data);
				a2 = a2.next;
				
			}
			
			if (keepturning)
				turn = !turn;
		}
	
		return result;
	}
	public static void bitmani()
	{
		int num = 17;
		System.out.println();
		System.out.println();
		System.out.println(16|1);
	}
	public static void LLofTreeLevels(BinaryTree bt , int level)
	{
		if (bt == null)
			return;
		if (aLL.size() < (level+1))
			aLL.add(new LinkedNode());
		LinkedNode ln = aLL.get(level);
		ln.InsertLast(bt.data);
		LLofTreeLevels(bt.LeftTree,level+1);
		LLofTreeLevels(bt.RightTree,level+1);
		
			
	}
	public static BinaryTree CreateBTree(int[] sortedarray, int begin, int end)
	{
		
		BinaryTree bt = null;
		if (end < begin)
			return bt;
		//if (end == begin)
			//return new BinaryTree(sortedarray[end]);
		int middle = (begin + end )/2;
		System.out.println("--" + begin + "---"+end+"----"+middle);
		bt = new BinaryTree(sortedarray[middle]);
		bt.LeftTree = Utilities.CreateBTree(sortedarray,begin,middle-1);
		bt.RightTree = Utilities.CreateBTree(sortedarray, middle+1, end);
		return bt;
	}
	public static void TOH(int N, MyStack A, MyStack B, MyStack C)
	{
		
	   if (N==1)
	   {
		   int item = A.pop();
		   C.push(item);
		   System.out.println("Move " +  item + " from " +  A.name + " to " + C.name);
		   return;
	   }
	   TOH(N-1,A,C,B);
	   TOH(1,A,B,C);
	   TOH(N-1,B,A,C);
	}
	public static void AddLL()
	{
		int[] arr1 = {8,3,4};
		LinkedNode ll1 = LinkedNode.LinkedNode(arr1);
		int[] arr2 = {5,6,7,1,2,3};
		LinkedNode ll2 = LinkedNode.LinkedNode(arr2);
		int carry = 0;
		LinkedNode c1 = ll1;
		LinkedNode c2 = ll2;
		int temp  = 0;
		LinkedNode result = null;
		LinkedNode current = null;
		System.out.println();
		ll1.print();
		System.out.println();
		ll2.print();
		System.out.println();
		int c1_data = 0;
		int c2_data = 0;
		while ((c1!= null)||(c2!=null))
		{
			c1_data = c1 == null ? 0 : c1.data;
			c2_data = c2 == null ? 0 : c2.data;
			
			temp = carry + c1_data + c2_data;
			carry = temp/10;
		
			if (result == null)
			{
				result = new LinkedNode(temp%10);
				current = result;
			}else
			{
				current.InsertNode(temp%10);
				current = current.next;
			}
			c1 = c1 == null ? null : c1.next;
			c2 = c2 == null ? null : c2.next;
		}
		if (carry > 0)
			current.InsertNode(carry);
		
		System.out.println();
		result.print();
	}
	public static void RemoveDupes()
	{
		int[] arr = {1,2,3,4,4,4,3,2,1,3,9,8,7,5,5};
		LinkedNode ll = LinkedNode.LinkedNode(arr);
		ll.print();
	    System.out.println();
	    LinkedNode head = ll;
	    LinkedNode current = head.next;
	    int cdata = current.data;
	    LinkedNode scanner = head;
	    LinkedNode previous = head;
	    while (current != null)
	    {
	    	scanner = head;
	    	boolean found = false;
	    	while (scanner != current)
	    	{
		    	if (current.data == scanner.data)
		    	{
		    		// delete current
		    		previous.next = current.next;
		    		found = true;
		    		break; 
		    	}
		    	scanner = scanner.next;
	    	}
	    	if (!found)
	    	    previous = current;
	    	
	    	current = current.next;
	    }
	    head.print();
		
		
	}
	public static boolean isRotated(String orig , String rotated)
	{
		if (orig.length() != rotated.length())
			return false;
		int len = orig.length();
		int i = 0;
		int j = 0;
		int lastmatch = 0;
		int matchedcount = 0;
		boolean finished = false;
		int iter = 0;
		System.out.println("length of string  count = " + len);
		while(!finished)
		{
			
			while (rotated.charAt(j) != orig.charAt(i))
			{
				j = (j+1)%len;
			
			}// found a matching character
			lastmatch = j;
			matchedcount = 0;
			System.out.println("lastmach =  " + lastmatch);
			while (rotated.charAt(j) == orig.charAt(i))
			{
				i = (i+1)%len;
				j = (j+1)%len;
				matchedcount++;
				System.out.println( i + "-" + j + "-" + matchedcount);
				if (matchedcount == len)
				{
					System.out.println("matched == len");
					finished = true;
					break;
					
				}
			}
			//did not match yet
			i = 0;
			j = (lastmatch+1)%len;
			
			if ((j ==0 )&&(!finished))
			{
				System.out.println("j == 0");
				return false;
			}
				
		}
		return true;
		
		
	}
	public static void Matrix(int[][] arr)
	{
		
		int marker = 2; // starting marker is 2 , then we increment by one 
		// find a 1 
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				if (arr[i][j] == 1)
					process_matrix(arr,i,j,marker++);
			}
		}
		
	}
    public static int IsPowerOfFour(int num) {
	
	     while (num > 0){
	    	 num = num&(num-1);
		     System.out.println(num);
	     }
	     
     return 0;
	}
	public static void process_matrix(int[][] arr,int i, int j, int marker)
	{
		//scan surrounding 1's for cell i,j
	
	    Stack stack = new Stack();	
	   
	    arr[i][j] = marker;
	    stack.add(new int[]{i,j});
	    while (!stack.isEmpty())
	    {
	    	int[] a = (int[])stack.pop();
	    	// process its neighbours
	    	i = a[0];
	    	j = a[1];
	    	int left_r = i;
			int left_c = j-1 > 0 ? j-1 : 0;
			int right_r = i;
			int right_c = j+1 < arr[i].length ? j+1 : arr[i].length-1;
			int top_r = i-1 > 0 ? i -1 : 0;
			int top_c = j;
			int bottom_r = i+1 < arr.length ? i+1 : arr.length-1;
			int bottom_c = j;
		    if (arr[left_r][left_c] == 1)
		    	stack.add(new int[]{left_r,left_c});
		    if (arr[right_r][right_c] == 1)
		    	stack.add(new int[]{right_r,right_c});
		    if (arr[top_r][top_c] == 1)
		    	stack.add(new int[]{top_r,top_c});
		    if (arr[bottom_r][bottom_c] == 1)
		    	stack.add(new int[]{bottom_r,bottom_c});
		    arr[i][j] = marker;
	    }
	    
		
	}
	public static int Pal(String str)
	{
		int[] dp = new int[str.length()];
		dp[0] = 0;
		for(int i =1; i < str.length();i++)
		{
			
		}
	}
	public static int[] intersectionofarrays(int[] arr1, int[] arr2)
	{
		int[] result;
		if ((arr1 == null) || (arr2 == null ))
			return null;
		int maxof = arr1.length < arr2.length ? arr2.length : arr1.length;
		result = new int[maxof];
		int i = 0;
		int j = 0;
		int k = 0;
		while((i < arr1.length) && (j < arr2.length))
		{
			if (arr1[i] == arr2[j])
			{
				result[k++] = arr1[i];
				i++;j++;
			}
			else if (arr1[i] < arr2[j])
				i++;
			else
				j++;
			
		}
		
		return result;
	}
	public static int TurningIndex(int[] numarray, int begin, int end)
	{
		System.out.println(begin + " - " + end);
		if ((end - begin) < 2)
		{
			return numarray[begin] > numarray[end] ? numarray[begin] : numarray[end];
		}
		if (begin == end)
			return numarray[begin];
		int middle = (begin+end)/2;
		if ((numarray[middle-1] <= numarray[middle]) && (numarray[middle] <= numarray[middle+1]))
			return TurningIndex(numarray,middle,end);
		else
			return TurningIndex(numarray,begin,middle);
		
	}
	public static  int func2(int[] values, int i) 
	{
		if (i <=  0 )
			return values[0];
		int result1 = func2( values,i-1);
		int result2 = values[i] + func2(values,i-2);
		int result = result1 > result2 ? result1 : result2;
		return result;
	}
	public static boolean IsPal(String str)
	{
		if (str.length() <= 1)
			return true;
		if (str.length() == 2)
		{
			if (str.charAt(0) == str.charAt(1))
				return true;
			else
				return false;
		}
		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);
		if (first != last)
			return false;
		else
		{
		   return IsPal(str.substring(1, str.length()-2));
		}
	}
	public static String func1(int[] narray, int sum)
	{
		// remove all elements that are over sum 
		String result = "";
		int i = 0;
		Arrays.sort(narray);
		while ((i < narray.length)&&(narray[i] < sum)) i++;
		
		int[] new_array = Arrays.copyOfRange(narray,0,i);
		// new_array has all elements less than sum
		if (new_array.length < 3)
			return "not possible 1";
		int remaining_sum = 0;
		for( i =0; i < new_array.length; i++)
		{ 
			remaining_sum = sum-new_array[i];
			for(int j =i+1; j < new_array.length; j++)
			{
				remaining_sum = remaining_sum-new_array[j];
				if (remaining_sum <  0)
					return "not possible 2";
				for( int k =j+1; k < new_array.length; k++)
				{
					remaining_sum = remaining_sum-new_array[k];
					if (remaining_sum <  0)
						return "not possible 3";
					if (remaining_sum == 0)
						return Integer.toString(new_array[i])+","+Integer.toString(new_array[j])+","+Integer.toString(new_array[k]);
					if (remaining_sum >   0)
						remaining_sum = remaining_sum+new_array[k]; // reverse
				}
				remaining_sum = remaining_sum+new_array[j]; // reverse
			}
			remaining_sum = remaining_sum+new_array[i]; // reverse
		}
		
		return "finally not possible";
	}
	public static void main1 (final String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		String result = Utilities.func1(arr, 28);
		System.out.println(result);
		System.out.println(IsPal("kk"));
		int[] values = {6,1,2,7};
		System.out.println(Utilities.func2(values,3));
		int[] aa = {45};
		int  iresult = Utilities.TurningIndex(aa, 0 , aa.length-1);
		System.out.println("TurningIndex is " + Integer.toString(iresult));
		int[] a1 = {1, 4, 7, 10,12, 13} ;
		int[] a2 =  {1, 3, 5, 7, 9,12};
		int[] r2 = Utilities.intersectionofarrays(a1, a2);
		System.out.println("print intersection of arrays");
		for(int i =0; i < r2.length;i++)
		{
			System.out.println(r2[i]);
		}
		int[][] matrix = new int[][]{
				{1,1,1,0,1,1,1},
				{1,0,1,0,1,0,1},
				{1,1,1,0,1,1,1},
				{0,0,0,0,0,0,0},
				{0,0,1,1,1,0,0},
				{0,0,1,1,1,0,0}
				};
	    Utilities.Matrix(matrix);
	    System.out.println("Printing the resolved matrix");
	    for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
			   System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	   boolean rotated = Utilities.isRotated("aaabaabaa", "abababababa");
	   System.out.println(rotated);
	   Utilities.RemoveDupes();
	   Utilities.AddLL();
	   
	   for(int y=9; y > 0 ; y--)
	   {
	     Utilities.A.push(y);
	   }
	   
	   Utilities.TOH(9,A,B,C);
	   int[] sortedarray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	   BinaryTree bt = Utilities.CreateBTree(sortedarray, 0, sortedarray.length-1);
	   System.out.println(bt.MaxDepth(bt));
	 
	   LLofTreeLevels(bt,0);
	   System.out.println("printing linked list nodes for tree levels");
	   for(LinkedNode ln : Utilities.aLL)
	   {
		   System.out.println();
		   ln.print();
	   }
	   Utilities.bitmani();
	   LinkedNode rr = Utilities.llshuffle();
	   rr.print();
	   
	   BinaryHeap bh_min = new BinaryHeap(BinaryHeap.BinaryHeapType.MAX);
	   //bh_min.CreateFrom(sortedarray);
	 
	   for(int i = 1; i <= 20; i++)
	   {
		  bh_min.Insert(i);
	   }
	   System.out.println("heap size is " + bh_min.size());
	   
	   for(int i = 1; i < 5; i++)
	   {
		   System.out.println("will run getmin for " + i);
		   int r = bh_min.GetMinMax();
		   System.out.println(r);
	   }
	}
}

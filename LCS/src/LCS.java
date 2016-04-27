

public class LCS {

	 public static void main(final String[] args)
	 {
		 
		 int[] arr1 = {1, 5, 9, 10, 15, 20};
		 int[] arr2 = {2, 3, 8, 13,14,16,17,18};
		 ArrangeArr(arr1,arr2);
		 
		 if (1==1)
			  return;
		 
		 System.out.print(LCS.printMatrixPath(2, 2));
		 if (1==1)
			  return;
		 printseq("IIDDD");
		 //printseq("DDIDDIID");
	
		 
		 int[] arr = {1,1,1,1,1,0,0,0};
		 System.out.print(findzeros(arr,0,arr.length-1));
		 System.out.println();;
		 
		 int val[] = {60, 100, 120};
		    int wt[] = {10, 20, 30};
		    int  W = 50;
		    
		   System.out.print(knapsack(W, val, wt, 3));
		   System.out.println();
		 
		 
		 Node head = new Node("A");
		 Node head1 = new Node("B");
		 Node head2 = new Node("C");
		 Node head3 = new Node("D");
		 Node head4 = new Node("E");
		 Node head5 = new Node("F");
		 Node head6 = new Node("G");
		 Node head7 = new Node("H");
		 Node head8 = new Node("I");
		 Node head9 = new Node("J");
		 head.next = head1;
		 head1.next = head2;
		 head2.next = head3;
		 head3.next = head4;
		 head4.next = head5;
		 head5.next = head6;
		 head6.next = head7;
		 head7.next = head8;
		 head8.next = head9;
		 head9.next =  null;
		 
		boolean loop = DetectLoop(head);
		System.out.print(loop);
		 
		PrintLinkedList(head);
		Rearrange(head);
		PrintLinkedList(head);
		
		
	    String L1 = "0123456789ABCDEF";
    	String L2 = "084C2A6E195D3B7F";
    	
    	//String result = LCS(L1,L2);
    	//System.out.println(result);
    	
	 }
	 public static void ArrangeArr(int[] arr1, int[] arr2)
	 {
		 int swap;
		 for(int i = arr1.length -1 ; i >=0; i--)
		 {
			 for(int j=arr2.length-1;j >= 0;j--)
			 {
				 if(arr2[j] < arr1[i]) // arr2[j] element is incorrectly placed.
				 {
				    swap = arr1[i];
				    arr1[i] = arr2[j];
				    arr2[j] = swap;
				 // now arr2[j] is correctly placed 
				 // However arr1[i] is not correctly placed 
				    int k = i;
				    boolean done = false;
				    while(( k > 0) && (!done))
				    {
				    	if(arr1[k] < arr1[k-1])
				    	{
				    	   swap = arr1[k];
				    	   arr1[k] = arr1[k-1];
				    	   arr1[k-1] = swap;
				    	   k = k - 1;
				    	}
				    	else
				    	{
				    		done = true;
				    	}
				    }
				 }
				 
			 }
		 }
		 // print the two arrays
		 // print array 1
		 for(int i = 0;  i < arr1.length ; i++)
		 {
		  System.out.print(arr1[i]);
		  System.out.print(",");
		  
		 }
		 System.out.println();
		 
		 // print array 2 
		 for(int i = 0;  i < arr2.length ; i++)
		 {
		  System.out.print(arr2[i]);
		  System.out.print(",");
		  
		 }
	 }
	 public static String PrintComb(int count)
	 {
		 String result = "";

		 
		 return result;
		 
		 
	 }
	 public static int printMatrixPath(int m ,int n)
	 {
		 int result = 0;
		 
		 if ((m==0) && (n==0))
			 return 0;
		 if ((m==0)||(n==0))
			 return 1;
		 return printMatrixPath(m-1,n) + printMatrixPath(m,n-1);
		 
	 }
	 public static void printseq(String str)
	 {
		 char[] arr = str.toCharArray();
		 int count = 0;
		 int[] out = new int[arr.length+1];
		 
		 for(int i = arr.length-1; i >= 0; i--)
		 {
			 //System.out.print(arr[i]);
			 if (arr[i] == 'D')
			 {
				 if (count == 0)
				 {
					 out[i+1] = 1;
					 out[i] = 2;
				 }
				 else
				 {
					 out[i] = out[i+1]+1;
					 //skip put[i] places and then increment all after that 
					 int j = i+out[i];
					 while (j < out.length)
					 {
					   out[j] = out[j] + 1;
					   j++;
					 }
				 }
				 
				 
			 }
			 if (arr[i] == 'I')
			 {
				 if (count == 0)
				 {
					 out[i+1] = 2;
					 out[i] = 1;
				 }
				 else
				 {
					 out[i] = 1;
					 // increment everything by 1 on the right 
					 int j = i+1;
					 while (j < out.length)
					 {
					   out[j] = out[j] + 1;
					   j++;
					 }
				 }
			 }
			 
		   count++;
		 }
		 //print out array
		 System.out.println();
		 for(int k =0; k< out.length; k++)
		 {
			 System.out.print(out[k]);
		 }
	 }
	 public static int findzeros(int[] arr,int begin, int end)
	 {
		 int mid = begin +  (end-begin) / 2;
		 
		 if (begin == end )
			 return arr[begin] == 0 ? 1 : 0;
		 
		 if (arr[mid] == 1)
			 return findzeros(arr , mid+1,end);
		 else
			 return findzeros(arr,begin,mid) + (end - mid);
	 }
	 public static int max(int n, int m)
	 {
	   return n > m ? n : m;
	 }
	 public static int knapsack(int W, int[] val, int[] wghts , int n)
	 {
		 if (n ==0 || W == 0 )
		  return 0;
		 if (wghts[n-1] > W)
			 return knapsack(W,val,wghts,n-1);
		 else return max(val[n-1] + knapsack(W-wghts[n-1],val,wghts,n-1),knapsack(W,val,wghts,n-1));
		 
	 }
	 public static void PrintLinkedList(Node head)
	 {
		 System.out.println();
	   while (head != null)
	   {
		  System.out.print(head.content + "->");
	      head = head.next;
	   }
	 }
	 public static void Rearrange(Node list)
	 {
		 Node head = list;
		 Node tail  = head;
		 while ((tail.next.next != null) && (tail.next != null))
			 tail = tail.next;
		 if (head == tail)
			 return;
		 tail.next.next = list.next;
		 list.next = tail.next;
		 tail.next = null;
		 if(list.next.next != null)		 
			  Rearrange(list.next.next);
	 }
	 public static boolean  DetectLoop(Node linkedlist)
	 {
		 Node fp = linkedlist.next.next;
		 Node sp = linkedlist.next;
		 
		 while ((fp != sp) && (fp!=null) && (sp!=null))
		 {
		   fp = fp.next.next;
		   sp = sp.next;
		 }
		 if ((fp != null) && (sp!= null))
		 {
			 FindLoopLength(linkedlist,fp);
		   return true;
		 }
		 else
			 return false;
	 }
	 public static void FindLoopLength(Node list, Node collide)
	 {
	    Node ptr = collide;
	    int loopcount = 1;
	    while (ptr.next != collide)
	    {
	       loopcount++;
	       ptr = ptr.next;
	    }
	    System.out.print(loopcount);
	 }
	 
	 public static String LIS(String L1)
	 {
		 String result = "";
		 String result1 = "";
		 
		 if (L1.length() <= 1 )
				return L1;
		 int a = (int)L1.charAt(0);
		 char[] arr = L1.toCharArray();
		 
		 if (a > Max(L1.substring(1)))
			 result =  a + "";
		 else
			 result = a + LIS(L1.substring(1));
		 
		 result1 =  LIS(L1.substring(1));
		
		 
		 
		 return result;
	 }
	 public static int Max(String str)
	 {
	   int max = -1;
	   char[] raw = str.toCharArray();
	   int[] list = new int[raw.length];
	   for (int i = 0; i < raw.length; i++) {
		    list[i] = raw[i] - '0';
		}
	   
	   for (int i = 0; i < list.length; i++) {
		    if (max < list[i])
		    	max = list[i];
		}
	   
	   
	   return max;
	 }
	 
	    public static String LCS(String L1, String L2)
	    {
	    	String result = "";
	    	String result1 = "";
	    	String result2 = "";
	    	
	    	if ((L1.length() == 0) || (L2.length() == 0))
	    		return "";
	    	if (L1.charAt(0) == L2.charAt(0))
	    		return L1.charAt(0) + LCS(L1.substring(1),L2.substring(1));
	    	result1 = LCS(L1,L2.substring(1));
	    	result2 = LCS(L1.substring(1),L2);
	    	if (result1.length() > result2.length())
	    	  result = result1;
	    	else
	    		result = result2;
	    	
	    	  	
	    	return result;
	    }
}

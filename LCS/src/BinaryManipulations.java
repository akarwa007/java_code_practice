import java.util.Hashtable;


public class BinaryManipulations {

	public BinaryManipulations()
	{
		
	}
	public static int dsubseq(String str)
	{
	   int[] sum = new int[str.length()+1];
	   char[] arr = str.toCharArray();
	   Hashtable h = new Hashtable();
	   sum[0] = 2;
	   int last = 1;
	   //h.put(arr[0], 0);
		for(int i = 1; i < str.length(); i++)
		{
		  if (h.containsKey(arr[i]))
		  {
		     last =   Integer.parseInt(h.get(arr[i]).toString());
		     sum[i] = sum[i - 1] + sum[i-1] - sum[last - 1];
		  }
		  else
		  {
			  sum[i] = sum[i - 1] + sum[i-1];
		  }
		  h.put(arr[i], i);
		}
		return sum[str.length()-1];
	}
	public static String Multiply(String num1 , String num2)
	{
		String sum = "";
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		int len1 = arr1.length-1;
		int len2 = arr2.length-1;
		String adjusted = num1;
		System.out.println("Multiply");
		while(len2 >=0)
		{
			
			if (arr2[len2] == '1')
			{
				sum = BinaryManipulations.Add(sum, adjusted);
				System.out.println(sum);
			}
			len2--;
			adjusted = adjusted+"0";
		}
		return sum;
				
	}
	public static String Subtract(String num1, String num2)
	{
	    int  borrow = 0;
	    char[] arr11 = num1.toCharArray();
		char[] arr22 = num2.toCharArray();
	  
		int len1 = arr11.length-1;
		int len2 = arr22.length -1;
		
		char a1 , a2;
		String sum = "";
		int singlesum = 0;
		while((len1 >= 0) || (len2 >= 0))
		{
		    a1 = len1 >=0 ? arr11[len1] : '0';
		    a2 = len2 >= 0 ? arr22[len2] : '0';
		    
		    
		    singlesum = a1+borrow - a2;
		 
	    	borrow = singlesum;
	    	switch (borrow) {
	    	case 0:
	    		 sum = "0" + sum;
	    		 break;
	    	case 1:
	    		 sum = "1" + sum;
	    		 borrow = 0;
	    		 break;
	    	case -1:
	    		sum = "1" + sum;
	    		break;
	    	case -2:
	    		sum = "0" + sum;
	    		borrow++;
	    		break;
	    	default:
	    		break;
	    	}
		    	    
		    
			len1--;
			len2--;

		}
		return sum;
	}
	public static String Add(String num1 , String num2)
	{
		
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		
		int len1 = arr1.length - 1;
		int len2 = arr2.length - 1;
		
		char a1 , a2;
		
		String sum = "";
		int carry = 0;
		int singlesum = 0;
		
		while((len1 >= 0) || (len2 >= 0))
		{
		    a1 =  len1 >= 0 ? arr1[len1] : '0';
		    a2 = len2 >= 0 ? arr2[len2] : '0';
		   
		    singlesum = a1 + a2 + carry - '0' - '0';
		    switch (singlesum) {
		    	case 0:
		    		    sum = "0" + sum;
		    		    carry = 0;
		    			break;
		    	case 1:
		    		    sum = "1" + sum;
		    		    carry = 0;
		    			break;
		    	case 2:
		    		 	sum = "0" + sum;
		    		 	carry = 1;
		    			break;
		    	case 3: 
		    			sum = "1" + sum;
		    			carry = 1;
		    			break;
		    	default:
		    			sum = sum + "2";
		    			break;
		    }
			len1--;
			len2--;

		}
		if (carry == 1)
			sum = "1" + sum;
		return sum;
	}
	public static String Addition(String num1, String num2)
	{
		String result = null;
		// check if num1 & num2 are binary strings
		num1 = "0" + num1;
		num2 = "0" + num2;
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		
		int len1 = arr1.length-1;
		int len2 = arr2.length-1;
		String sum = "";
		int carry = 0;
		boolean done = false;
		while((len1 >= 0) || (len2 >= 0))
		{
			if ((len1==0) &&(len2==0))
				 done = true;
			if (carry == 0)
			{
				if (arr1[len1] == '0')
					sum = arr2[len2] + sum;
				else if (arr2[len2] == '0')
					sum = arr1[len1] + sum;
				else // both of them have a 1 
				{
					carry = 1;
					sum = "0" + sum;
				}
			} else // carry is 1
			{
				if ((arr1[len1] == '0') && (arr2[len2]=='0'))
				{
					carry = 0;
					sum = "1" + sum;
				}
				else if ((arr1[len1] == '0') || (arr2[len2]=='0'))
				{
				    carry = 1;
				    sum = "0" + sum;
				}
				else // both are 1
				{
					carry = 1;
					sum = "1" + sum;
				}
				
			}
			if (len1 > 0)
				len1--;
			if (len2 > 0)
				len2--;
			if ((len1 == 0) && (len2 == 0) && (done))
				break;
			
		}
		
			
		return sum;
	}
}

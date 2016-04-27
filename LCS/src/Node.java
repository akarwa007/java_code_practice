
public class Node {

	String content;
	Node next;
	public Node(String str)
	{
		content = str;
	}
   
	 public static long count(String S) { 
	    char s[] = S.toCharArray(); 
	    int n = s.length; 
	     
	    long dp[][] = new long[n][n]; 
	     
	    for(int i = 0; i < n; i++) 
	      dp[i][i] = 1; 
	     
	    for(int l = 1; l < n; l++){ 
	      for(int i = 0; i + l < n; i++){ 
	        int j = i + l; 
	        dp[i][j] = dp[i + 1][j]; 
	        for(int k = i + 1; k <= j; k++){ 
	          boolean a = s[i] == '(' && s[k] == ')'; 
	          a |= s[i] == '[' && s[k] == ']'; 
	          if(a){ 
	            long now = 1; 
	            if(i + 1 <= k - 1) 
	              now *= dp[i + 1][k - 1]; 
	            if(k + 1 <= j) 
	              now *= dp[k + 1][j]; 
	            dp[i][j] += now; 
	          } 
	          System.out.println(i+  " - " + j + " -  " + k + " - " + a + "-" +   dp[i][j]); 
		         
	        } 
	        //System.out.println(i+  " " + j + " " + dp[i][j]); 
	      } 
	    } 
	     
	    return dp[0][n-1] - 1; 
	 } 
}
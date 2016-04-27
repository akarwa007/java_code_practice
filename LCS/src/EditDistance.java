import java.io.Console;






public class EditDistance {


//Utility function to find minimum of three numbers
public static int min(int x, int y, int z) 
{
	int result = y;
	if (x < y) 
		result = x;
	if (z < result)
		result = z;
	
    return result;
}

public static int imin3(int x, int y, int z) 
{
	int result = 1;
	if (x < y) 
		result = 0;
	if (z < result)
		result = 2;
	
    return result;
}

public static int editDistDP(String str1, String str2, int m, int n)
{
 // Create a table to store results of subproblems
 int[][] dp = new int[m+1][n+1];

 // Fill d[][] in bottom up manner
 for (int i=0; i<=m; i++)
 {
     for (int j=0; j<=n; j++)
     {
         // If first string is empty, only option is to
         // isnert all characters of second string
         if (i==0)
             dp[i][j] = j;  // Min. operations = j

         // If second string is empty, only option is to
         // remove all characters of second string
         else if (j==0)
             dp[i][j] = i; // Min. operations = i

         // If last characters are same, ignore last char
         // and recur for remaining string
         else if (str1.charAt(i-1) == str2.charAt(j-1))
             dp[i][j] = dp[i-1][j-1];
         

         // If last character are different, consider all
         // possibilities and find minimum
         else
             dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                dp[i-1][j],  // Remove
                                dp[i-1][j-1]); // Replace
     }
 }

 int i = m; int j = n;

 while ((i>0) & (j>0)) {
     if (i == 0) {
         System.out.println("insert " + str2.charAt(j-1));
         j--;
     } else if (j == 0) {
    	 System.out.println("remove " + str1.charAt(i-1));
         i--;
     } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
         i--; j--;
     } else {        
         int k = imin3(dp[i][j - 1],
                       dp[i - 1][j],
                       dp[i - 1][j - 1]);

         if (k == 2) {
        	 System.out.println("replace " + str1.charAt(i - 1) 
                   + " with " + str2.charAt(j - 1));
             i--; j--;
         } else if  (k == 1) {
        	 System.out.println("remove " + str1.charAt(i - 1));
             i--;

         } else {
        	 System.out.println("insert "+ str2.charAt(j - 1));
             j--;
         }
     }
 	}
 
 return dp[m][n];
}

//Driver program
public static void main(final String[] args)
{
 // your code goes here
 String str1 = "fuck you";
 String str2 = "I love you";

 System.out.println("Hello");
 System.out.println(EditDistance.editDistDP(str1, str2, str1.length(), str2.length()));

}
}
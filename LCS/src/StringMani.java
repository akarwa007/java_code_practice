import java.util.ArrayList;
import java.util.List;


public class StringMani {

	public StringMani()
	{
		
	}
	public static void main(final String[] args)
	{
		System.out.println("Hello String manipulations");
		System.out.println(StringMani.LexiLarge("alok","alotk"));
		StringMani.Big("alok");
	}
	public static void Big(String str1)
	{
		List<Tuple<Integer,Integer>> list1 = new ArrayList<Tuple<Integer,Integer>>();
		list1.add(new Tuple(1,4));
		list1.add(new Tuple(3,4));
		
		for(Tuple<Integer,Integer> x : list1)
		{
			System.out.println(x.x + "---" + x.y);
		}
		
	}
	public static String LexiLarge(String s1 , String s2)
	{
		String result = s1;
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int len1 = arr1.length-1;
		int len2 = arr2.length-1;
		char a1 , a2;
		int len  = len1 < len2 ? len1 : len2;
		int i = 0;
		while(i <= len)
		{
			a1 = arr1[i];
			a2 = arr2[i];
			if (a1 == a2)
			{
				i++;
				continue;
			}
			result = a1 > a2 ? s1 : s2;
			break;						
		}
		
		return result;
		
	}
}

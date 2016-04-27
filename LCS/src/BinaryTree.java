import java.util.Arrays;
import java.util.Stack;

import com.sun.tools.hat.internal.util.ArraySorter;
import com.sun.tools.javac.code.Attribute.Array;


public class BinaryTree {

	BinaryTree LeftTree = null;
	BinaryTree RightTree = null;
	BinaryTree parent = null;
	
	public static Stack<Tuple<Integer,Integer,Integer>> printer = new Stack<Tuple<Integer,Integer,Integer>>();
	
	int data;
	
	public BinaryTree(int data1)
	{
		data = data1;
	}
	public double MaxDepth(BinaryTree bt)
	{
		if (bt==null)
			return 0;
		else
			return 1 + Math.max(MaxDepth(bt.LeftTree), MaxDepth(bt.RightTree));
	}
	public void SetLeft(BinaryTree left)
	{
		LeftTree = left;
		LeftTree.parent = this;
	}
	public void SetRight(BinaryTree right)
	{
		RightTree = right;
		RightTree.parent = this;
	}
	public void InorderPrint(BinaryTree bt)
	{
		if (bt.LeftTree != null)
			InorderPrint(bt.LeftTree);
		
		System.out.print(bt.data + "-");
		
		if (bt.RightTree != null)
			InorderPrint(bt.RightTree);
		
	}
	public static int GetNextP()
	{
		int x = -1;
		int y = 1000;
		int z = 1000;
		int index = 0;
		for(int i = 0; i < BinaryTree.printer.size(); i++)
		{
			Tuple<Integer,Integer,Integer> t = BinaryTree.printer.elementAt(i);
			if (t.y < y)
			{
				 x = t.x;
				 y = t.y;
				 z = t.z;
				 index = i;
			}
			if (t.y == y)
			{
				if (t.z > z)
				{
					 x = t.x;
					 y = t.y;
					 z = t.z;
					 index = i;
				}
			}
		
			
		}
		BinaryTree.printer.removeElementAt(index);
		return x;
		
	}
	public void VerticalPrint(BinaryTree bt, int column , int level)
	{
		if (bt.LeftTree != null)
		{
			int i = column - 1;
			int l = level-1;
			VerticalPrint(bt.LeftTree,i,l);
		}
		
		BinaryTree.printer.push(new Tuple<Integer,Integer,Integer>(bt.data,column,level));
		
		if (bt.RightTree != null)
		{
			int i = column + 1;
			int l = level-1;
			VerticalPrint(bt.RightTree,i,l);
		}
	}
	public static void main(final String[] args)
	{
		BinaryTree t0 = new BinaryTree(0);
		BinaryTree t1 = new BinaryTree(1);
		BinaryTree t2 = new BinaryTree(2);
		BinaryTree t3 = new BinaryTree(3);
		BinaryTree t4 = new BinaryTree(4);
		BinaryTree t5 = new BinaryTree(5);
		BinaryTree t6 = new BinaryTree(6);
		BinaryTree t7 = new BinaryTree(7);
		BinaryTree t8 = new BinaryTree(8);
		BinaryTree t9 = new BinaryTree(9);
		t6.LeftTree = t3;
		t6.RightTree = t4;
		t3.LeftTree = t5;
		t3.RightTree = t1;
		t5.LeftTree = t9;
		t5.RightTree = t2;
		t2.RightTree = t7;
		t4.RightTree = t0;
		t0.LeftTree = t8;
		
		System.out.println("Hello BinaryTree");
		//t4.InorderPrint(t6);
		t6.VerticalPrint(t6, 0,0);
       for(Tuple<Integer,Integer,Integer> x : BinaryTree.printer)
       {
    	   System.out.println(x.x + " , " +  x.y + " , " + x.z);
       }
       System.out.println(BinaryTree.printer.capacity());
       int count = BinaryTree.printer.capacity();
       for(int i =0;  i < count; i++)
    	   System.out.println(BinaryTree.GetNextP() + " , ");
		
	}
	
}

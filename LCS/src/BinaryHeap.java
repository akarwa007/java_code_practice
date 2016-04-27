import java.util.Arrays;


public class BinaryHeap {

	private int[] _array;
	public  BinaryHeapType HeapType = BinaryHeapType.MIN;
	public enum BinaryHeapType {MIN, MAX};
	private int _capacity = 0; // num of elements in the array
	
	public BinaryHeap( BinaryHeapType heaptype)
	{
		this.HeapType = heaptype;
		//default capacity is set to 4
		_array = new int[100];
	}
	public void Insert(int item)
	{
		int size_needed = _capacity + 1;
		resize(size_needed);
		_capacity += 1;
		_array[_capacity-1] = item;
		PercUp(_capacity-1);
		
	}
	private void PercUp(int index)
	{
		if (index <= 0)
			return;
		int parent = (index-1)/2;
		
		if (HeapType == BinaryHeapType.MAX)
		{
			if (_array[parent] < _array[index])
			{
				//swap
				int temp = _array[index];
				_array[index] = _array[parent];
				_array[parent] = temp;
				PercUp(parent);
			}
 		}
		else
		{
			if (_array[parent] > _array[index])
			{
				//swap
				int temp = _array[index];
				_array[index] = _array[parent];
				_array[parent] = temp;
				PercUp(parent);
			}
			
		}
		
	}
	private void resize(int size_needed)
	{
		if (size() < size_needed)
		{
			//resize
			int[]  new_array = new int[size_needed*2];
			System.arraycopy(_array, 0, new_array, 0, _array.length);
			_array = new_array;
		}
	}
	public void CreateFrom(int [] narray)
	{
		if ((narray == null) || (narray.length == 0))
			return;
		int len = narray.length;
		this._array = new int[len*2];
		//this._array = Arrays.copyOfRange(narray, 0, len);
		System.arraycopy(narray, 0, this._array, 0, len);
		_capacity = len;
		heapify();
	}
	public int size()
	{
		return _array.length;
	}
	public int GetMinMax()
	{
		if (this.HeapType == BinaryHeapType.MAX)
			return GetMax();
		else
			return GetMin();
	}
	public int Peek()
	{
		return _array[0];
	}
	private int GetMin()
	{
		int result =  _array[0];
		_array[0] = _array[_capacity-1];
		_array[_capacity-1] = 0;
		_capacity -= 1;
		
		MinHeapify(0);
		return result;
	}
	private int GetMax()
	{
		int result =  _array[0];
		_array[0] = _array[_capacity-1];
		_array[_capacity-1] = 0;
		_capacity -= 1;
		MaxHeapify(0);
		return result;
	}
	public void heapify()
	{
	  int lastroot = (this._capacity-1)/2;
	
	  for (int currentroot = lastroot; currentroot >= 0; currentroot--)
	  {
		
		  if (this.HeapType == BinaryHeapType.MAX)
			  MaxHeapify(currentroot);
		  else
			  MinHeapify(currentroot);
	  }
	}
	private void MaxHeapify(int index)
	{
		int left , right , largest;
		left = 2*index + 1;
		right = 2*index + 2;
		largest = index;
		if ((left < _capacity) && (_array[left] > _array[largest]))
			largest = left;
	    if  ((right < _capacity) && (_array[right] > _array[largest]))
			largest = right;
		
		if (largest != index)
		{
			// swap
			int temp = _array[index];
			_array[index] = _array[largest];
			_array[largest] = temp;
			MaxHeapify(largest);
		}
	}
	
	private void MinHeapify(int index)
	{
		
		int left , right , smallest;
		left = 2*index + 1;
		right = 2*index + 2;
		smallest = index;
		
		if ((left < _capacity) && (_array[left] < _array[smallest]))
			smallest = left;
		if ((right < _capacity) && (_array[right] < _array[smallest]))
			smallest = right;
		
		
		if (smallest != index)
		{
			// swap
			int temp = _array[index];
			_array[index] = _array[smallest];
			_array[smallest] = temp;
			MinHeapify(smallest);
		}
	}
}

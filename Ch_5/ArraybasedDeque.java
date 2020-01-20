package 第五章;

import 第四章.deque;
//5.37
public class ArraybasedDeque<E> implements deque<E>
{
	private ArrayList<E> list;
	
	public ArraybasedDeque()
	{
		list=new ArrayList();
	}
	@Override
	public void insertionFromTop(E target) 
	{
	   list.add(target);
	   E transfer=target;
	   for(int i=list.size()-1;i>0;i--)
	   {
		   list.set(i, list.get(i-1));
	   }list.set(0,target);
		
	}

	@Override
	public void insertionFromBottom(E target)
	{
		list.add(target);	
	}

	@Override
	public E deletionFromBottom() 
	{
		return list.remove(list.size()-1);		
	}

	@Override
	public E deletionFromTop() 
	{
		return list.remove(0);	
	}

	@Override
	public boolean isEmpty()
	{	
		return list.isEmpty();
	}
	
	/*public static void main(String[] args) 
	{
		ArraybasedDeque deque=new ArraybasedDeque();
		deque.insertionFromBottom(1);
		deque.insertionFromBottom(2);
		deque.insertionFromBottom(3);
		deque.insertionFromBottom(4);
		System.out.println(deque);
		deque.insertionFromTop(2);
		deque.insertionFromTop(3);
		deque.insertionFromTop(4);
		System.out.println(deque);
	}*/

}

package 第五章;

import 第四章.Queue;


public class ArraybasedQueue<E> implements Queue<E>
{
    private ArrayList<E> list;
    
    public ArraybasedQueue()
    {
    	list= new ArrayList();
    }
	@Override
	public void add(E target) 
	{
		list.add(target);	
	}

	@Override
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	@Override
	public E remove() 
	{
		return list.remove(0);
	}
	
	public static void main(String[] args) 
	{
		ArraybasedQueue queue=new ArraybasedQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		while(!queue.isEmpty())
		{
			System.out.println(queue.remove());
		}
	}
  
}

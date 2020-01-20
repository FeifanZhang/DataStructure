package µÚËÄÕÂ;
//4.19
public class DoubleStackQueue implements Queue
{

	Stack stack1;
	Stack stack2;
	
	public DoubleStackQueue()
	{
		stack1=new Stack();
		stack2=new Stack();
		
	}
	
	@Override
	public void add(Object target) 
	{
		stack2.push(target);
		
	}

	@Override
	public boolean isEmpty() 
	{
		if(stack1.isEmpty()==true&&stack2.isEmpty()==true)return false;
		else return false;		
	}

	@Override
	public Object remove()
	{
		if(stack1.isEmpty()==true)
			for(;;)
			{
				if(stack2.isEmpty()==true) break;
				else 
				{
					stack1.push(stack2.pop());
				}		
			}
		if(stack1.isEmpty()==true)return null;
		else return stack1.pop();
	}
  

	
	        
		   
}

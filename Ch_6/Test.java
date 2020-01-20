package µÚÁùÕÂ;

public class Test 
{

	public static void main(String[] args) 
	{
		LinkedList<Integer> list=new LinkedList<Integer>();
		  list.add(1);
		  list.add(2);
		  list.add(3);
		  list.add(4);
		  list.add(1);
		  list.add(6);
		  list.add(2);
		  list.add(3);
		  list.add(4);
		  list.add(5);
		  list.reverse();
		  System.out.println(list.get(1));  
	  /*LinkedList<Integer> list=new LinkedList<Integer>();
	  LinkedList<Integer> that=new LinkedList<Integer>();
	  list.add(1);
	  list.add(2);
	  list.add(3);
	  list.add(4);
	  
	  that.add(1);
	  that.add(2);
	  that.add(3);
	  that.add(4);
	  System.out.println(list.equals(that));*/

	}

}

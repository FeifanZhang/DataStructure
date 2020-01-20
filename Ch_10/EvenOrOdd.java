package µÚÊ®ÕÂ;
//10.09
/**preorder**/
//10.14
public class EvenOrOdd 
{
    public static boolean isEven(int i)
    {
    	if(i==0)return true;
    	if(i<0)return false;
    	else return isOdd(i-1);
    }
	
    public static boolean isOdd(int i)
    {
   
    	return isEven(i-1);
    }
    
  
	public static void main(String[] args) 
	{
		System.out.println(isEven(1));
	}

}

package µÚ¾ÅÕÂ;
//9.4
public class binarySearch 
{
    public static boolean binarySearch(int[]data,int target)
    {
    	if(recursiveBinarySearch(data,data.length-1,0,target)==true)return true;
    	else return false;
		
    	
    }
    
    private static boolean recursiveBinarySearch(int[]data,int top,int bottom,int target)
    {
    	if(bottom>top)return false;
    	
    	int midpoint=(top+bottom)/2;
    	if(target<data[midpoint])return recursiveBinarySearch(data,midpoint-1,bottom,target);
    	
    	else if(target==data[midpoint])return true;
    	
    	else if(target>data[midpoint])return recursiveBinarySearch(data,top,midpoint+1,target);
    	
    	else return false;
    	
    }
	

}

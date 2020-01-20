package µÚ°ËÕÂ;

import µÚÎåÕÂ.ArrayList;

//Introduced in Chapter 8
/** An array-based List of Comparables. */
public class SortableArrayList<E extends Comparable<E>>
extends ArrayList<E> {

public boolean contains(E target) {
 insertionSort();
 int bottom = 0;
 int top = size() - 1;
 while (bottom <= top) {
   int midpoint = (top + bottom) / 2;
   int comparison = target.compareTo(get(midpoint));
   if (comparison < 0) {
     top = midpoint - 1;
   } else if (comparison == 0) {
     return true;
   } else {
     bottom = midpoint + 1;
   }
 }
 return false;
}

/** Arrange the elements in this List from smallest to largest. */
public void insertionSort() {
 for (int i = 1; i < size(); i++) {
   E target = get(i);
   int j;
   for (j = i - 1; (j >= 0) && (get(j).compareTo(target) > 0);
	       j--) {
     set(j + 1, get(j));
   }
   set(j + 1, target);
 }
}

//8.15
/** if this bigger than that,return > 1;if they are equal,return = 0;if this smaller than that,return < 0.*/
public int comparable(SortableArrayList that)
{
	     for(int i=0;i<this.size();i++)
	      {
	    	  if(i>that.size())return 1;
	    	  else if(this.get(i).compareTo((E) that.get(i))!=0)return this.get(i).compareTo((E) that.get(i));
	      }
	      if(this.size()<that.size())return-1;
	      else{
	    	  return 0;
	    	  
	      }
}


//6.15
public static void main(String[] args) 
{
	SortableArrayList<String> a = new SortableArrayList<String>();
	SortableArrayList<String> b = new SortableArrayList<String>();
	 a.add("abcde");
	 b.add("abcde");
	 System.out.println(a.comparable(b));
}

}


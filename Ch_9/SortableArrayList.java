package µÚ¾ÅÕÂ;

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
//9.10
public SortableArrayList<E> mergeSort(ArrayList<E>data)
{
	return mergeSortHelper(data,0,data.size()-1);
}

private SortableArrayList<E> mergeSortHelper(ArrayList<E> data, int bottom, int top) 
{
   if(bottom==top)
	   {
	     SortableArrayList<E> result=new SortableArrayList<E>();
	     result.add(data.get(bottom));
	     return result;
	   }
   else
	   {
		 int midpoint=(top+bottom)/2;
		 return merge(mergeSortHelper(data, bottom, midpoint),mergeSortHelper(data, midpoint+1, top));
	   }
  
}

private SortableArrayList<E> merge(SortableArrayList<E> a, SortableArrayList<E> b) 
{
	SortableArrayList<E> result=new SortableArrayList<E>();
	int i=0;
	int j=0;
	
	for(int k=0;k<a.size()+b.size();k++)
	{
		if((j==b.size())||((i<a.size())&&(a.get(i).compareTo(b.get(j))<=0)))
		{
			result.add(a.get(i));
			i++;
		}
		else
		{
			result.add(b.get(j));
			j++;
		}
	}
	return result;
}

//9.14
public static void  quickSort(ArrayList<Integer>data)
{
	quickSortHelper(data,0,data.size()-1);
}

//9.18
private static void quickSortHelper(ArrayList<Integer> data, int bottom, int top)
{
	while(bottom < top) {
	     int midpoint = partition(data, bottom, top);
	     quickSortHelper(data, bottom, midpoint - 1);
	     bottom = midpoint + 1;
	   }
}

private static int partition(ArrayList<Integer> data, int bottom, int top) 
{
	int pivot=data.get(top);
	int firstAfterSmall=bottom;
	for(int i=bottom;i<top;i++)
	{
		if(data.get(i)<=pivot)
		{
			swap(data,firstAfterSmall,i);
			firstAfterSmall++;
		}
	}
	swap(data,firstAfterSmall,top);
	return firstAfterSmall;
}

private static void swap(ArrayList<Integer> data, int i, int j) 
{
	int temp=data.get(i);
	data.set(i, data.get(j));
	data.set(j, temp);
	
}

public static void main(String[] args)
{
	ArrayList<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<10;i++)
	{
		list.add(10-i);
	}
	System.out.println(list);
	quickSort(list);
	System.out.println(list);
}


}


package µÚÎåÕÂ;

import java.util.Iterator;

import javax.swing.JFrame;

//Introduced in Chapter 5
/** An array-based List. */
public class ArrayList<E> implements List<E> {

/** Array of elements in this List. */
private E[] data;

/** Number of elements currently in this List. */
private int size;

/** The List is initially empty. */
public ArrayList() {
 data = (E[])(new Object[1]); // This causes a compiler warning
 size = 0;
}

public void add(E target) {
 if (isFull()) {
   stretch();
 }
 data[size] = target;
 size++;
}

public boolean contains(E target) {
 for (int i = 0; i < size; i++) {
   if (data[i].equals(target)) {
     return true;
   }
 }
 return false;
}

public boolean isEmpty() {
 return size == 0;
}

/** Return true if data is full. */
protected boolean isFull() {
 return size == data.length;
}

public java.util.Iterator<E> iterator() {
 return new ArrayIterator<E>(this);
}

public E get(int index) {
 return data[index];
}

public E remove(int index) {
 E result = data[index];
 for (int i = index + 1; i < size; i++) {
   data[i - 1] = data[i];
 }
 size--;
 return result;
}

public boolean remove(E target) {
 for (int i = 0; i < size; i++) {
   if (data[i].equals(target)) {
     for (int j = i; j < size - 1; j++) {
       data[j] = data[j + 1];
     }
     size--;
     return true; 
   }
 }
 return false;
}

public void set(int index, E target) {
 data[index] = target;
}

public int size() {
 return size;
}

//5.19
public boolean equals(ArrayList<E> list2) 
{
    if(!this.getClass().equals(list2.getClass()))
    {
      return false;
    }
    else if(size != list2.size()) 
    {
      return false;
    }
    for(int i = 0; i < size; i++) 
    {
         if(data[i].equals(list2.get(i))==false) 
         {
           return false;
         }
     
    }
    return true;
  }
//5.21
public void removeAll(E target)
{
	Iterator iter=iterator();
	while(iter.hasNext())
	{
		if(iter.next().equals(target))
		{
			iter.remove();
		}
	}
}

//5.22
public int count(E target)
{
	int counter=0;
	Iterator iter=iterator();
	while(iter.hasNext())
	{
		if(iter.next().equals(target))
		{
			counter++;
		}
	}
	return counter;
}
		
/** Double the length of data. */
protected void stretch() {
 E[] newData = (E[])(new Object[data.length * 2]); // Warning
 for (int i = 0; i < data.length; i++) {
   newData[i] = data[i];
 }
 data = newData;
}
//5.26
public String toString() 
{
 String result = "[ ";
 int counter=0;
 Iterator iter=iterator();
  while(iter.hasNext()) 
 {
   result += iter.next()+ " ";
   counter++;
 }
 return result + "]";
}

//5.23
public static void main(String[] args)
{
	   ArrayList<Integer> list=new ArrayList<Integer>();
	   list.add(1);
	   list.add(1);
	   list.add(2);
	   list.add(3);
	   list.add(3);
	   System.out.println(list.count(1));
	   System.out.println(list.toString());
	   list.removeAll(1);
	   System.out.println(list.toString());
	   System.out.println(list.count(3));
	   ArrayList list2=new ArrayList();
	   list2.add("1");
	   list2.add("1");
	   list2.add("1");
	   list2.add("1");
	   System.out.println(list.equals(list2));
	 
}

}

package µÚ°ËÕÂ;

import µÚÁùÕÂ.LinkedList;
import µÚÁùÕÂ.ListNode;
import µÚÁùÕÂ.Predecessor;

//Introduced in Chapter 8
/** A linked List of Comparables. */
public class SortableLinkedList<E extends Comparable<E>>
extends LinkedList<E> {

/** Add target in order, assuming this List is currently sorted. */
protected void addInOrder(E target) {
 Predecessor<E> prev = this;
 ListNode<E> node = getNext();
 while ((node != null)
		  && (node.getItem().compareTo(target) < 0)) {
   prev = node;
   node = node.getNext();
 }
 prev.setNext(new ListNode<E>(target, node));
}

/** Arrange the elements in this List from smallest to largest. */
public void insertionSort() {
 SortableLinkedList<E> newList = new SortableLinkedList<E>();
 for (E e : this) {
   newList.addInOrder(e);
 }
 setNext(newList.getNext());
}


//8.16
/** if this bigger than that,return > 1;if they are equal,return = 0;if this smaller than that,return < 0.*/
public int compareble(SortableLinkedList that)
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


public static void main(String[] args) 
{
 SortableLinkedList<String> a = new SortableLinkedList<String>();
 SortableLinkedList<String> b = new SortableLinkedList<String>();
 a.add("abcd");
 b.add("abcde");
 System.out.println(a.compareble(b));
 
 
 
 SortableLinkedList<String> ls = new SortableLinkedList<String>();
 ls.add("command-line-args-please");
 for (String s : args) {
   ls.add(s);
 }
 System.out.println(ls);
 ls.insertionSort();
 System.out.println(ls);
}

}




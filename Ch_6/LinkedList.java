package ตฺม๙ีย;

import java.util.Iterator;

//Introduced in Chapter 6
/** A linked list. */
public class LinkedList<E> implements List<E>, Predecessor<E> {

/** The first node in the List. */
private ListNode<E> front;

/** A LinkedList is initially empty. */
public LinkedList() {
 front = null;
}

public void add(E target) {
 Predecessor<E> last = this;
 while (last.getNext() != null) {
   last = last.getNext();
 }
 last.setNext(new ListNode<E>(target));
}

public boolean contains(E target) {
 for (ListNode<E> node = front;
      node != null;
      node = node.getNext()) {
   if (node.getItem().equals(target)) {
     return true;
   }
 }
 return false;
}

public E get(int index) {
 ListNode<E> node = front;
 for (int i = 0; i < index; i++) {
   node = node.getNext();
 }
 return node.getItem();
}

public ListNode<E> getNext() {
 return front;
}

public boolean isEmpty() {
 return front == null;
}

public java.util.Iterator<E> iterator() {
 return new ListIterator<E>(this);
}

public E remove(int index) {
 Predecessor<E> prev = this;
 ListNode<E> node = front;
 for (int i = 0; i < index; i++) {
   prev = node;
   node = node.getNext();
 }
 prev.setNext(node.getNext());
 return node.getItem();
}

public boolean remove(E target) {
 Predecessor<E> prev = this;
 ListNode<E> node = front;
 while (node != null) 
 {
   if (node.getItem().equals(target)) 
   {
     prev.setNext(node.getNext());
     return true;
   }
   prev = node;
   node = node.getNext();
 }
 return false;
}

public void set(int index, E target) {
 ListNode<E> node = front;
 for (int i = 0; i < index; i++) {
   node = node.getNext();
 }
 node.setItem(target);
}

public void setNext(ListNode<E> next) {
 front = next;
}

public int size() {
 int tally = 0;
 for (ListNode<E> node = front;
      node != null;
      node = node.getNext()) {
   tally++;
 }
 return tally;
}

public String toString() {
 String result = "( ";
 for (ListNode<E> node = front;
      node != null;
      node = node.getNext()) {
   result += node.getItem() + " ";
 }
 return result + ")";
}

//6.9
public boolean equals(LinkedList<E>that)
{
	if(that==null)return false;
	
	ListNode<E> thisNode = this.getNext();
	ListNode<E> thatNode = that.getNext();
	
	 while (thisNode != null&&thatNode!=null) 
	 {
	   if (!thisNode.getItem().equals(thatNode.getItem())) 
	   {
	     return false;
	   }
	   thisNode=thisNode.getNext();
	   thatNode=thatNode.getNext();
	 }
	 if(thatNode!=null||thisNode!= null)return false;
	 else return true;	
}
//6.10
public int indexOf(E target)
{
	int result=0;
	Iterator iter=iterator();
	  while(iter.hasNext()) 
	 {
	   if(iter.next().equals(target))return result;
	   result++;
	 }
	  return-1;
}

//6.11
public boolean removeAll(E target)
{
	 boolean result=false;
	 Predecessor<E> prev = this;
	 ListNode<E> node = front;
	 while (node != null) 
	 {
	   if (node.getItem().equals(target)) 
	   {
	     prev.setNext(node.getNext());
	     result=true;
	   }
	   prev = node;
	   node = node.getNext();
	 }
	 return result;
}

//6.27
public void reverse()
{
	LinkedList<E> list=new LinkedList<E>();
	for(int counter=this.size()-1;counter>=0;counter--)
	{
		list.add(this.get(counter));
	}
	this.setNext(list.front);
	
}

}

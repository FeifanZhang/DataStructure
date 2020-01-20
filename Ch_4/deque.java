package ╣зкдуб;
//4.18
public interface deque<E> 
{
   public void insertionFromTop(E target);
   
   public void insertionFromBottom(E target);
   
   public E deletionFromBottom();
   
   public E deletionFromTop();
   
   public boolean isEmpty();
  
}

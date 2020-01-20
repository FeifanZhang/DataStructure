package 第十章;

import 第五章.ArraybasedQueue;
//10.20
public class TreeNode<E> 
{
  private E item;
  
  private TreeNode<E> firstChild;
  
  private TreeNode<E> nextSibling;
  
  public TreeNode(E item)
  {
	  this.item=item;
  }
  
  public TreeNode(E item,TreeNode<E>firstChild,TreeNode<E>nextSibling)
  {
	  this.item=item;
	  this.firstChild=firstChild;
	  this.nextSibling=nextSibling;
  }
  
  public void setItem(E item)
  {
	  this.item=item;
  }
  
  public E getItem()
  {
	  return item;
  }
  
  private void setFirstChild(TreeNode<E>firstChild)
  {
	  this.firstChild=firstChild;
  }
  
  private TreeNode<E> getFirstChild()
  {
	  return firstChild;
  }
  
  private void setNextSibling(TreeNode<E>nextSibling)
  {
	  this.nextSibling=nextSibling;
  }
  
  private TreeNode getNextSibling()
  {
	  return nextSibling;
  }
 
  
  public boolean hasLeaf()
  {
	  return(this.firstChild!=null);
  }
  
  private boolean hasNextSibling()
  {
	  return (this.nextSibling!=null);
  }
  
  public void setChild(TreeNode<E> that)
  {
	  if(this.hasLeaf()==false)this.setFirstChild(that);
	  else
	  {
		  TreeNode a=this.getFirstChild();
		  while(a.hasNextSibling())
		  {
			  a=a.getNextSibling();
		  }a.setNextSibling(that);
	  }
  
  }
  
  public TreeNode<E> getChild(int direction)
  {
	  TreeNode a=this.getFirstChild();
	  if(direction==1)return a;
	  else{
		    for(int i=1;i<direction;i++){
		    	if(a.hasNextSibling())a=a.getNextSibling();
		    	else{
		    		return null;
		    	}
		    }return a;
	  }
  }
  
  
  
  public ArraybasedQueue<String> toStringPostOrder(){
	  int space=0;
	  ArraybasedQueue<String> q = (ArraybasedQueue<String>) new ArraybasedQueue<E>();
	  
	  if(this.item!=null)addItem(this.item,space,q);
	  
	  if(this.hasLeaf()){	  
          addChild(this.getFirstChild(),space+2,q);
}
	  
	  if(this.hasNextSibling()){  
		            addSibling(this.getNextSibling(),space,q);
		  }
	
	  
	  
	  return q;
  }
  
  private void addItem(E node,int space,ArraybasedQueue<String> q){
	  
	  String result=new String();
	  for(int i=0;i<space;i++){
		  result+=" ";
	  }
	  result+=node;
	  q.add(result);
	  return;
  }
  
  private void addSibling(TreeNode node,int space,ArraybasedQueue<String> q){
	  node.addItem(node.getItem(), space, q);
	  
	  if(node.hasLeaf()){	    
          addChild(node.getFirstChild(),space+2,q);
}
	  
	  if(node.hasNextSibling()){	 
		            addSibling(node.getNextSibling(),space,q);
	  }
	  
	  return;
  }
  
private void addChild(TreeNode node,int space,ArraybasedQueue<String> q){
	
	 node.addItem(node.getItem(), space, q);
	 
	 if(node.hasLeaf()){	    
         addChild(node.getFirstChild(),space+2,q);
     }
	  
	 if(node.hasNextSibling()){	 
         addSibling(node.getNextSibling(),space,q);
     }

     return;
  }
  



  
  public static void main(String[] args){
	     int q=2;
	  	TreeNode a=new TreeNode(q);
	  	a.setChild(new TreeNode(3));
	  	a.setChild(new TreeNode(4));
	  	a.setChild(new TreeNode(5));
	  	a.setChild(new TreeNode(6));
	  	a.setChild(new TreeNode(7));
	  	
	  	a.getChild(2).setChild(new TreeNode(10));
	  	a.getChild(2).setChild(new TreeNode(11));
	  	a.getChild(2).setChild(new TreeNode(12));
	  	
	  	ArraybasedQueue s=a.toStringPostOrder();
	  	
	  	while(!(s.isEmpty())){
	  		System.out.println(s.remove().toString());
	  	}
	  	
  }

  
}

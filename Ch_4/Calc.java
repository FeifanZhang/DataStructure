package µÚËÄÕÂ;
//4.20
public class Calc 
{
  Stack number;
  Stack symbol;
   
  public Calc()
  {
	  number=new Stack();
	  symbol=new Stack();
  }
  
  public void chengchu()
  {
	  if(symbol.pop().equals("*"))
		  {
		    number.push((int)number.pop()*(int)number.pop());
		    
		  }else
		  {
			  number.push((int)number.pop()/(int)number.pop());
		  }
  }
  
  public void jiajian()
  {
	  if(symbol.pop().equals("+"))
	  {
	    number.push((int)number.pop()+(int)number.pop());
	    
	  }else
	  {
		  number.push((int)number.pop()-(int)number.pop());
	  }
  }
  
  public void youkuohao()
  {
	  for(;;)
	  {
		  if(symbol.peek().equals("("))
		  {
			  symbol.pop();
			  return;
		  }else if(symbol.peek().equals("*")||symbol.peek().equals("/"))
		  {
			  chengchu();
		  }else if(symbol.peek().equals("+")||symbol.peek().equals("-"))
		  {
			  jiajian();
		  }
	  }
  }
  
  public void start(String formula)
  {
	  for(int i=0;i<formula.length();i++)
	  {
		  String a=String.valueOf(formula.charAt(i));
		  if(a.equals(")"))
		  {
			  youkuohao();
		  }else if(a.equals("*")||a.equals("/"))
		  {
			  symbol.push(a);
			  i=i+1;
			  number.push(String.valueOf(formula.charAt(i)));
			  chengchu();
		  }else if(a.equals("+")||a.equals("-")||a.equals("("))
		  {
			  symbol.push(a);
			  i=i+1;
			  number.push(String.valueOf(formula.charAt(i)));
		  }else number.push(formula.charAt(i));
		  
	  }
	  
	  for(;;)
	  {
		  if(number.isEmpty()==false)
		  {
			  jiajian();
		  }
	  }
  }
}

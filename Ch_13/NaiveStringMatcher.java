package 第十三章;

import 第五章.ArrayList;

//Introduced in Chapter 13
/** Simply checks each position in the text for the pattern. */
public class NaiveStringMatcher extends AbstractStringMatcher {

/** Pattern is the pattern being sought. */
public NaiveStringMatcher(String pattern) {
 super(pattern);
}

public int match(String text) {
 for (int position = 0;
      position + getPattern().length() <= text.length();
      position++) {
   if (matchAt(text, position)) {
     return position;
   }
 }
 return -1;
}

public ArrayList<Integer> allMatches(String text){
	ArrayList<Integer> result=new ArrayList<Integer>();
	for (int position = 0;
		 position + getPattern().length() <= text.length();
		 position++) {
		   if (matchAt(text, position)) {
		     result.add(position);
		   }/*add function for wild card*/
		   else{
			   for(int i=0;i<getPattern().length();i++){
				   /*|表示执行两个表达式 ||表示执行一个*/
				   if(getPattern().charAt(i)!=text.charAt(position+i)){
					   if(getPattern().charAt(i)!='?')break;
				   }
				   if(i==getPattern().length()-1) result.add(position);
			   }
	
		   }
		 }
	if(result.size()==0){
		result.add(-1);
	}return result;
}




}

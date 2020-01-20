package 第十三章;

import 第五章.ArrayList;

//Introduced in Chapter 13
/** String matcher using the Knuth-Morris-Pratt skipping algorithm. */
public class KnuthMorrisPrattStringMatcher
extends AbstractStringMatcher {

/**
* Length of longest pattern prefix ending at each position in
* pattern.
*/
private int[] prefixArray;

/** Pattern is the pattern being sought. */
public KnuthMorrisPrattStringMatcher(String pattern) {
 super(pattern);
 prefixArray = new int[getPattern().length()]; // All zeroes
 int i = 1;
 int matches = 0;
 while (i < getPattern().length()) {
   if (getPattern().charAt(i) == getPattern().charAt(matches)) {
     matches++;
     prefixArray[i] = matches;
     i++;
   }/*13.11*/
   else if(getPattern().charAt(i)=='?'){
	 matches++;
	 prefixArray[i] = matches;
	 i++;
   } else if (matches > 0) {
     matches = prefixArray[matches - 1];
   } else {
     i++;
   }
 }
}

public int match(String text) {
 int i = 0;
 int matches = 0;
 while (i < text.length()) {
   if (text.charAt(i) == getPattern().charAt(matches)) {
     matches++;
     if (matches == getPattern().length()) {
       return i + 1 - getPattern().length();
     } else {
       i++;
     }
   } else if (matches > 0) {
     matches = prefixArray[matches - 1];
   } else {
     i++;
   }
 }
 return -1;
}


public ArrayList<Integer> allMatches(String text){
	ArrayList<Integer> result=new ArrayList<Integer>();
	for (int position = 0;
		 position + getPattern().length() <= text.length();
		 position++){
		if(match(text.substring(position, position+getPattern().length()))!=-1)result.add(position);
	}return result;
}

public static void main(String[] args) {
 System.out.println(new KnuthMorrisPrattStringMatcher("plan").match("amanaplanacanalpanama"));
}

}


package 第十三章;

import 第五章.ArrayList;

//Introduced in Chapter 13
/** Searches for a pattern String in various text Strings. */
public abstract class AbstractStringMatcher {

/** The pattern being sought. */
private String pattern;

/** Pattern is the pattern being sought. */
public AbstractStringMatcher(String pattern) {
 this.pattern = pattern;
}

/** Return the pattern this StringMatcher seeks. */
protected String getPattern() {
 return pattern;
}

/** Return true if the pattern appears in text at position. */
protected boolean matchAt(String text, int position) {
 for (int i = 0; i < pattern.length(); i++) {
   if (pattern.charAt(i) != text.charAt(i + position)) {
     return false;
   }
 }
 return true;
}


/*13.7*/
/**return all positions where the pattern appears within that String
* can use'?'as a wild card
*/
public abstract ArrayList<Integer> allMatches(String text);
	


/**
* Return the index of the first appearance of the pattern in
* text, or -1 if it does not appear.
* can use'?'as a wild card
*/
public abstract int match(String text);

}


package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}
		return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores")) {
			s = s.replace(" ", "_");
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char check1 = '1';
		char check2 = '2';
		char check3 = '3';
		int startFirst = 0;
		int startSecond = 0;
		int startThird = 0;
		int endFirst = 0;
		int endSecond = 0;
		int endThird = 0;
		
		for(int i = s1.indexOf(" "); i < s1.length(); i++) {
			if(Character.isTitleCase(s1.charAt(i))&&!Character.isLowerCase(s1.charAt(i+1))) {
				startFirst = i;
				check1 = s1.charAt(i);
			}
			if(Character.isLowerCase(s1.charAt(i))&&!Character.isAlphabetic(s1.charAt(i+1))) {
				endFirst = i;
				break;
			}
		}
		for(int i = s2.indexOf(" "); i < s2.length(); i++) {
			if(Character.isTitleCase(s2.charAt(i))&&!Character.isLowerCase(s2.charAt(i+1))) {
				startSecond = i;
				check1 = s2.charAt(i);
			}
			if(Character.isLowerCase(s2.charAt(i))&&!Character.isAlphabetic(s2.charAt(i+1))) {
				endSecond = i;
				break;
			}
		}
		for(int i = s3.indexOf(" "); i < s3.length(); i++) {
			if(Character.isTitleCase(s3.charAt(i))&&!Character.isLowerCase(s3.charAt(i+1))) {
				startThird = i;
				check1 = s3.charAt(i);
			}
			if(Character.isLowerCase(s3.charAt(i))&&!Character.isAlphabetic(s3.charAt(i+1))) {
				endThird = i;
				break;
			}
		}
		int ascii1 = (int)check1;
		int ascii2 = (int)check2;
		int ascii3 = (int)check3;
		if(ascii1>ascii2&&ascii1>ascii3) {
			return s1.substring(startFirst, endFirst);
		}
		if(ascii2>ascii1&&ascii2>ascii3) {
			return s2.substring(startSecond, endSecond);
		}
			return s3.substring(startThird, endThird);
		
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		return 0;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return null;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}

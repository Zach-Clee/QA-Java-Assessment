package com.qa.javaAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		System.out.println(word);
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {        
        List<Integer> listOfInt = new ArrayList<Integer>();
        String text = input.toLowerCase();
        String word = "bert";
        String result = "";

        for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; i++) {
        	listOfInt.add(i);
        }      
        
        if (listOfInt.size() <= 1){
        	return "";
        } else {
            int a = listOfInt.get(0)+4;
            int b = listOfInt.get(1);
            text = text.substring(a,b);
        	char[] try1 = text.toCharArray(); 
            for (int i = try1.length-1; i>=0; i--) {
            	result += try1[i];
            }
        }

        return result;        
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int arr[] = new int[3];
		int compareArray[] = new int[2];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		int firstNumberToCompare = 0;
		int secondNumberToCompare = 0;
		
		
		for(int i = 0; i < 3; i++) {
		    Arrays.sort(arr);
		}
		

		for(int i = 0; i < 2; i++) {
			firstNumberToCompare = arr[i];
		    secondNumberToCompare = arr[i+1];
		    compareArray[i] = secondNumberToCompare - firstNumberToCompare;
		}
		
		if (compareArray[0] == compareArray[1]){
			return true;
		}
		
		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {

		String str = input;
		int l = str.length();

		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < a; i++){
			l = sb.length();
			if((l % 2) == 0){
				sb.deleteCharAt((l+1)/2).toString();
			}else{
				sb.deleteCharAt((l-1)/2).toString();
			}
		}
		String result = sb.toString();
		
		return result;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		char firstLetter;
		char secondLetter;
		int letterCount = 0;
		int maxCount = 0;
		
		char stringArray[] = new char [input.length()];
		for (int i = 0; i < input.length(); i++){
			stringArray[i] = input.charAt(i);		
		}
		
		for (int i = 0; i < stringArray.length-1; i++){
			firstLetter = stringArray[i];
			secondLetter = stringArray[i+1];
			if (firstLetter == secondLetter){
				letterCount++;
			} else {
				if (maxCount < letterCount)
				{
				maxCount = letterCount;
				letterCount = 0;
				}
			}
		}
		return maxCount;
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
			String str = arg1;
			String word[] = {"am", "Am"};
		    // split the string by spaces in a 
		    String a[] = str.split(" "); 
		  
		    // search for pattern in a 
		    int count = 0; 
		    
		    for (int i = 0; i < word.length; i++)  
		    { 
		    // if match found increase count 
		    for (int j = 0; j < a.length; j++)
		    {
		    	if (word[i].equals(a[j])) {
		    		count++; 
		    	}
		    } 
		    }
		    return count;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		//Use Modulo
		
		if ((arg1 % 3 == 0) && (arg1 % 5 == 0)){
			System.out.println("fizzbuzz");
			return "fizzbuzz";
		}
		else if (arg1 % 3 == 0){
			System.out.println("fizz");
			return "fizz";
		}
		else if (arg1 % 5 == 0){
			System.out.println("buzz");
			return "buzz";
		}
		else {
			return null;
		}
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		int stringLength = arg1.length();
		int[] intArray = new int[stringLength];
		int[] summedNumbersArray = new int[stringLength];
		int firstValue = 0;
		int secondValue = 0;
		int readInValue = 0;
		
		for (int i=0; i< arg1.length(); i++) {
			intArray[i] = Character.getNumericValue(arg1.charAt(i));
		}
		
		int arrayPosition = 0;
		
		for (int i=0; i< arg1.length(); i++) {
			readInValue = intArray[i];
			if (readInValue == -1){
				arrayPosition++;
			} else {
				summedNumbersArray[arrayPosition]+=readInValue;
			}
		}

		arrayPosition = 0;
		firstValue = summedNumbersArray[arrayPosition];
		for (int i=1; i < summedNumbersArray.length; i++) {
			secondValue = summedNumbersArray[i];
			if (secondValue > firstValue){
				firstValue = secondValue;
			}arrayPosition++;
		}
		return firstValue;
	}
}

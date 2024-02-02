package com.DayOne;

public class CharacterCount {
	public static void main (String[] args ) {
		String s = "pradnyadesai";
		int[] arr = new int[25];
		for (int i=0 ; i<s.length(); i++) {
			arr[s.charAt(i)-'d']++;	
		}
		char ch ='i';
		System .out.println("The count of "+ch+ " is " +arr[ch-'d']);
	}

}

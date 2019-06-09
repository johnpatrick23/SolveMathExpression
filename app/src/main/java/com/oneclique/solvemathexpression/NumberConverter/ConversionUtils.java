package com.oneclique.solvemathexpression.NumberConverter;

public class ConversionUtils extends Utils {

	public String reverseString(String string){

		int len = string.length();
		String output = "";
		for(int i = len-1; i >= 0; i--){
			output+=string.charAt(i);
		}
		return output;
	}

	public int power(int number, int exponent){
		int p = 1;
		if(exponent == 0){
			p = 1;
		}
		else if (exponent != 0){
			for(int i = exponent; i > 0; i--){
				p*=number;
			}

		}
		return p;
	}
	
}

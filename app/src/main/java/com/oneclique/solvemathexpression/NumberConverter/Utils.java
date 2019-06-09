package com.oneclique.solvemathexpression.NumberConverter;

public abstract class Utils {
	public String reverseString(String string){	return string;}
	public int power(int number, int exponent){	return exponent;}
	
	public String Binary_To_Decimal(String binary){	return binary;}
	public String Binary_To_Hexa(String binary){	return binary;}
	public String Binary_To_Octal(String binary){	return binary;}
	
	public String Decimal_To_Binary(String decimal){return decimal;}
	public String Decimal_To_Hexa(String decimal){	return decimal;}
	public String Decimal_To_Octal(String decimal){	return decimal;}
	
	public String Octa_To_Binary(String octal){	return octal;}
	public String Octa_To_Decimal(String octal){return octal;}
	public String Octa_To_Hexa(String octal){	return octal;}

	public String Hexa_To_Binary(String hexa){	return hexa;}
	public String Hexa_To_Octal(String hexa){	return hexa;}
	public String Hexa_To_Decimal(String hexa){	return hexa;}

	public String AND(String binary1, String binary2){ return binary1;}
	public String NAND(String binary1, String binary2){ return binary1;}
	public String NOT(String binary){ return binary;}
	public String OR(String binary1, String binary2){ return binary1;}
}

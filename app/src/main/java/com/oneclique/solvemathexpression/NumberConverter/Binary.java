package com.oneclique.solvemathexpression.NumberConverter;

public class Binary extends Decimal{
	@Override
	public String Binary_To_Decimal(String binary){
		String decimal="0";
		int multiplier = 1;
		String bi = reverseString(binary);
		int len = bi.length();
		for(int i = 0; i < len; i++){

			if(bi.charAt(i) == '0'){
				decimal = Long.toString(Long.parseLong(decimal)+0);
			}
			else{
				decimal = Long.toString(Long.parseLong(decimal)+ multiplier);
			}			
			multiplier *= 2;
		}
		return decimal;
	}
	@Override
	public String Binary_To_Hexa(String binary){
		return Decimal_To_Hexa( Binary_To_Decimal(binary) );
	}
	@Override
	public  String Binary_To_Octal(String binary){
		return Decimal_To_Octal( Binary_To_Decimal(binary) );
	}
}

package com.oneclique.solvemathexpression.NumberConverter;

public class Hexa extends Binary {
	
	@Override
	public String Hexa_To_Binary(String binary){
		return Decimal_To_Binary(Hexa_To_Decimal(binary));
	}
	
	@Override
	public String Hexa_To_Decimal(String hexa){
		String hex_ = reverseString(hexa);
		String decimal = "0";
		
		int len = hex_.length();
		
		for(int i = 0; i < len; i++){
			if(hex_.charAt(i) == 'A'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*10));
			}
			else if(hex_.charAt(i) == 'B'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*11));
			}
			else if(hex_.charAt(i) == 'C'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*12));
			}
			else if(hex_.charAt(i) == 'D'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*13));
			}
			else if(hex_.charAt(i) == 'E'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*14));
			}
			else if(hex_.charAt(i) == 'F'){
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*15));
			}
			else{
				decimal = Long.toString(Long.parseLong(decimal) + (power(16, i)*Long.parseLong(Character.toString(hex_.charAt(i)))));
			}
		}
		
		return decimal;
	}
	
	@Override
	public String Hexa_To_Octal(String hexa){
		return Decimal_To_Octal(Hexa_To_Decimal(hexa));
	}
}

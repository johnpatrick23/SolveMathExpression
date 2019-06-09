package com.oneclique.solvemathexpression.NumberConverter;

public class Convert extends Hexa{
	@Override
	public String Octa_To_Decimal(String octal){
		String deci = "", oct = "";
		int len = 0;
		if(octal.length() <= 21){
			deci = "0";
			octal = reverseString(octal);
			len = octal.length();
			for(int i = 0; i < len; i++){
				deci = Long.toString(Long.parseLong(deci) + (power(8, i)*Long.parseLong(Character.toString(octal.charAt(i))))) ;
			}
			return deci;
		}else{ 
			String str = "1777777777777777777777";
			for(int i = 0; i < octal.length(); i++){
				if(str.charAt(i) != octal.charAt(i)){
					for(int j = i; j < octal.length(); j++){
						deci += Character.toString(octal.charAt(j));
						oct += "7";
					}
					break;
				}
			}
			deci = Long.toString(Long.parseLong(oct) - Long.parseLong(deci));
			deci = Long.toString(Long.parseLong(Octa_To_Decimal(deci)) + 1);
			deci = Long.toString(Long.parseLong(deci) * -1);
			return deci;
		}
	}
	@Override
	public String Octa_To_Hexa(String octal){
		return Decimal_To_Hexa(Octa_To_Decimal(octal));
	}
	@Override
	public String Octa_To_Binary(String octal){
		return Decimal_To_Binary(Octa_To_Decimal(octal));
	}
}

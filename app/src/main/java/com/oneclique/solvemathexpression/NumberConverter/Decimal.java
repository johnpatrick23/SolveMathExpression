package com.oneclique.solvemathexpression.NumberConverter;

public class Decimal extends ConversionUtils{
	@Override
	public String Decimal_To_Binary(String decimal){
		String binary = "";
		if(Long.parseLong(decimal) >= 0){
			while(Long.parseLong(decimal) != 0){
				if(Long.parseLong(decimal)%2 == 0){
					binary+="0";
				}
				else{
					binary+="1";
				}
				decimal = Long.toString(Long.parseLong(decimal)/2);
			}
		}else if(Long.parseLong(decimal) == -1){
			for(int i = 0; i < 64; i++){
				binary += "1";
			}
			return binary;
		}else if(Long.parseLong(decimal) < -1){ 
			decimal = Long.toString((Long.parseLong(decimal) * -1) -1);
			while(Long.parseLong(decimal) != 0){
				if(Long.parseLong(decimal)%2 == 0){
					binary += "1";
				}
				else{
					binary += "0";
				}
				decimal = Long.toString(Long.parseLong(decimal)/2);
			}
			int len = binary.length();
			for(int i = len; i < 64; i++){
				binary += "1";
			}
		}
		return reverseString(binary);
	}
	@Override
	public String Decimal_To_Octal(String decimal){
		String Octal = "";
		if(Long.parseLong(decimal) >= 0){
			while(Long.parseLong(decimal) != 0){
				Octal+=(Long.toString(Long.parseLong(decimal) % 8));
				decimal = Long.toString(Long.parseLong(decimal)/8);
			}
			return reverseString(Octal);
		}
		else if(Long.parseLong(decimal) == -1){
			return "1777777777777777777777";
		}
		else if(Long.parseLong(decimal) < -1){
			Octal = Decimal_To_Octal(Long.toString((Long.parseLong(decimal) * -1) -1));
			int len = Octal.length();
			String hold = "";
			for(int i = 0; i < len; i++){
				hold+="7";
			}
			Octal = reverseString(Long.toString(Long.parseLong(hold) - Long.parseLong(Octal)));
			len = Octal.length();
			for(int i = len; i < 21; i++ ){
				Octal += "7";
			}
			Octal+=1;
		}
		return reverseString(Octal);
	}
	@Override
	public String Decimal_To_Hexa(String decimal){
		String hexa = "";
		if(Long.parseLong(decimal) >= 0){
			while(Long.parseLong(decimal) != 0){
				if(Long.parseLong(decimal) % 16 == 10){	hexa+="A";}
				else if(Long.parseLong(decimal) % 16 == 11){hexa+="B";}
				else if(Long.parseLong(decimal) % 16 == 12){hexa+="C";}
				else if(Long.parseLong(decimal) % 16 == 13){hexa+="D";}
				else if(Long.parseLong(decimal) % 16 == 14){hexa+="E";}
				else if(Long.parseLong(decimal) % 16 == 15){hexa+="F";}
				else{hexa+=Long.toString(Long.parseLong(decimal) % 16);}
				decimal = Long.toString(Long.parseLong(decimal)/16);
			}
			return reverseString(hexa);
		}
		else if(Long.parseLong(decimal) == -1){
			for(int i = 0; i < 16; i++){
				hexa+="F";
			}
		}
		else if(Long.parseLong(decimal) < -1){
			decimal = Long.toString((Long.parseLong(decimal)*-1)-1);
			while(Long.parseLong(decimal) != 0){
				if(Long.parseLong(decimal) % 16 == 15){	hexa+="0";	}
				else if(Long.parseLong(decimal) % 16 == 14){hexa+="1";	}
				else if(Long.parseLong(decimal) % 16 == 13){hexa+="2";	}
				else if(Long.parseLong(decimal) % 16 == 12){hexa+="3";	}
				else if(Long.parseLong(decimal) % 16 == 11){hexa+="4";	}
				else if(Long.parseLong(decimal) % 16 == 10){hexa+="5";	}
				else if(Long.parseLong(decimal) % 16 == 9){	hexa+="6";	}
				else if(Long.parseLong(decimal) % 16 == 8){	hexa+="7";	}
				else if(Long.parseLong(decimal) % 16 == 7){	hexa+="8";	}
				else if(Long.parseLong(decimal) % 16 == 6){	hexa+="9";	}
				else if(Long.parseLong(decimal) % 16 == 5){	hexa+="A";	}
				else if(Long.parseLong(decimal) % 16 == 4){	hexa+="B";	}
				else if(Long.parseLong(decimal) % 16 == 3){	hexa+="C";	}
				else if(Long.parseLong(decimal) % 16 == 2){	hexa+="D";	}
				else if(Long.parseLong(decimal) % 16 == 1){	hexa+="E";	}
				else if(Long.parseLong(decimal) % 16 == 0){	hexa+="F";	}
				decimal = Long.toString(Long.parseLong(decimal)/16);
			}
			int len = hexa.length();
			for(int i = len; i < 16; i++){
				hexa += "F";
			}
		}
		return reverseString(hexa);
	}
}
/*
				
*/
package com.oneclique.solvemathexpression.Calculator;

public class Calculator {
	public int value(char c){
		if(c == '*' || c == '/'){return 2;}
		else if(c == '+' || c == '-'){return 1;}
		else{return 0;}
	}
	public String compute(char Operator, String a, String b){
		switch(Operator){
		case'*': return Long.toString(Long.parseLong(a) * Long.parseLong(b));
		case'/': return Long.toString(Long.parseLong(a) / Long.parseLong(b));
		case'+': return Long.toString(Long.parseLong(a) + Long.parseLong(b));
		case'-': return Long.toString(Long.parseLong(a) - Long.parseLong(b));
		default: return "0";
		}
	}
	public void operate(MyStack<String> int_, char OpeHold){
		String a = "", b = "", c = "";
		b = int_.pop();
		a = int_.pop();
		c = compute(OpeHold, a, b);
		int_.push(c);
	}
	
}

package com.oneclique.solvemathexpression.util;

import android.util.Log;
import android.widget.TextView;

import com.oneclique.solvemathexpression.Calculator.Calculator;
import com.oneclique.solvemathexpression.Calculator.MyStack;
import com.oneclique.solvemathexpression.NumberConverter.Convert;


public class MathSolve extends Convert {
    private Calculator calculate = new Calculator();
    private MyStack<String> num = new MyStack<>();
    private MyStack <String> ope = new MyStack<>();
    private String intStr = "0";
    private String lastOp = " ", newOpe = " ";
    private int limit = 0;

    public String calculate(TextView editText, String expression, char type){
        for (int i = 0; i < expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                intStr += expression.charAt(i);
            }else {
                num.push(checkType(type, intStr));
                String operator = String.valueOf(expression.charAt(i));
                newOpe = operator.trim().toLowerCase().equals("x") ? "*" : operator;
                check(editText, type);
                intStr = "0";
            }
        }
        num.push(checkType(type, intStr));
        String num1, num2, result = "", oper;
        try {
            while (!num.isEmpty() && !ope.isEmpty()) {
                num2 = num.pop();
                num1 = num.pop();
                oper = ope.pop();
                result = calculate.compute(oper.charAt(0), num1, num2);
                num.push(result);
            }
            intStr = result;
        } catch (Exception e) {
            Log.i("MathSolve", "calculate: " + e.getMessage());
        }
        return checkTypeReverse(type, intStr);
    }

    private String checkType(char inputType, String input){
        String returnS;
        switch(inputType){
            case 'b':{	returnS =  Binary_To_Decimal(input); break;	}
            case 'o':{	returnS =  Octa_To_Decimal(input);	break;	}
            case 'h':{	returnS =  Hexa_To_Decimal(input);	break;	}
            default : returnS = input;
        }
        return returnS;

    }

    private String checkTypeReverse(char inputType, String input){
        String returnS;
        switch(inputType){
            case 'b':{	returnS =  Decimal_To_Binary(input);break;	}
            case 'o':{	returnS =  Decimal_To_Octal(input);	break;	}
            case 'h':{	returnS =  Decimal_To_Hexa(input);	break;	}
            default : returnS = input;
        }
        return returnS;

    }

    private void check(TextView txtView, char type){
        if(ope.isEmpty()){
            ope.push(newOpe);
        }
        else{
            lastOp = ope.pop();
            if(calculate.value(newOpe.charAt(0)) > calculate.value(lastOp.charAt(0))){
                ope.push(lastOp);
                ope.push(newOpe);
            }
            else if(calculate.value(newOpe.charAt(0)) == calculate.value(lastOp.charAt(0))){
                ope.push(newOpe);
                calculate.operate(num, lastOp.charAt(0));
            }
            else if(calculate.value(newOpe.charAt(0)) < calculate.value(lastOp.charAt(0))){
                ope.push(newOpe);
                calculate.operate(num, lastOp.charAt(0));
            }
            intStr = num.pop();
            num.push(intStr);
            if(intStr.equals("0")){
                txtView.setText("0");
            }
            txtView.setText(checkTypeReverse(type,intStr));
            intStr = "0";
        }
    }

}

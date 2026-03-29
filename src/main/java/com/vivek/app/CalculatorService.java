package com.vivek.app;

import java.util.*;

public class CalculatorService {

    public double evaluate(String expr) {
        expr = expr.replaceAll("\\*\\*", "^"); // support power
        return eval(expr);
    }

    private double eval(String expr) {
        Stack<Double> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {

            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                double num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--;
                nums.push(num);
            }

            else if (c == '(') ops.push(c);

            else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            }

            else if (isOp(c)) {
                while (!ops.isEmpty() && prec(ops.peek()) >= prec(c)) {
                    nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private boolean isOp(char c) {
        return c=='+'||c=='-'||c=='*'||c=='/'||c=='^';
    }

    private int prec(char op) {
        if (op=='+'||op=='-') return 1;
        if (op=='*'||op=='/') return 2;
        if (op=='^') return 3;
        return 0;
    }

    private double apply(char op, double b, double a) {
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            case '^': return Math.pow(a,b);
        }
        return 0;
    }
}

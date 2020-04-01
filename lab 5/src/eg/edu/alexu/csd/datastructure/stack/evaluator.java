package eg.edu.alexu.csd.datastructure.stack;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class evaluator implements IExpressionEvaluator {

    stack s = new stack();


    @Override
    // this function to convert infix to postfix
    public String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder ex = new StringBuilder(expression);
        int noIntegers = 0;
        int noOperations = 0;
        char temp;
        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            switch (c) {
                case ('+'):
                    if (s.isEmpty() || s.peek().toString().equals("(")) {
                        s.push(c);
                    } else {
                        result.append(s.pop().toString() +' ');
                        noOperations++;
                        i--;
                    }
                    break;
                case ('-'):
                    if (ex.charAt(i+1)!=' '){
                        // dummy zero
                        temp = ex.charAt(i+1);
                        ex.setCharAt(i,'(');
                        ex.setCharAt(i+1,'0');
                        ex.insert(i+2,'-');
                        ex.insert(i+3,' ');
                        ex.insert(i+4,temp);
                        ex.insert(i+5,')');
                        i--;
                        noOperations--;
                        noIntegers--;
                    }
                    else {
                        if (s.isEmpty() || s.peek().toString().equals("(")) {
                            s.push(c);
                        } else {
                            result.append(s.pop().toString() + ' ');
                            noOperations++;
                            i--;
                        }
                    }
                    break;
                case ('*'):
                    if (s.isEmpty() || s.peek().toString().equals("+") || s.peek().toString().equals("-")
                            || s.peek().toString().equals("(")){
                        s.push(c);
                    }
                    else {
                        result.append(s.pop().toString() +' ');
                        noOperations++;
                        i--;
                    }
                    break;
                case ('/'):
                    if (s.isEmpty() || s.peek().toString().equals("+") || s.peek().toString().equals("-")
                            || s.peek().toString().equals("(")){
                        s.push(c);
                    }
                    else {
                        result.append(s.pop().toString() + ' ');
                        noOperations++;
                        i--;
                    }
                    break;
                case ' ':
                    break;
                case '(':
                    s.push(c);
                    break;
                case ')':
                    if (s.peek().toString().equals("(")){
                        s.pop();
                    }
                    else {
                        result.append(s.pop().toString() + ' ');
                        noOperations++;
                        i--;
                    }
                    break;
                default:
                    while (Character.isLetterOrDigit((ex.charAt(i)))) {
                        result.append(ex.charAt(i));
                        i++;
                        if (i == ex.length()) {
                            break;
                        }
                    }
                    if (!Character.isLetterOrDigit((ex.charAt(i-1)))){
                        throw new RuntimeException();
                    }
                    result.append(' ');
                    noIntegers++;
                    if (i == ex.length()) {
                        continue;
                    }
                    i--;
                    break;
            }

        }

        while (s.size()!=0){
            result.append(s.pop().toString() + ' ');
            noOperations++;
        }
        if (noIntegers-noOperations !=1){
            throw new RuntimeException();
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    @Override
    public int evaluate(String expression) {
        if (expression.length() == 0 || expression.equals(" ")){
            throw new RuntimeException();
        }
        float num1;
        float num2;
        for (int i = 0 ; i<expression.length() ; i++){
            char c = expression.charAt(i);
            switch (c) {
                case '+' :
                    num2 = (float)(s.pop());
                    num1 = (float)(s.pop());
                    s.push((num1 + num2));
                    break;

                case '-' :
                    num2 = (float)(s.pop());
                    num1 = (float)(s.pop());
                    s.push((num1 - num2));
                    break;

                case '*' :
                    num2 = (float)(s.pop());
                    num1 = (float)(s.pop());
                    s.push((num1 * num2));
                    break;

                case '/' :
                    num2 = (float)(s.pop());
                    num1 = (float)(s.pop());
                    if (num2==0){
                        throw new RuntimeException();
                    }
                    else{
                        s.push((num1 / num2));
                    }
                    break;

                case ' ' :
                    break;

                default:
                    StringBuilder result = new StringBuilder();
                    while (Character.isDigit(expression.charAt(i))){
                        result.append(expression.charAt(i));
                        i++;
                        if (i==expression.length()){
                            break;
                        }
                    }
                    s.push(Float.parseFloat(result.toString()));
            }
        }
        return Math.round((float)(s.pop()));
    }

    public static void main(String[] args) {
        evaluator evl = new evaluator();
        Scanner in = new Scanner(System.in);
        String infix;
        int result;
        String postfix;
        infix = in.nextLine();
        try {
            postfix = evl.infixToPostfix(infix);
            result = evl.evaluate(postfix);
            System.out.println("postfix:");
            System.out.println(postfix);
            System.out.println("evaluate result :");
            System.out.println(result);
        }
        catch (Exception excep){
            System.out.println("invaled");
        }

    }
}
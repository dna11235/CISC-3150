// Nikita Dmitriev - Homework 7 - Calculator
// Run Command: java Calculator "2.3 * 7 - ( 3 + 1 ) / 2"
// This format works both for windows and unix
// Reference: infix to postfix
// http://interactivepython.org/runestone/static/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
// Reference: regex - https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

import java.util.*;

// Exceptions
class DivisionByZero extends ArithmeticException{
    String ex;
    public DivisionByZero(){}
    public DivisionByZero(String ex){ this.ex = ex; }
    public String toString(){
        return ex;
    }
}
class LookAtMrAlgebraOverHereException extends IllegalArgumentException{
    String ex;
    public LookAtMrAlgebraOverHereException(){}
    public LookAtMrAlgebraOverHereException(String ex){
        this.ex = ex;
    }
    public String toString(){
        return ex;
    }
}
class IllegalOperationException extends IllegalArgumentException{
    String ex;
    public IllegalOperationException(){}
    public IllegalOperationException(String ex){
        this.ex = ex;
    }
    public String toString(){
        return ex;
    }
}
class UserIsADumbassException extends IllegalArgumentException{
    String ex;
    public UserIsADumbassException(){}
    public UserIsADumbassException(String ex){ this.ex = ex; }
    public String toString(){
        return "Unsupported input format! "+ex;
    }
}

// Class to check input for validity
class Validator{
    Validator(){}

    public static boolean checkInput(String[] s) throws UserIsADumbassException, LookAtMrAlgebraOverHereException, IllegalOperationException{
        boolean flag = true;
        try {
            // If no arguments passed, or more than expected - error and print instructions
            if (s.length == 0){
                throw new UserIsADumbassException("Not enough arguments");
            } else if (s.length > 1){
                throw new UserIsADumbassException("Too many arguments");
            } else {
                // Convert argument into array
                boolean varFlag = false;
                String strippedInput = "";
                String[] localS = toStringArr(s[0]);
                // Strip spaces and parenthesis
                for (int i = 0; i<localS.length;i++){
                    if (isDigit(localS[i]) && !varFlag){
                        varFlag = true;
                    } else if (localS[i].matches("[-+*/%]") && varFlag){
                        varFlag = false;
                    } else if (localS[i].matches("[)(]")){
                        // Skip parenthesis
                    } else if (!varFlag){
                        // We expect digit/sign/digit/sign pattern, if not flag will identify which character broke pattern
                        throw new LookAtMrAlgebraOverHereException("Wrong operand, only Integers and Doubles supported > " + localS[i]+" <");
                    } else if (varFlag){
                        throw new IllegalOperationException("Operation is not supported > "+localS[i]+" <");
                    }
                }
            }
        } catch (UserIsADumbassException ex){
            flag = false;
            System.out.println("ERROR: "+ex);
            printHelp();
        } catch (LookAtMrAlgebraOverHereException ex){
            flag = false;
            System.out.println("ERROR: "+ex);
            printSupported();
        } catch (IllegalOperationException ex){
            flag = false;
            System.out.println("ERROR: "+ex);
            printSupported();
        }
        return flag;
    }

    // For integers and doubles alike
    public static boolean isDigit(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    // Simple print function
    public static void printStringArr(String[] s){
        for (int i = 0; i<s.length;i++){
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    // Convert String to String[]
    public static String[] toStringArr(String str){
        return str.split(" ");
    }

    // Print proper input format
    public static void printHelp(){
        System.out.println("Calculator usage: java Calculator \"expression\"");
        System.out.println("Example: java Calculator \"4.5 * ( 2 + 3 )\" ");
        printSupported();
    }

    public static void printSupported(){
        System.out.println("Separate each term within expression with space");
        System.out.println("Supported operations: - + / * % ()");
    }
}

// Calculation handler
class Calc{
    Calc(){
        // Exception check for variables
    }

    // Convert infix to postfix
    public String in2pos(String[] s){
        Stack<String> stack = new Stack<>();
        String postfix = "";

        for (int i =0; i<s.length;i++){
            if (Validator.isDigit(s[i])) {
                postfix = postfix + s[i] + " ";
            } else if (s[i].equals("(")){
                stack.push(s[i]);
            } else if (s[i].equals(")")){
                while (!stack.peek().equals("(")){
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && !(stack.peek().equals("(")) && precedence(s[i]) <= precedence(stack.peek())){
                    postfix = postfix + stack.pop() + " ";
                }
                stack.push(s[i]);
            }
        }
        while (!stack.isEmpty()){
            postfix = postfix + stack.pop() + " ";
        }
        return postfix;
    }

    // Check precedence
    private int precedence(String s){
        if (s.matches("[-+]")){
            return 1;
        }
        if (s.matches("[*/%]")){
            return 2;
        }
        return 0;
    }

    // Solve from postfix, also check for valid input
    // It's convenient to do checks when input formatted
    public double calculate(String in) throws DivisionByZero{
        String[] s = Validator.toStringArr(in);
        Stack<Double> op = new Stack<>();
        double a, b;
        for (int i=0; i< s.length;i++){
            if (s[i].matches("[-+*/%]")){
                b = op.pop();
                a = op.pop();
                switch (s[i]){
                    case "-": {
                        op.push(a-b);
                        break;
                    }
                    case "+": {
                        op.push(a+b);
                        break;
                    }
                    case "*": {
                        op.push(a*b);
                        break;
                    }
                    // Check both division operations for division by 0
                    case "/": {
                        if (b == 0) {
                            throw new  DivisionByZero("Division by 0");
                        } else {
                            op.push(a / b);
                            break;
                        }
                    }
                    case "%": {
                        if (b == 0) {
                            throw new  DivisionByZero("Division by 0");
                        } else {
                            op.push(a % b);
                            break;
                        }
                    }
                }
            } else {
                op.push(Double.parseDouble(s[i]));
            }
        }
        return op.pop();
    }
}

public class Calculator {
    public static void main(String[] args){
        System.out.print("Input: ");
        Validator.printStringArr(args);

        // For the sake of Shell, Unix, and Command line we are only concerned with args[0] because of '' format
        // Checking inputs
        if (Validator.checkInput(args)) {
            Calc s = new Calc();

            // Debug
            // Validator.printStringArr(Validator.toStringArr(args[0]));
            // Validator.printStringArr(Validator.toStringArr(s.in2pos(Validator.toStringArr(args[0]))));
            try {
                System.out.println(s.calculate(s.in2pos(Validator.toStringArr(args[0]))));
            } catch (DivisionByZero ex) {
                System.out.println("ERROR: " + ex);
            }
        }
    }
}

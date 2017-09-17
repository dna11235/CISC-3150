// Nikita Dmitriev - Homework 3
// Run command: java HW3 | tee hw3-output.txt

import java.util.*;

class MyString{
    private char[] myString;

    // Constructor
    public MyString(char[] chars){
        myString = chars;
    }

    // Methods
    public char charAt(int index){
        return myString[index];
    }
    public int length(){
        return myString.length;
    }
    public MyString substring(int begin, int end) {
        char[] newString = new char[end-begin+1];
        for (int i=0; begin+i <= end;i++){
            newString[i] = myString[begin+i];
        }
        return new MyString(newString);
    }

    public MyString toLowerCase(){
        char[] newString = new char[myString.length];
        for (int i=0; i<myString.length; i++){
            newString[i] = Character.toLowerCase(myString[i]);
        }
        return new MyString(newString);
    }
    public MyString toUpperCase(){
        char[] newString = new char[myString.length];
        for (int i=0; i<myString.length; i++){
            newString[i] = Character.toUpperCase(myString[i]);
        }
        return new MyString(newString);
    }
    public boolean equals(MyString s){
        if (s.length() != myString.length){
            return false;
        }
        for (int i=0; i<s.length(); i++){
            if (myString[i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public MyString getMyString(){
        return new MyString(myString);
    }
    public String toString(){
        return new String(myString);
    }
    public static MyString valueOf(int i){
        char[] newCharArr = (""+i).toCharArray();
        return new MyString(newCharArr);
    }
}

public class HW3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Process and verify initial input
        System.out.println("Enter words: ");
        MyString testString = new MyString(input.nextLine().toCharArray());
        System.out.println("MyString is: "+testString.getMyString());

        // Test length() method
        System.out.println("Length of MyString is: "+testString.length());

        // Test charAt() method
        System.out.println("Enter index: ");
        int index = Integer.parseInt(input.next());
        System.out.println("Value at "+index+" is: "+testString.charAt(index));

        // Test substring() method
        System.out.println("Enter indexes of new string from and to in format: A B > ");
        int indBeg = Integer.parseInt(input.next());
        int indEnd = Integer.parseInt(input.next());
        input.nextLine(); // disregard new line character from previous input
        System.out.println("Your input: " + indBeg + " " + indEnd);
        System.out.println("New substring is: "+testString.substring(indBeg,indEnd));

        // Test uppercase() method
        System.out.println("Uppercase is: "+testString.toUpperCase());

        // Test lowercase() method
        System.out.println("Lowercase is: "+testString.toLowerCase());

        // Test valueOf() static method without an instance
        System.out.println("Enter integer value to convert: ");
        int val = Integer.parseInt(input.nextLine());
        System.out.println("Value of "+val+" is: "+MyString.valueOf(val)+" with the length: " + MyString.valueOf(val).length());

        // Test equals() method for false
        System.out.println("Enter word to compare: ");
        MyString compString = new MyString(input.nextLine().toCharArray());
        System.out.println(testString.getMyString()+ " equals "+compString.getMyString()+": "+testString.equals(compString));

        // Test equals() method for true
        System.out.println("Another word to compare: ");
        compString = new MyString(input.nextLine().toCharArray());
        System.out.println(testString.getMyString()+ " equals "+compString.getMyString()+": "+testString.equals(compString));
    }
}

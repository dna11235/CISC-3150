// Nikita Dmitriev - Homework 2 - Question 3
// Run command: java Question3 >> Question3-output.txt

import java.util.*;

public class Question3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word;
        int flag = 0;

        System.out.println("Enter a word: ");
        word = input.next();
        char[] cword = word.toCharArray(); // reference: https://www.javatpoint.com/java-string-tochararray

        for (int i=0;i < cword.length/2; i++){
            if (cword[i] != cword[cword.length-1-i]){
                System.out.println("The word " + word + " is not a palindrome");
                return;
            } else {
                flag++;
            }
        }
        if (flag == cword.length/2){
            System.out.println("The word " + word + " is palindrome");
        }
    }
}
// TEST IT AND TEST IT
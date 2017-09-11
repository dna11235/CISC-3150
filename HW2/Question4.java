// Nikita Dmitriev - Homework 2 - Question 4
// Run command: java Question4 >> Question4-output.txt

import java.util.*;

public class Question4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        testcase: // reference: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html
        for (int i=0; i < 20; i++){
            System.out.println("Inside outer loop");
            for (int j=20; j > 0; j--){
                System.out.println("Inside middle loop");
                for (int k = 0; k < j; k++){
                    System.out.println("Inside inner loop");
                    if (k == 15){
                        break testcase;
                    }
                    System.out.println(i + ", " + j + ", " + k);
                }
                System.out.println("outside inner loop");
            }
            System.out.println("outside middle loop");
        }
        System.out.println("outside outer loop");
        System.out.println("done!");
    }
}
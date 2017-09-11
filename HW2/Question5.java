// Nikita Dmitriev - Homework 2 - Question 5
// Run command: java Question5 >> Question5-output.txt

import java.util.*;

public class Question5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        input.useDelimiter(",");

        System.out.println("Enter words separated by \",\": ");

        while (input.hasNext()){
            System.out.println(input.next());
        }
    }
}
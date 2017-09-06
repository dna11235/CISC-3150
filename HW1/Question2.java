// Nikita Dmitriev - Homework 1 - Question 2
// Run command: java Question2 2>&1 | tee Question2-output.txt
// Reference: https://stackoverflow.com/questions/13591374/command-output-redirect-to-file-and-terminal

import java.util.*;
import java.math.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius;

        System.out.println("Calculate area of a circle.");
        System.out.println("Please enter radius:");
        while (input.hasNext()){
            radius = Double.parseDouble(input.next());
            System.out.println("For the radius of " + radius + " the area is: " + Math.PI * Math.pow(radius, 2));
            System.out.println("Please enter radius:");
        }
    }
}

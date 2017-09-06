// Nikita Dmitriev - Homework 1 - Question 3
// Run command: java Question3 >> Question3-output.txt

import java.util.*;
import java.math.*;

public class Question3 {
    public static void main(String[] args) {

        String[] month = new String[]{
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        int range = (12 - 1) + 1;
        int num;

        for (int i = 0; i<12; i++) { // Testing random generator
        	num = (int)(Math.random() * range) + 1;
            System.out.println("The month is: " + month[num - 1]);
        }
    }
}

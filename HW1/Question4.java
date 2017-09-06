// Nikita Dmitriev - Homework 1 - Question 4
// Run command: java Question4 < Question4-input.txt >> Question4-output.txt

import java.io.*;
import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num;

        while (input.hasNext()){
            num = Double.parseDouble(input.next());
                System.out.println(num);
            }
        System.out.println("Done!");
    }
}

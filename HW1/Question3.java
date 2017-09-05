// Nikita Dmitriev - Homework 1 - Question 3
import java.io.*;
import java.util.*;
import java.math.*;

public class Question3 {
    public static void main(String[] args) {
        try {
            FileWriter filename = new FileWriter("Question3-output.txt");
            PrintWriter outstream = new PrintWriter(filename);

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

                int num = (int)(Math.random() * range) + 1;
                System.out.println(num);
                outstream.println("The month is: " + month[num - 1]);
                System.out.println("The month is: " + month[num - 1]);
                outstream.flush();
            outstream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

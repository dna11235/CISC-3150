// Nikita Dmitriev - Homework 1 - Question 4
import java.io.*;
import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        try {
            FileWriter filename = new FileWriter("Question4-output.txt");
            PrintWriter outstream = new PrintWriter(filename);
            Scanner input = new Scanner(System.in);
            double num;

            while (input.hasNext()){
                num = Double.parseDouble(input.next());
                outstream.println(num);
                System.out.println(num);
                outstream.flush();
            }
            System.out.println("Done!");
            outstream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

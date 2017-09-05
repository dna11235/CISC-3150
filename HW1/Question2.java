// Author: by Nikita Dmitriev
// References: http://www.baeldung.com/java-write-to-file
import java.io.*;
import java.util.*;
import java.math.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius;
        try {
            FileWriter filename = new FileWriter("Question2-output.txt");
            PrintWriter outstream = new PrintWriter(filename);

            System.out.println("Please enter radius:");
            while (input.hasNext()){
                radius = Double.parseDouble(input.next());
                outstream.println("For the radius of "+radius+" the area is: "+Math.PI * Math.pow(radius, 2));
                System.out.println("For the radius of "+radius+" the area i2s: "+Math.PI * Math.pow(radius, 2));
                System.out.println("Please enter radius:");
                outstream.flush();
            }
            outstream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

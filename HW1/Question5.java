// Nikita Dmitriev - Homework 1 - Question 5
// Run command: java Question5 >> Question5-output.txt

import java.util.*;
import java.math.*;

public class Question5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] a = new double [2];
        double[] b = new double [2];
        double[] c = new double [2];
        double ab, ac, bc;

        System.out.println("Determine Real Triangle");
        System.out.println("Please enter coordinates in format: X Y");
        do {
            System.out.println("Please enter point A: ");
            a[0] = Double.parseDouble(input.next());
            a[1] = Double.parseDouble(input.next());

            System.out.println("Please enter point B: ");
            b[0] = Double.parseDouble(input.next());
            b[1] = Double.parseDouble(input.next());

            System.out.println("Please enter point C: ");
            c[0] = Double.parseDouble(input.next());
            c[1] = Double.parseDouble(input.next());

            System.out.println( "Point A: (" + a[0] + ", " + a[1] + ") " +
                                "Point B: (" + b[0] + ", " + b[1] + ") " +
                                "Point C: (" + c[0] + ", " + c[1] + ") "
            );

            ab = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
            ac = Math.sqrt(Math.pow(c[0] - a[0], 2) + Math.pow(c[1] - a[1], 2));
            bc = Math.sqrt(Math.pow(c[0] - b[0], 2) + Math.pow(c[1] - b[1], 2));
            System.out.println("Side AB: (" + ab + ") Side AC: (" + ac + ") Side BC: (" + bc + ")");

            if (ab + ac > bc || ab + bc > ac || ac + bc > ab) {
                System.out.println("The triangle is real");
            } else {
                System.out.println("The triangle is fake");
            }
            System.out.println("Another triangle (Y/N)? ");
        } while (input.next().toUpperCase().equals("Y"));
    }
}

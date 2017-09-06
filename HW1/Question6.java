// Nikita Dmitriev - Homework 1 - Question 6
// Run command: java Question6 >> Question6-output.txt

import java.util.*;
import java.math.*;

public class Question6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double rad1, rad2;
        double x1, y1;
        double x2, y2;
        double dist;

        System.out.println("Check whether two circles are overlapping");
        System.out.println("Please enter coordinates in format: X Y");
        do {
            System.out.println("Enter coordinates for the center of circle 1: ");
            x1 = Double.parseDouble(input.next());
            y1 = Double.parseDouble(input.next());
            System.out.println("Enter radius for circle 1: ");
            rad1 = Double.parseDouble(input.next());

            System.out.println("Enter coordinates for the center of circle 2: ");
            x2 = Double.parseDouble(input.next());
            y2 = Double.parseDouble(input.next());
            System.out.println("Enter radius for circle 2: ");
            rad2 = Double.parseDouble(input.next());

            System.out.println("Circle 1 coordinates: (" + x1 + ", " + y1 + ") Radius: " + rad1);
            System.out.println("Circle 2 coordinates: (" + x2 + ", " + y2 + ") Radius: " + rad2);

            dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.println("Distance between points: " + dist);

            if (dist == 0 && rad1 == rad2) {
                System.out.println("Circles are identical");
            } else if (dist > rad1 + rad2) {
                System.out.println("Circles are separate from each other");
            } else if (dist == rad1 + rad2) {
                System.out.println("Circles are touching each other");
            } else if (dist + rad1 <= rad2) {
                System.out.println("Circle 1 within circle 2");
            } else if (dist + rad2 <= rad1) {
                System.out.println("Circle 2 within circle 1");
            } else if (dist < rad1 + rad2) {
                System.out.println("Circles are overlapping");
            } else {
                System.out.println("I'll get back to you on that one");
            }

            System.out.println("Do you have another pair of circles to enter (Y for yes)?");
        } while (input.next().toUpperCase().equals("Y"));
    }
}

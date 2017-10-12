// Nikita Dmitriev - Homework 5 - Monte Carlo
// Run command: java HW5 | tee HW5-Output.txt

import java.io.PrintStream;
import java.util.*;

class Dot{
    double x,y;

    Dot(){
        x = 0;
        y = 0;
    }
    void setDot(double a, double b){
        x = a;
        y = b;
    }

    public boolean inCircle(double r){
        if (x == 0 || y == 0){
            return true;
        }
        else if (Math.hypot(x,y) <= r){
            return true;
        }
        else return false;
    }
}

public class HW5 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        Random rand = new Random();
        Long limit = 4000000000L;
        Long inCircle = 0L;
        Dot point = new Dot();
        double radius;
        double sqArea, cirArea;
        double ratio1, ratio2;
        double timer;

        out.println("Please enter radius: ");
        radius = Integer.parseInt(in.nextLine());
        out.println("Value entered: "+radius);

        // Getting proper ratio
        sqArea = radius*radius;
        cirArea = (Math.PI*sqArea)/4;
        ratio1 = cirArea/sqArea;
        out.println("Circle area: "+cirArea);
        out.println("Quadrant area: "+sqArea);
        out.println("Proper ratio: "+ratio1);
        out.println("Proper PI: "+Math.PI);

        // Generate 4 Billion dots
        // Using same object to save memory and tracking efficiency
        timer = System.currentTimeMillis();
        Long i = 0L;
        do {
            // Set point to random coordinates
            point.setDot(rand.nextDouble()*radius,rand.nextDouble()*radius);
            if (point.inCircle(radius)){
                inCircle++;
            }
            i++;
        } while (i < limit);
        timer = (System.currentTimeMillis()-timer)/1000;

        out.println("Dots fell inside circle: "+inCircle);
        out.println("Dots fell outside circle: "+(limit-inCircle));
        // Division of Longs
        ratio2 = (double)inCircle/limit;
        out.println("Calculated ratio: "+ratio2);

        // Calculate our PI value
        out.println("Calculated PI: "+(ratio2*4));
        out.println("Time in the loop: "+timer+" seconds");
    }
}

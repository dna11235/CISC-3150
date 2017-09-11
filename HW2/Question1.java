// Nikita Dmitriev - Homework 2 - Question 1
// Run command: java Question1 >> Question1-output.txt

import java.util.*;

public class Question1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int target;

        System.out.println("How tall would you like your pyramid to be?");
        target = Integer.parseInt(input.next());
        int spacer = target+1;

        for (int i = 1; i<= target; i++){
            spacer--;
            System.out.printf("%"+spacer+"s", "");
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            for (int k = i; k >= 1; k--){
                System.out.print(k);
            }
            System.out.println();
        }


    }
}

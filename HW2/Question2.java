// Nikita Dmitriev - Homework 2 - Question 2
// Run command: java Question2 >> Question2-output.txt
// Otherwise could be implemented with YearMonth class.
// Reference: https://docs.oracle.com/javase/8/docs/api/index.html

import java.util.*;

// Custom month class (only necessary methods are implemented)
class CMonth {
    int month_num;
    int max_days;
    int start_day;
    boolean leap;

    CMonth(int m, int sd, int y){
        month_num = m;
        start_day = sd;
        leap = (y % 4 == 0) ? true : false;
        switch (m){
            case 0: case 2: case 4: case 6: case 7: case 9: case 11:
                max_days = 31;
                break;
            case 3: case 5: case 8: case 10:
                max_days = 30;
                break;
            case 1:
                max_days = (leap) ? 29 : 28;
                break;
        }
    }

    int getMax_days(){return max_days;}
    int getStart_day(){return start_day;}
}

public class Question2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tYear, sDay;
        String tDay;

        String[] month = new String[]{
                "January",
                "February",
                "April",
                "March",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        String[] week = new String[]{
                "Su",
                "Mo",
                "Tu",
                "We",
                "Th",
                "Fr",
                "Sa"
        };

        System.out.println("Please enter a year: ");
        tYear = Integer.parseInt(input.next());

        System.out.println("What day the first of January fell on? (Su, Mo, Tu, We, Th, Fr, Sa)");
        tDay = input.next();

        // Convert string month to corresponding integer
        switch (tDay.toUpperCase()){
            case "SU":
                sDay = 0;
                break;
            case "MO":
                sDay = 1;
                break;
            case "TU":
                sDay = 2;
                break;
            case "WE":
                sDay = 3;
                break;
            case "TH":
                sDay = 4;
                break;
            case "FR":
                sDay = 5;
                break;
            case "SA":
                sDay = 6;
                break;
            default:
                sDay = 0;
                break;
        }

        for (int i = 0; i < 12; i++){
            CMonth cMonth = new CMonth(i, sDay, tYear);
            String header = month[i]+" "+Integer.toString(tYear);
            int day_current = 1;
            int day_week = 1;

            // Header month year
            System.out.printf("%"+(11+(header.length()/2))+"s \n", header); // Center align header
            // Header days of the week
            for (int j = 0; j<7; j++){
                System.out.printf("%3s", week[j]);
            }
            System.out.println();

            // Offset for the first day of the month
            while (day_week <= cMonth.getStart_day()){
                System.out.printf("%3s", "");
                day_week++;
            }
            while (day_current <= cMonth.getMax_days()){
                System.out.printf("%3d", day_current);
                day_current++;
                if (day_week < 7){
                    day_week++;
                } else {
                    // Reset week back to sunday
                    if (day_current <= cMonth.getMax_days()){
                        System.out.println();
                    }
                    day_week = 1;
                }
            }
            System.out.printf("\n\n");
            sDay = day_week-1; // Keep track of last day of the week in previous month.
        }
    }
}

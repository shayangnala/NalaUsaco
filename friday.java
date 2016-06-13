/*
ID: linghui1
LANG: JAVA
TASK: friday
 */
import java.util.*;
import java.io.*;

public class friday {

    public static void main(String[] args) throws Exception {
        // 1900/1/1 = Monday
        // what's the date of 1900, 1, 13
        // 12%7 + 1 = 6: Saturday
        int[] result = new int[8];
////        for (int i = 0; i < 8; i ++) {
////            result[i] = 0;
//        }

        result[6] = 1;
        int startDay = 6;
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int n = Integer.parseInt(in.readLine());
//        int n = 1;

        if (n < 0 || n > 400) {
            return;
        }

        int startYear = 1900;
        printResult(result);
        for (int y = startYear; y <= startYear+n-1; y ++) {
            // compute month 1/13 using days of month 12
            if (y > startYear) {
                startDay = (startDay + 31 % 7) % 7;
                startDay = startDay == 0 ? 7 : startDay;
                result[startDay]++;
                System.out.println(1 + " " + startDay);
            }

            for (int m = 1; m < 12; m ++) {
                // number of days: days[m]
                // startDay = 6
                // month m + 1 13th
                int numOfDays = days[m];
                if (m == 2 && isLeapYear(y)) {
                    numOfDays = 29;
                }
                startDay = (startDay + numOfDays % 7) % 7;
                startDay = startDay == 0 ? 7 : startDay;
                result[startDay] ++;
                printResult(result);
//                System.out.println(m+1+" " + startDay);
            }
        }

        for (int i = 0; i < 6; i ++) {
            int index = (i + 6) % 7;
            if (index == 0) {
                index = 7;
            }
//            System.out.println(index + ": " + result[index]);
            out.print(result[index] + " ");

        }
        out.print(result[5] + "\n");
        out.close();
    }

    static boolean isLeapYear(int n) {
        if (n%100 == 0 && n%400 == 0) {
            return true;
        }

        if (n%100 != 0 && n%4 == 0) {
            return true;
        }

        return false;
    }

    static void printResult(int[] result) {
//        for (int i = 0; i < result.length; i ++) {
//            System.out.print(result[i] + " ");
//        }
//        System.out.print("\n");
    }

    public void removeMe() {
        String newString = "ABCDE";
        newString.matches("[^AB]+$");

    }
}

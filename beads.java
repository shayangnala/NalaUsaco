/*
ID: linghui1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // number of beads in the necklace
        int n = Integer.parseInt(in.readLine());

        // the necklace
        String necklace = in.readLine();

//        int n = 3;
//        String necklace = "rrr";
        // max number of beads we get so far
        int maxNumberOfBeads = 0;



        // break the necklace
        for (int i = 0; i < n; i ++) {
            // return the broken Necklace in char array
            char[] brokenNecklace = new char[n];
            for (int j = 0; j < n; j++) {
                brokenNecklace[j] = necklace.charAt((j + i) % n);
            }

            System.out.println(new String(brokenNecklace) + " ");

            // scan from the beginning;
            char mark = 'w';

            int j = 0;

            for (; j < n; j ++) {
                char a = brokenNecklace[j];
                if (a != 'w' && mark != 'w' && mark != a) {
                    break;
                }

                if (mark == 'w' && a != 'w') {
                    mark = a;
                }
            }

            int reverseCount = 0;
            char reverseMark = 'w';
            int p = n - 1;
            while (reverseCount + j < n) {
                char b = brokenNecklace[p];
                if (b == 'w') {
                    reverseCount ++;
                    p --;
                } else {
                    if (reverseMark == 'w') {
                        reverseMark = b;
                        reverseCount ++;
                        p --;
                    } else if (reverseMark == b) {
                        reverseCount ++;
                        p --;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(j + " " + reverseCount);

            if (j + reverseCount > maxNumberOfBeads) {
                maxNumberOfBeads = j + reverseCount;
            }

        }

        System.out.println("max = " + maxNumberOfBeads);

        out.print(maxNumberOfBeads + "\n");
        out.close();
    }
}

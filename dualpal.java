import java.util.*;
import java.io.*;

/*
ID: linghui1
LANG: JAVA
TASK: dualpal
 */
public class dualpal {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt((String) st.nextElement());
        int s = Integer.parseInt((String) st.nextElement());

        int count = 0;
        s++;
        while (count < n) {
            int subcount = 0;
            int b = 2;
            while (subcount < 2 && b <= 10) {
                if (isPal(s, b)) {
                    subcount ++;
                }
                b ++;
            }

            if (subcount == 2) {
                count ++;
                out.print(s + "\n");
            }
            s ++;
        }

        out.close();
    }

    static boolean isPal(int s, int i) {
        String c = convert(s, i);
//        System.out.println(s + " in " + i + ": " + c);

        for (int j = 0; j < c.length()/2; j ++) {
            char a = c.charAt(j);
            char b = c.charAt(c.length() - j - 1);

//            System.out.println(a + " " + b);

            if (a != b) {
                return false;
            }
        }

        return true;

    }

    static String convert(int s, int b) {
        StringBuilder sb = new StringBuilder();
        while (s != 0) {
            sb.append(s%b);
            s = s/b;
        }

        return sb.reverse().toString();
    }
}

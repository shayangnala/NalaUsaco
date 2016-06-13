import java.io.*;

/*
ID: linghui1
LANG: JAVA
TASK: palsquare
 */
public class palsquare {
    static char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J'};
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int b = Integer.parseInt(in.readLine());

        for (int i = 1; i < 300; i ++) {
            String square = convert(i*i, b); // convert i^2 to b based string
            if (isPal(square)) {
                out.print(convert(i, b) + " " + square + "\n");
            }
        }

        out.close();
    }

    static String convert(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while(n!=0) {
            sb.append(map[n%b]);
            n = n/b;
        }
        return sb.reverse().toString();
    }

    static boolean isPal(String s) {
        for (int i = 0; i < s.length()/2; i ++) {
            char a = s.charAt(i);
            char b = s.charAt(s.length() - 1 - i);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

}

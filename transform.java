import java.util.*;
import java.io.*;

/*
ID: linghui1
LANG: JAVA
TASK: transform
 */
public class transform {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        // size of the square
        int n = Integer.parseInt(in.readLine());

        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("N is not in the range of 1 to 10.");
        }

        // the square
        char[][] original = new char[n][n];
        char[][] target = new char[n][n];

        // read original
        for (int i = 0; i < n; i ++) {
            original[i] = in.readLine().toCharArray();
        }

        // read target
        for (int j = 0; j < n; j ++) {
            target[j] = in.readLine().toCharArray();
        }

        int result = transform(original, target);
        out.print(result + "\n");
        out.close();

    }

    private static int transform(char[][] original, char[][] target) {
        // #1 rotate clockwise 90 degrees
        char[][] rotated90 = rotate90(original);
        System.out.println("rotated 90");
        print(rotated90);
        if (isSame(rotated90, target)) {
            return 1;
        }

        // #2 rotate 180 degress
        char[][] rotated180 = rotate90(rotated90);
        System.out.println("rotated 180");
        print(rotated180);
        if (isSame(rotated180, target)) {
            return 2;
        }

        // #3 rotate 270 degrees
        char[][] rotated270 = rotate90(rotated180);
        System.out.println("rotated 270");
        print(rotated270);
        if (isSame(rotated270, target)) {
            return 3;
        }

        // #4 reflect horizontally
        char[][] reflected = reflect(original);
        System.out.println("reflected");
        print(reflected);
        if (isSame(reflected, target)) {
            return 4;
        }

        char[][] reflected90 = rotate90(reflected);
        System.out.println("reflected 90");
        print(reflected90);

        char[][] reflected180 = rotate90(reflected90);
        System.out.println("reflected 180");
        print(reflected180);

        char[][] reflected270 = rotate90(reflected180);
        System.out.println("reflected 270");
        print(reflected270);

        if (isSame(reflected90, target) ||
                isSame(reflected180, target) ||
                    isSame(reflected270, target)) {
            return 5;
        }

        // #6
        System.out.println("Original");
        print(original);
        System.out.println("Target");
        print(target);

        if (isSame(original, target)) {
            return 6;
        }

        // #7
        return 7;
    }

    // reflect horizontally
    private static char[][] reflect(char[][] original) {
        int n = original.length;
        char[][] t = new char[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                t[i][n - 1 - j] = original[i][j];
            }
        }

        return t;
    }

    // rotate 90 degrees
    private static char[][] rotate90(char[][] original) {
        int n = original.length;
        char[][] t = new char[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                t[j][n - 1 - i] = original[i][j];
            }
        }

        return t;
    }

    private static boolean isSame(char[][] original, char[][] target) {
        if (original.length != target.length || original[0].length != target[0].length) {
            return false;
        }

        for (int i = 0; i < original.length; i ++) {
            for (int j = 0; j < original[0].length; j ++) {
                if (original[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(char[][] m) {
        for (int i = 0; i < m.length; i ++) {
            for (int j = 0; j < m.length; j ++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

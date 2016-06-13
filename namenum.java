import java.util.*;
import java.io.*;

/*
ID: linghui1
LANG: JAVA
TASK: namenum
 */
public class namenum {

    private static final Map<Long, List> map;

    static {
        map = new HashMap();
        map.put(2L, Arrays.asList("A", "B", "C"));
        map.put(3L, Arrays.asList("D", "E", "F"));
        map.put(4L, Arrays.asList("G", "H", "I"));
        map.put(5L, Arrays.asList("J", "K", "L"));
        map.put(6L, Arrays.asList("M", "N", "O"));
        map.put(7L, Arrays.asList("P", "R", "S"));
        map.put(8L, Arrays.asList("T", "U", "V"));
        map.put(9L, Arrays.asList("W", "X", "Y"));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        // The number
        long num = Long.parseLong(in.readLine());

        // table
        Map<Long, List<String>> table = new HashMap();
        List<String> names = translate(num, table);

        // get the dict
        BufferedReader dictIn = new BufferedReader(new FileReader("dict.txt"));
        Set<String> dict = new HashSet();
        String next;
        while ((next = dictIn.readLine()) != null) {
            dict.add(next);
        }

        // get valid names
        List<String> validNames = new ArrayList();

        for (String n : names) {
//            System.out.println(n);
            if (dict.contains(n)) {
                System.out.println("validName: " + n);
                validNames.add(n);
            }
        }

        Collections.sort(validNames);

        if (validNames.size() == 0) {
            out.print("NONE\n");
        }

        for (String name: validNames) {
            out.print(name + "\n");
        }

        out.close();
    }

    private static List<String> translate(long num, Map<Long, List<String>> table) {
        List<String> result = new ArrayList();

        // no match if num < 2
        if (num < 2) {
            return result;
        }

        if (num < 10) {
            return map.get(num);
        }

        // get the lowest digit, ex 4734
        long x = num % 10; // 4
        long y = num / 10; // 473

        // translate y
        List<String> prefixList;
        if (table.containsKey(y)) {
            System.out.println("in if");
            prefixList = table.get(y);
        } else {
            System.out.println("in else: " + y);
            prefixList = translate(y, table);
//            table.put(y, prefixList);
        }
        List<String> suffixList = map.get(x);
//        for (String m : suffixList) {
//            System.out.print(m + " ");
//        }
//        System.out.println("");
        for (String p : prefixList) {
            for (String s : suffixList) {
//                System.out.println("p:" + p + " s:" + s);
                result.add(p + s);
            }
        }

        table.put(num, result);
        return result;
    }
}

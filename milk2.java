import java.io.*;
import java.util.*;
/*
ID: linghui1
LANG: JAVA
TASK: milk2
 */
public class milk2 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        // number of pairs of integers
        int n = Integer.parseInt(in.readLine());
        Interval[] pairs = new Interval[n];
        // list of all intervals
        for (int i = 0; i < n; i ++) {
            String line = in.readLine();
            Interval interval = parseLine(line);
            pairs[i] = interval;
        }

        // sort the list by start number asceding
        // and merge overlapped intervals
        List<Interval> merged = merge(sort(pairs));
        int conTime = merged.get(0).length;
        int idleTime = 0;

        for (int i = 1; i < merged.size(); i ++) {
            Interval curr = merged.get(i);
            Interval prev = merged.get(i - 1);
            if (curr.length > conTime) {
                conTime = curr.length;
            }

            if (curr.start - prev.end > idleTime) {
                idleTime = curr.start - prev.end;
            }
        }

//        System.out.println(conTime + " " + idleTime + "\n");
        out.print(conTime + " " + idleTime + "\n");
        out.close();
    }

    private static List<Interval> merge(Interval[] sorted) {
        List<Interval> result = new ArrayList();
        if (sorted.length < 1) {
            return result;
        }

        // push the first element into result
        result.add(sorted[0]);
        // get the last element from list
        // merge the current one with one
        // if overlapped, replace the last elem with the merged one
        // if not overlapped, push the new interval into the list
        for (int i = 1; i < sorted.length; i ++) {
            Interval last = result.get(result.size() - 1);
            Interval current = sorted[i];
            System.out.println("last: " + last.toString() + " current: " + current.toString());
            if (overlap(last, current)) {
                // merge
                Interval merged = new Interval();
                merged.start = last.start;
                merged.end = last.end >= current.end ? last.end : current.end;
                merged.length = merged.end - merged.start;
                result.remove(result.size() - 1);
                result.add(merged);
                System.out.println("merged: " + merged.toString());
            } else {
                result.add(current);
                System.out.println("current: " + current.toString());
            }
        }
        return result;
    }

    private static boolean overlap(Interval i1, Interval i2) {
        // start
        if (i2.start <= i1.end) {
            return true;
        }

        return false;
    }
    private static Interval[] sort(Interval[] intervals) {

        for (int i = 0; i < intervals.length - 1; i ++) {
            for (int j = i + 1; j < intervals.length; j ++) {
                if (intervals[j].start < intervals[i].start) {
                    // swap i and j;
                    Interval temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }

//        for (int i = intervals.length - 1; i > 0; i --) {
//            for (int j = i - 1; j >= 0; j --) {
//                int s1 = intervals[j+1].start;
//                int s2 = intervals[j].start;
//                if (s1 >= s2) {
//                    intervals[j+1] = intervals[j+1];
//                    break;
//                }
//
//                Interval temp = intervals[j+1];
//                intervals[j+1] = intervals[j];
//                intervals[j] = temp;
//            }
//        }
//
        return intervals;
    }

    private static Interval parseLine(String line) {
        Interval interval = new Interval();
        // set the start, end, length
        StringTokenizer st = new StringTokenizer(line);
        interval.start = Integer.parseInt(st.nextToken());
        interval.end = Integer.parseInt(st.nextToken());
        interval.length = interval.end - interval.start;
        return interval;
    }

    static class Interval {
        int start;
        int end;
        int length;

        @Override
        public String toString() {
            return "s: " + start + " e: " + end + " l: " + length;
        }
    }
}

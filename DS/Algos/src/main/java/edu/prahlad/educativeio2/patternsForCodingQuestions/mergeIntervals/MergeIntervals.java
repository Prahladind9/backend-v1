package edu.prahlad.educativeio2.patternsForCodingQuestions.mergeIntervals;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals
 * to produce a list that has only mutually exclusive intervals.
 * or
 * Given a set of intervals, find out if any two intervals overlap
 *
 * Time: O(n log(n))
 * Space: O(n)
 */
public class MergeIntervals {

    /**
     *
     * 1) Sort the intervals on the start time to ensure a.start <= b.start
     * 2) If ‘a’ overlaps ‘b’ (i.e. b.start <= a.end),
     *    we need to merge them into a new interval ‘c’ such that:
     *      c.start = a.start
     *      c.end = max(a.end, b.end)
     *
     * 3) We will keep repeating the above two steps to merge ‘c’ with the next interval if it overlaps with ‘c’.

     */
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()){
            interval = iterator.next();

            if(interval.start <= end){ //overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            }else { //non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
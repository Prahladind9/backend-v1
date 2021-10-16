package edu.prahlad.educativeio.patternforCodingQuestions.mergeIntervals;

import java.util.*;
/**
 * Given a list of intervals, merge all the overlapping intervals
 * to produce a list that has only mutually exclusive intervals.
 *
 * TC: O(n * logN) ==> n for looping through elements, logN to sort the collection
 * SC: O(n)
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2)
            return intervals;

        /* 1) Sort the intervals by start time
           2) If 'a' overlaps 'b' i.e., b.start <= a.end, we need to merge them into a new interval 'c' such that:
                c.start = a.start
                c.end = max(a.end, b.end)
           3) We will keep repeating the above 2 steps to merge 'c' with the next interval if it overlaps with 'c'
         */

        //1) sort
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();

        int start = interval.start;
        int end = interval.end;

        while (intervalIterator.hasNext()){
            interval = intervalIterator.next();

            if(interval.start <= end){ //overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            }else { //non-overlapping
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static boolean anyOverlap(List<Interval> intervals){
        if(intervals.size() < 2) return false;

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();

        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()){
            interval = iterator.next();
            if(interval.start <= end){
                return true;
            }else{
                start = interval.start;
                end = interval.end;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.println("AnyOverlap intervals: " + anyOverlap(input));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.println("AnyOverlap intervals: " + anyOverlap(input));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.println("AnyOverlap intervals: " + anyOverlap(input));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();


        input = new ArrayList<Interval>();
        input.add(new Interval(1, 2));
        input.add(new Interval(9, 12));
        input.add(new Interval(5, 6));
        System.out.println("AnyOverlap intervals: " + anyOverlap(input));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

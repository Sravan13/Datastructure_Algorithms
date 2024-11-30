package com.practice.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalOptimized {

    public static void main(String[] args) {

        int[][] intervals = {{1, 5}, {3, 7}, {9, 12}, {11, 18}};
        int[][] merged = mergeIntervals(intervals);

        // Print the result
        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }

    }

    public static int[][] mergeIntervals(int[][] intervals) {

        // sort with start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> mergeList = new ArrayList<>();

        int[] currentInterval = intervals[0];

        mergeList.add(currentInterval);

        for(int [] interval : intervals) {
            int currentEndTime = currentInterval[1];

            if(interval[0]<=currentEndTime){
                currentInterval[1] = Math.max(interval[1], currentEndTime);
            }else{
                currentInterval = interval;
                mergeList.add(currentInterval);
            }

        }

        return mergeList.toArray(new int[mergeList.size()][]);




    }
}

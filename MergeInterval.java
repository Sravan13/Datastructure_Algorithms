package com.practice.ds;

public class MergeInterval {
    public static void main(String[] args) {

        int[][] intervals = {{1, 5}, {3 ,7}, {6, 12}, {11, 18}};

        MergeInterval mergeInterval = new MergeInterval();
        mergeInterval.merge(intervals);

    }

    private void merge(int[][] intervals){
        for(int i=0;i<intervals.length-1;i++) {

            if(intervals[i][0] == -1 && intervals[i][0] == -1) continue;

            for(int j=i+1;j<intervals.length;j++){

                if(intervals[j][0] < intervals[i][1]){
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = intervals[j][1] = -1;
                }
            }

            System.out.println("["+intervals[i][0]+","+intervals[i][1]+"]");
        }
    }




}

package com.practice.ds;

public class FirstAndLastIndexOfNumberInSortedArray {

    public static void main(String[] args) {

        int [] arr = {1,4,10,10,10,12,14,16};
        findFirstAndLastIndexOfNumber(arr,1);

    }

    public static void  findFirstAndLastIndexOfNumber(int [] arr,int k) {

        System.out.println(" First index :: "+findFirstIndex(arr,Integer.MAX_VALUE, 0, arr.length-1, k));
        System.out.println(" Last index  :: "+findLastIndex(arr,Integer.MIN_VALUE, 0, arr.length-1, k));

    }

    private static int findFirstIndex(int[] arr, int idx, int low , int high, int k) {

        if(low > high) return idx == Integer.MAX_VALUE ? -1 : idx;

            int mid = high - (high-low)/2;

            if(arr[mid] < k) {
                return findFirstIndex(arr,idx,mid+1 ,high,k);
            }else {
                idx = arr[mid] == k ? mid: idx;
                return findFirstIndex(arr,idx,low ,mid-1,k);
            }
    }

    private static int findLastIndex(int[] arr, int idx, int low , int high, int k) {

        if(low > high) return idx == Integer.MIN_VALUE ? -1 : idx;

            int mid = high - (high-low)/2;

            if(arr[mid] > k) {
                return findLastIndex(arr,idx,low ,mid-1,k);
            }else {
                idx = arr[mid] == k ? mid: idx;
                return  findLastIndex(arr,idx,mid + 1 ,high,k);
            }
    }

}

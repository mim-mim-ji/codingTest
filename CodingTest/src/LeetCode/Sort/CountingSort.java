package LeetCode.Sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {5,4,5,5,1,1,3};

        int[] arr2 = {-5,-1,-3,5,4,8,10,1,1,3};
        countingSort2(arr2);
    }

    //최소값: 0(음수 X), 최대값: K 인 경우
    public static void countingSort(int [] arr){
        // Sorts an array of integers where minimum value is 0 and maximum value is K
        int K = Arrays.stream(arr).max().getAsInt();

        int [] counts = new int[K+1];
        for(int elem : arr){
            counts[elem] += 1;
        }
        System.out.println(Arrays.toString(counts));
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingIndex = 0;
        for(int i=0; i < K+1;i++){
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }
        System.out.println(Arrays.toString(counts));
        int sortedArray[] = new int[arr.length];
        for(int elem : arr){
            sortedArray[counts[elem]] = elem;
            // since we have placed an item in index counts[elem], we need to
            // increment counts[elem] index by 1 so the next duplicate element
            // is placed in appropriate index
            counts[elem] += 1;
        }
        // common practice to copy over sorted list into original arr
        // it's fine to just return the sortedArray at this point as well
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    //최소값이 음수일 경우
    public static void countingSort2(int [] arr){
        System.out.println(Arrays.toString(arr));
        // Sorts an array of integers (handles shifting of integers to range 0 to K)
        int shift = Arrays.stream(arr).min().getAsInt();
        int K = Arrays.stream(arr).max().getAsInt() - shift;
        int[]counts = new int[K+1];
        for(int elem: arr){
            counts[elem - shift] += 1;
        }
        System.out.println(Arrays.toString(counts));
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingindex = 0;
        for(int i=0;i < K+1 ; i++){
            int count = counts[i];
            counts[i] = startingindex;
            startingindex += count;
        }
        System.out.println(Arrays.toString(counts));

        int sortedArray[] = new int[arr.length];
        for(int elem : arr){
            sortedArray[counts[elem - shift]] = elem;
            counts[elem - shift] += 1;
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = sortedArray[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}

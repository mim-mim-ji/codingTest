package LeetCode.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        int [] arr = {23,25,21,12,19,17,5,7};
        bucketSort(arr,5);
    }

    public static void bucketSort(int [] arr, int K){
        List<List<Integer>> buckets = new ArrayList<>(K);
        int shift = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt() - shift;

        //place elements into buckets
        double bucketSize = (double) maxValue / K;
        if(bucketSize < 1){
            bucketSize = 1.0;
        }
        for(int elem : arr){
            //same as K * arr[i] / max(lst)
            int index = K * elem / maxValue;
            if(index == K){
                // put the max value in the last bucket
                buckets.get(K-1).add(elem);
            }else {
                buckets.get(index).add(elem);
            }
        }
        //sort buckets
        for(List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }
        //convert sorted buckets into final output
        List<Integer> sortedList = new ArrayList<>();
        for(List<Integer> bucket : buckets){
            sortedList.addAll(bucket);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedList.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }

}

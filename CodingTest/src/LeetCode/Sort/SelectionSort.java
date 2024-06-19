package LeetCode.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    /*
    - 추가적인 메모리 소비가 적음
    - 시간복잡도: O(N2)
    - 불안정 정렬

     */

    public static void main(String[] args) {
        int [] arr = {4,2,3,4,1};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectionSort(int[] arr){
        int min_idx;

        for(int i=0;i<arr.length;i++){
            min_idx = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap current index with minimum element in rest of list
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

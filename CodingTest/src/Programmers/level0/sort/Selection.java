package Programmers.level0.sort;

import java.util.Arrays;

public class Selection {
    //선택정렬_1427
    public static void main(String[] args) {
        int[]arr = {30,60,12,54,2,45};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            swap(arr,i,minIdx);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

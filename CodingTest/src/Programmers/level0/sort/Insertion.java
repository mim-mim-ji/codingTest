package Programmers.level0.sort;

import java.util.Arrays;

public class Insertion {
    //삽입정렬
    public static void main(String[] args) {
        int[]arr = {30,60,12,54,2,45};
        sort3(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for(int end=1;end<arr.length;end++){
            for(int i=end;i>0;i--){
                if(arr[i-1]>arr[i]){
                    swap(arr,i-1,i);
                }
            }
        }
    }

    private static void sort2(int[] arr) {
        for(int end=1;end<arr.length;end++){
            int i = end;
            while(i>0 && arr[i-1]>arr[i]){
               swap(arr,i-1,i);
               i--;
            }
        }
    }

    private static void sort3(int[] arr) {
        for(int end=1;end<arr.length;end++){
            int toInsert = arr[end];
            int i = end;
            while(i>0 && arr[i-1]>toInsert){
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = toInsert;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

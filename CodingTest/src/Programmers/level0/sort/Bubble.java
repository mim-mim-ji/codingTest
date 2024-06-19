package Programmers.level0.sort;

import java.util.Arrays;

public class Bubble {
    //버블정렬_2750
    public static void main(String[] args) {
        int[]arr = {30,60,12,54,2,45};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void sort2(int[] arr) {
        int end = arr.length-1;
        System.out.println(end);
        while (end >0){
            System.out.println(end);
            int last_swap = 0;
            for(int i=0;i<end;i++){
                System.out.println(Arrays.toString(arr));
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                    last_swap = i;
                }
            }
            end = last_swap;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

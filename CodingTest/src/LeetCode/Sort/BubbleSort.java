package LeetCode.Sort;

import java.util.Arrays;

public class BubbleSort {
    /*
        - 안정 정렬
        - 추가적인 메모리 소비가 적음
        - 시간 복잡도: O(N2)(swap flag 변수 사용시)

     */

    public static void main(String[] args) {
        int [] arr = {7,3,2,1,5,6,10,9,8};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int [] arr){
        // Mutates arr so that it is sorted via swapping adjacent elements until
        // the arr is sorted.
        boolean hasSwapped = true;
        while (hasSwapped){
            hasSwapped = false;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i] > arr[i+1]){
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }

    public static void bubbleSort2(int [] arr){
        // round는 배열 크기 - 1 만큼 진행됨
        for(int i=1; i < arr.length ; i++){
            boolean swapped = false;

            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for(int j=0; j < arr.length -i; j++){
                if(arr[j] > arr[j+1]){
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            /*
             * 만약 swap된적이 없다면 이미 정렬되었다는 의미이므로
             * 반복문을 종료한다.
             */
            if(swapped == false) {
                break;
            }
        }
    }
}

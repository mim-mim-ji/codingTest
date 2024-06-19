package LeetCode.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest {

    public static void main(String[] args) {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest(nums, k);
        findKthLargest2(nums, k);
    }

    public static int findKthLargest(int[] arr, int k) {
        // Mutates elements in lst by utilizing the heap data structure
        for(int i = arr.length / 2 -1; i>=0 ;i--){
            maxHeapify(arr, arr.length, i);
        }

        for(int i= arr.length - 1; i>0; i--){
            // swap last element with first element
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // note that we reduce the heap size by 1 every iteration
            maxHeapify(arr, i , 0);
        }

        System.out.println(Arrays.toString(arr));

        return arr[arr.length-k];
    }

    private static void maxHeapify(int[] arr, int heapSize, int index){
        int left = 2 * index + 1;
        int right = 2* index + 2;
        int largest = index;

        if(left < heapSize && arr[left] >= arr[largest]){
            largest = left;
        }
        if(right < heapSize && arr[right] >= arr[largest]){
            largest = right;
        }
        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, heapSize, largest);
        }
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i < k ;i++){ //size는 k만큼
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
                System.out.println(pq);
            }
        }

        return pq.peek();
    }
}

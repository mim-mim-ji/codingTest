package LeetCode.Sort;

import java.util.Arrays;

public class SortColors {

    //countingSort를 이용한 풀이
    //SelectionSort로도 풀이 가능함
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int K = Arrays.stream(nums).max().getAsInt();

        int [] counts = new int[K+1];
        for(int elem : nums){
            counts[elem] +=1;
        }
        System.out.println(Arrays.toString(counts));

        int startingIndex = 0;
        for(int i=0;i< K+1;i++){
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }
        System.out.println(Arrays.toString(counts));

        int [] sortedArray = new int[nums.length];
        for(int elem : nums){
            sortedArray[counts[elem]] = elem;
            counts[elem] += 1;
        }
        System.out.println(Arrays.toString(sortedArray));

        for(int i=0;i<nums.length;i++){
            nums[i]= sortedArray[i];
        }
    }
}

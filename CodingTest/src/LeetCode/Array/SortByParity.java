package LeetCode.Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortByParity {
    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
    Return any array that satisfies this condition.

    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

     */
    public static void main(String[] args) {
        int [] nums = {3,1,2,4};

        System.out.println(Arrays.toString(sortArrayByParity1(nums)));
        System.out.println(Arrays.toString(sortArrayByParity2(nums)));
        System.out.println(Arrays.toString(sortArrayByParity3(nums)));
    }

    //1. sort
    public static int[] sortArrayByParity1(int[] nums) {

        Integer[] B = new Integer[nums.length];
        for (int t = 0; t < nums.length; ++t)
            B[t] = nums[t];

        //오름차순정렬은 작은값에서 큰값빼기
        //a가 짝수면 a%2==0이므로 b보다 작음
        Arrays.sort(B, (a, b) -> a%2 - b%2);
        //또는 아래처럼 작성가능
        //Arrays.sort(B,(a,b) -> Integer.compare(a%2,b%2));

        for (int t = 0; t < nums.length; ++t)
            nums[t] = B[t];
        return nums;

    }

    //2. Two pass
    //Write all the even elements first, then write all the odd elements.
    public static int[] sortArrayByParity2(int[] nums) {
        int [] ans = new int [nums.length];
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ans[idx++] = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                ans[idx++] = nums[i];
            }
        }
        return ans;
    }

    //3. In-Place
    public static int[] sortArrayByParity3(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]%2 > nums[j]%2){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if(nums[i]%2==0) i++;
            if(nums[j]%2!=0) j--;
        }
        return nums;
    }

}

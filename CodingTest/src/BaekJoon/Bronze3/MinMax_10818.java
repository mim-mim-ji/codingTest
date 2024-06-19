package BaekJoon.Bronze3;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = 0;
        A = sc.nextInt();
        int [] nums = new int[A];
        for(int i=0;i<A;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        solution(A,nums);
    }
    public static void solution(int A, int[] nums){

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[A-1];

        System.out.println(min);
        System.out.println(max);
    }
}

package BaekJoon.Bronze3;

import java.util.Arrays;
import java.util.Scanner;

public class Max_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] nums = new int[9];
        for(int i=0;i<9;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        solution(nums);
    }

    public static void solution(int[] nums){

        int index = 1;
        int max = nums[0];

        for(int i=1;i<9;i++){
            if(max < nums[i]){
                max = nums[i];
                index = i+1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}

package BaekJoon.Silver2;

import java.util.Arrays;
import java.util.Scanner;

public class gcd_17087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int [] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(S,arr));

    }

    public static int solution(int S, int[] arr){
        int [] nums = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i] = Math.abs(arr[i]-S);
        }
        Arrays.sort(nums);
        int gcd = nums[0];
        for(int i=1;i<nums.length;i++){
            gcd = getGcd(gcd, nums[i]);
        }
        return gcd;
    }

    private static int getGcd(int a, int b) {
        if(a % b ==0){
            return b;
        }else{
            return getGcd(b, a%b);
        }
    }
}

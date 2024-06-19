package BaekJoon.Bronze2;

import java.util.Arrays;
import java.util.Scanner;

public class sort_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //(1 ≤ N ≤ 1,000)
        int [] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int a : arr){
            System.out.println(a);
        }
    }
}

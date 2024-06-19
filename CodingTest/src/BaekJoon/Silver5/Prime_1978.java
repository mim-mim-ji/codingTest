package BaekJoon.Silver5;

import java.util.Scanner;

public class Prime_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int answer = arr.length;

        for(int a : arr){
            if(a == 1) answer--;
            for(int i=2;i<=Math.sqrt(a);i++){
                if(a % i==0){  //소수가 아님
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}

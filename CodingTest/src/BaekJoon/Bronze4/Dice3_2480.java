package BaekJoon.Bronze4;

import java.util.Scanner;

public class Dice3_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = 0;
        int B = 0;
        int C = 0;

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        sc.close();

        solution(A,B,C);
    }
    public static void solution(int A, int B, int C) {
        /*
        같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
         */
        int answer = 0;

        if(A == B && B == C){
            answer = 10000 + A*1000;
        }else if(A == B){
            answer = 1000 + A*100;
        }else if(B == C) {
            answer = 1000 + B * 100;
        }else if(A == C){
                answer = 1000 + C*100;
        }else{
            answer = Math.max(A,Math.max(B,C))*100;
        }

        System.out.println(answer);
    }
}

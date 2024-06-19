package BaekJoon.Bronze3;

import java.util.Scanner;

public class Oven_2525 {
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
        int D = B + C;
        if(B + C >= 60){
            B = D % 60;
            A = A + (D / 60);
            if(A >= 24) A = Math.abs(24 - A);
        }else {
            B = D;
            A = A + (D / 60);
            if(A >= 24) A = Math.abs(24 - A);
        }

        System.out.println(A);
        System.out.println(B);
    }
}

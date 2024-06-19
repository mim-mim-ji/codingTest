package BaekJoon.Silver1;

import java.util.Scanner;

public class gcd_1850 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = 0;
        long B = 0;
        A = sc.nextLong();
        B = sc.nextLong();

        sc.close();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<getGcd(A,B);i++){
            sb.append(1);
        }
        System.out.println(sb);
    }
    public static long getGcd(long A, long B){
       if(A % B==0){
           return B;
       }else{
           return getGcd(B, A%B);
       }
    }
}

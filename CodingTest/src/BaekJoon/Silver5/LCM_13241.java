package BaekJoon.Silver5;

import java.util.Scanner;

public class LCM_13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = 0;
        long B = 0;
        A = sc.nextLong();
        B = sc.nextLong();

        sc.close();

        long gcd = getGcd(A,B);
        // A * B = gcd * LCM
        long LCM = A * B / gcd;
        System.out.println(LCM);
    }

    public static long getGcd(long A, long B){
        if(A % B==0){
            return B;
        }else{
            return getGcd(B, A%B);
        }
    }
}

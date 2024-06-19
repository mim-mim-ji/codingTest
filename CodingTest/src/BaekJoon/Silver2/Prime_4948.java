package BaekJoon.Silver2;

import java.io.*;

public class Prime_4948 {
    // n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N==0) break;

            int count = 0;
            for(int i=N+1;i<=2*N;i++){
                if(isPrime(i)) count++;
            }
            sb.append(count).append('\n'); //문자열로 이어준다
        }
        System.out.print(sb);
    }

    private static boolean isPrime(int N){
        for(int j=2;j<=Math.sqrt(N);j++) {
            if (N % j == 0) return false;
        }
        return true;
    }
}

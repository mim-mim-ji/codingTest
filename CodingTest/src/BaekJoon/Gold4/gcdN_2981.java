package BaekJoon.Gold4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class gcdN_2981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // (2 ≤ N ≤ 100)
        int [] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        sc.close(); //6 34 38

        //M으로 나눴을때 나머지가 모두 같게되는 M을 찾기
        int M1 = solution(N, arr);

        //최대공약수와 그의 약수들을 구하면 됨!!
        for (int i = 2; i <= M1; i++) {
            if (M1 % i == 0) System.out.println(i);
        }
    }

    //(A-B), (B-C), (C-D) 의 최대공약수를 구하기
    public static int solution(int N, int[] arr) {
        Arrays.sort(arr);
        int gcd = arr[1] - arr[0];

        for (int i = 2; i < N; i++) {
            // 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
            gcd = getGcd(gcd, arr[i] - arr[i - 1]);
        }
        return gcd;
    }

    public static int getGcd(int A, int B) {
        if (A % B == 0) {
            return B;
        } else {
            return getGcd(B, A % B);
        }
    }
}

package BaekJoon.Silver3;

import java.util.Scanner;

public class dp2_2579 {

    // [반복문(Bottom-Up) + Scanner]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int [] dp = new int[N+1];
        int [] arr = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        //index = 0은 시작점이므로 0이다.
        dp[1] = arr[1];

        //N이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
        if(N>=2){
            dp[2] = arr[1] + arr[2];
        }

        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}

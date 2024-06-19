package BaekJoon.Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class dp_2579 {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new Integer[N + 1];
        arr = new int[N+1];

        /*
        1. 계단을 오를 때 한 계단, 또는 두 계단을 오를 수 있다.
        2. 연속된 3개의 계단을 밟으면 안된다. (즉, 한 계단씩 올라갈 때 최대 연속으로 2번만 한계단씩 오를 수 있다는 의미다.)
        3. 마지막 계단은 '반드시' 밟아야 한다.

        i번째 칸을 밟기 직전 상황
        1칸 밟아 i번째 칸이 되는 경우: i-1
        2칸 밟아 i번째 칸이 되는 경우: i-2
        3칸 밟아 i번째 칸이 되는 경우: i-3

         */

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0]; //디폴트값이 null이므로 0으로 초기화 해줘야함
        dp[1] = arr[1];

        if(N>=2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(solution1(N));

    }

    //재귀(Top-Down) + Scanner
    private static int solution1(int N) {
        //아직 탐색하지 않은 N번째 계단일 경우
        if(dp[N] == null){
            dp[N] = Math.max(solution1(N-2), solution1(N-3) + arr[N-1]) + arr[N];
            System.out.println(Arrays.toString(dp));
        }
        return dp[N];
    }
}

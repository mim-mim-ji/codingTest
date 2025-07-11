package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리_6236 {

    /*
    현우는 용돈을 효율적으로 활용하기 위해 계획을 짜기로 하였다. 현우는 앞으로 N일 동안 자신이 사용할 금액을 계산하였고,
    돈을 펑펑 쓰지 않기 위해 정확히 M번만 통장에서 돈을 빼서 쓰기로 하였다.
    현우는 통장에서 K원을 인출하며, 통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용하고, 모자라게 되면 남은 금액은 통장에 집어넣고 다시 K원을 인출한다.
    다만 현우는 M이라는 숫자를 좋아하기 때문에, 정확히 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
    현우는 돈을 아끼기 위해 인출 금액 K를 최소화하기로 하였다. 현우가 필요한 최소 금액 K를 계산하는 프로그램을 작성하시오.
1번째 줄에는 N과 M이 공백으로 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ N)

2번째 줄부터 총 N개의 줄에는 현우가 i번째 날에 이용할 금액이 주어진다. (1 ≤ 금액 ≤ 10000)
7 5
100   500인출 -> 400
400   400 -> 0
300   500인출 -> 200
100   200 -> 100
500   100 입금 -> 500인출 -> 0
101   500인출 -> 399
400   399입금 -> 500인출 -> 100
첫 번째 줄에 현우가 통장에서 인출해야 할 최소 금액 K를 출력한다.
->500
     */
    static int N, M;
    static int[] spend;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int maxSpend = 0;
            int totalSpend = 0;

            spend = new int[N];
            for (int i = 0; i < N; i++) {
                spend[i] = Integer.parseInt(br.readLine());
                maxSpend = Math.max(maxSpend, spend[i]);
                totalSpend += spend[i];
            }

            int left = maxSpend;
            int right = totalSpend;
            int result = totalSpend;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canWithdraw(mid)) {
                    result = mid;
                    right = mid - 1;  // 더 작은 K가 있을 수 있으니 왼쪽 탐색
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean canWithdraw(int K) {
        int count = 1;
        int current = K;
        for (int i = 0; i < N; i++) {
            if (spend[i] > K) //하루동안 써야하는 돈보다 인출금액이 적으면 false
                return false;
            if (current < spend[i]) { //현재 가진 돈이 쓸 돈보다 적으면 인출
                count++;
                current = K;
            }
            current -= spend[i];
        }
        return count <= M;
    }

}

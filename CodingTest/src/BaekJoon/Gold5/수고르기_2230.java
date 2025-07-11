package BaekJoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {

    /*
    N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다),
    그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.
    예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다.
    이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.
첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.
첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.
1 ≤ N ≤ 100,000
0 ≤ M ≤ 2,000,000,000
0 ≤ |A[i]| ≤ 1,000,000,000
3 3
1
5
3
-> 4
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            int start = 0;
            int end = 0;
            int result = Integer.MAX_VALUE;
            while (end < N && start < N) {
                int diff = Math.abs(arr[end] - arr[start]);
                if (diff >= M) {
                    result = Math.min(result, diff);
                    start++;
                } else {
                    end++;
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

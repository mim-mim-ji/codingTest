package BaekJoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {

    /*
    10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
    첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다
    첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
10 15
5 1 3 5 10 7 4 9 2 8
-> 2
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //누적합
            int[] prefixSum = new int[N + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= N; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            }

            //구간별 합 구하기
            int start = 0;
            int end = 0;
            int result = Integer.MAX_VALUE;
            while (end <= N) {
                int sum = prefixSum[end] - prefixSum[start];
                if (sum >= S) {
                    result = Math.min(result, end - start);
                    start++;
                } else {
                    end++;
                }

            }
            System.out.println(result == Integer.MAX_VALUE ? 0 : result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

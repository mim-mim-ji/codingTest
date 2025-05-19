package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GenericQueries_16713 {
    /*
    구간합
   0 1 2 3 4  5
   0 1 3 6 10 15
   a[3] = 3까지의 누적합 = 6
   a[5] = 5까지의 누적합 = 15

   구간 3,5의 값은 = 3부터 5까지 더한값 = 구간합 5에서 구간합 2를 뺀것 = 15 - 3 =12
     */

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];
            int[] prefixXor = new int[N + 1]; //누적 xor

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefixXor[i] = prefixXor[i - 1] ^ arr[i];
            }

            int result = 0;
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                int xor = prefixXor[right] ^ prefixXor[left - 1];
                result ^= xor;
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}

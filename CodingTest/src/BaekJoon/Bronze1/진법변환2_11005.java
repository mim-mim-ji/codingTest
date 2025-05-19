package BaekJoon.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환2_11005 {

    /*
    10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

 ex) 60466175 36 -> ZZZZZ

     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            while (N > 0) {
                int r = N % B;

                if (r < 10) {
                    sb.append((char)('0' + r)); // 0~9 → '0' ~ '9'
                } else {
                    sb.append((char)('A' + (r - 10))); // 10~35 → 'A' ~ 'Z'
                }
                N = N / B;
            }
            System.out.println(sb.reverse());
        }
    }

}

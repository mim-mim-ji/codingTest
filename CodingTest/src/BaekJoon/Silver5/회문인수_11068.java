package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문인수_11068 {

    /*
    어떤 수를 왼쪽부터 읽어도, 오른쪽부터 읽어도 같을 때 이 수를 회문인 수라고 한다.
    예를 들어, 747은 회문인 수이다. 255도 회문인 수인데, 16진수로 표현하면 FF이기 때문이다.
    양의 정수를 입력받았을 때, 이 수가 어떤 B진법 (2 ≤ B ≤ 64)으로 표현하면 회문이 되는 경우가 있는지 알려주는 프로그램을 작성하시오.
    B진법이란, 한 자리에서 수를 표현할 때 쓸 수 있는 수의 가짓수가 B라는 뜻이다. 예를 들어, 십진법에서 B는 10이다.

어떤 B진법 (2 ≤ B ≤ 64)으로 표현하여 회문이 될 수 있다면 1을, 그렇지 않다면 0을 출력한다.
3
747
255
946734
->
1
1
0
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                boolean answer = false;
                for (int j = 2; j <= 64; j++) {
                    if (isPalindrome(changeRadix(N, j))) {
                        answer = true;
                        break;
                    }
                }
                System.out.println(answer ? 1 : 0);
            }
        }
    }

    public static String changeRadix(int N, int K) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            if (N % K < 10) {
                sb.append(N % K);
            } else {
                sb.append((char)('A' + (N % K - 10)));
            }
            N = N / K;
        }
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

package BaekJoon.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 짝수를찾아라_3058 {

    /*
    7개의 자연수가 주어질 때, 이들 중 짝수인 자연수들을 모두 골라 그 합을 구하고, 고른 짝수들 중 최솟값을 찾는 프로그램을 작성하시오.

    예를 들어, 7개의 자연수 13, 78, 39, 42, 54, 93, 86가 주어지면 이들 중 짝수는 78, 42, 54, 86이므로 그 합은 78 + 42 + 54 + 86 = 260 이 되고, 42 < 54 < 78 < 86 이므로 짝수들 중 최솟값은 42가 된다.

각 테스트 데이터에 대해, 7개 자연수 중 짝수의 합과 최솟값을 공백으로 구분하여 한 줄에 하나씩 출력한다.

2
1 2 3 4 5 6 7
13 78 39 42 54 93 86
->12 2
260 42
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = 0;
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < 7; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp % 2 == 0) {
                        sum += temp;
                        min = Math.min(min, temp);
                    }
                }
                System.out.println(sum + " " + min);

            }
        }
    }

}

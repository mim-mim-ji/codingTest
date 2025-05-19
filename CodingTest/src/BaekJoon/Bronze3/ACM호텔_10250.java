package BaekJoon.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔_10250 {

    /*
    프로그램은 표준 입력에서 입력 데이터를 받는다. 프로그램의 입력은 T 개의 테스트 데이터로 이루어져 있는데 T 는 입력의 맨 첫 줄에 주어진다.
    각 테스트 데이터는 한 행으로서 H, W, N, 세 정수를 포함하고 있으며 각각 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지를 나타낸다(1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W).
내용은 N 번째 손님에게 배정되어야 하는 방 번호를 출력한다
2
6 12 10
30 50 72
=> 402
1203

1 [6][1]  7 [6][2] 102    13[6][3]
2 [5][1]  8 [5][2] 202
3 [4][1]  9 [4][2] 302
4 [3][1]  10[3][2] 402
5 [2][1]  11[4][2] 502
6 [1][1]  12[5][2] 602

10/6 = 1
10%6 = 4

12/6=2
12%6=0
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());

                int floor = (N % H == 0) ? H : N % H;
                int room = (N % H == 0) ? N / H : N / H + 1;

                String answer = String.format("%d%02d", floor, room);
                System.out.println(answer);
            }

        }
    }

}

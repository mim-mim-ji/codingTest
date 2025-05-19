package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개똥벌레_3020 {

    /*
    개똥벌레 한 마리가 장애물(석순과 종유석)로 가득찬 동굴에 들어갔다.
    동굴의 길이는 N미터이고, 높이는 H미터이다. (N은 짝수) 첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장한다.
아래 그림은 길이가 14미터이고 높이가 5미터인 동굴이다. (예제 그림)
위의 그림에서 4번째 구간으로 개똥벌레가 날아간다면 파괴해야하는 장애물의 수는 총 여덟개이다. (4번째 구간은 길이가 3인 석순과 길이가 4인 석순의 중간지점을 말한다)
하지만, 첫 번째 구간이나 다섯 번째 구간으로 날아간다면 개똥벌레는 장애물 일곱개만 파괴하면 된다.
동굴의 크기와 높이, 모든 장애물의 크기가 주어진다. 이때, 개똥벌레가 파괴해야하는 장애물의 최솟값과 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오
첫째 줄에 N과 H가 주어진다. N은 항상 짝수이다. (2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000)
다음 N개 줄에는 장애물의 크기가 순서대로 주어진다. 장애물의 크기는 H보다 작은 양수이다.
6 7
1
5
3
3
5
1
->첫째 줄에 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그러한 구간의 수를 공백으로 구분하여 출력한다.
2 3
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            int[] bottom = new int[H + 1];
            int[] top = new int[H + 1];

            for (int i = 0; i < N; i++) {
                int len = Integer.parseInt(br.readLine());
                if (i % 2 == 0) {
                    bottom[len]++; //길이가 len인 석순 등장
                } else {
                    top[H - len + 1]++;
                }
            }

            // bottom :  0 1 0 1 0 1
            // top:      0 1 0 1 0 1

            // bottom[i]는 높이 i 이상에서 개똥벌레가 만나는 석순 수
            for (int i = H - 1; i >= 1; i--) {
                bottom[i] += bottom[i + 1];
                top[i] += top[i + 1];
            }

            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 1; i <= H; i++) {
                int crush = bottom[i] + top[H - i + 1];
                if (crush < min) {
                    min = crush;
                    count = 1;
                } else if (crush == min) {
                    count++;
                }
            }

            System.out.println(min + " " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

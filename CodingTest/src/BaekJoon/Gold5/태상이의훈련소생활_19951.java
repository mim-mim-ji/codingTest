package BaekJoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태상이의훈련소생활_19951 {

    /*
연병장은 일렬로 이어진 N개의 칸으로 이루어져 있으며 각 칸마다 높이를 가지고 있고, 첫 번째 칸부터 순서대로 1번, 2번, 3번, ..., N번 칸으로 명칭이 붙어있다.
조교들은 총 M명이 있으며, 각 조교들은 태상이에게 a번 칸부터 b번 칸까지 높이 k만큼 흙을 덮거나 파내라고 지시한다. 흙은 주변 산에서 얼마든지 구할 수 있으므로 절대로 부족하지 않다.

태상이는 각 조교의 지시를 각각 수행하면, 다른 조교의 지시로 흙을 덮어둔 칸을 다시 파내기도 하는 비효율적인 일이 발생하는 것을 깨달았다.
그래서 태상이는 각 조교의 지시를 모아 연병장 각 칸의 최종 높이를 미리 구해 한 번에 일을 수행하려고 한다.

불쌍한 태상이를 위해 조교들의 지시를 모두 수행한 뒤 연병장 각 칸의 높이를 구하자.

첫 줄에 연병장의 크기 N과 조교의 수 M
둘째 줄에 연병장 각 칸의 높이 Hi가 순서대로 N개 주어진다.

셋째 줄부터 M개의 줄에 각 조교의 지시가 주어진다.

각 조교의 지시는 세 개의 정수 a, b, k로 이루어져 있다.

k ≥ 0인 경우 a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 늘어나도록 흙을 덮어야 한다.
k < 0인 경우 a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 줄어들도록 흙을 파내야 한다.

10 3
1 2 3 4 5 -1 -2 -3 -4 -5
1 5 -3
6 10 5
2 7 2
모든 지시를 수행한 뒤 연병장 각 칸의 높이를 공백을 사이에 두고 출력한다.
-2 1 2 3 4 6 5 2 1 0
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] origin = new int[N];
            for (int i = 0; i < N; i++) {
                origin[i] = Integer.parseInt(st.nextToken());
            }

            int[] diff = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int k = Integer.parseInt(st.nextToken());

                diff[a] += k;
                diff[b + 1] -= k; //b+1부터는 차이를 멈춤
            }

            // diff의 누적합 더하기
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += diff[i];
                origin[i] += sum;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int s : origin) {
                stringBuilder.append(s).append(" ");
            }

            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

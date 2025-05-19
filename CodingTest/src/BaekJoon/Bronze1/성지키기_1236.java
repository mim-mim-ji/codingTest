package BaekJoon.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기_1236 {

    /*
    모든 행과 모든 열에 한 명 이상의 경비원
5 8
....XXXX
........
XX.X.XX.
........
........
-> 3

3 5
XX...   for문 돌면서 1행부터 탐색 -> map[0][0] [1][0] [2][0]
.XX..
...XX
-> 0
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int emptyRow = 0;
            for (int i = 0; i < N; i++) {
                boolean hasGuard = false;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'X') {
                        hasGuard = true;
                        break;
                    }
                }
                if (!hasGuard)
                    emptyRow++;
            }

            int emptyCol = 0;
            for (int i = 0; i < M; i++) {
                boolean hasGuard = false;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 'X') {
                        hasGuard = true;
                        break;
                    }
                }
                if (!hasGuard)
                    emptyCol++;
            }

            System.out.println(Math.max(emptyRow, emptyCol));

        }

    }

}

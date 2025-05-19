package BaekJoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
바둑판의 각 칸은 주위의 영향을 받는데, 주위란 <그림2>에서 색칠한 영역과 같이 현재 칸을 중심으로 둔 한 변의 길이가 (2K + 1) 인 정사각형에서 현재 칸을 제외한 영역을 말한다.

바둑판의 각 칸은 주위에 몇 개의 생명이 존재하는지에 따라 다음 상황이 아래와 같이 결정된다.

생존 : 만약 현재 칸에 생명이 있고, 주위에 a개 이상 b개 이하의 생명이 있다면 현재 칸의 생명은 다음 단계에 살아남는다.
고독 : 만약 현재 칸에 생명이 있고, 주위에 a개 미만의 생명이 있다면 현재 칸의 생명은 외로워서 죽는다.
과밀 : 만약 현재 칸에 생명이 있고, 주위에 b개 초과의 생명이 있다면 현재 칸의 생명은 과밀로 죽는다.
탄생 : 만약 현재 칸에 생명이 없고, 주위에 a개 초과 b개 이하의 생명이 있다면 다음 단계에서 현재 칸에 생명이 생긴다.
생명은 바둑판을 벗어난 영역에서는 생존할 수 없다.
준표는 N×M 크기의 바둑판에 생명을 뿌리고, T시간 뒤의 생명을 관찰하고자 한다.

첫줄에는 바둑판의 세로길이, 가로길이를 나타내는 두 정수 N과 M, 준표가 바둑판을 관찰하고자 하는 시간 T가 주어진다.
두번째 줄에는 주위의 기준이 되는 정수 K, 각 칸의 다음 상황을 결정하는 정수 a, b가 주어진다.
다음 N개의 줄에 걸쳐 바둑판의 처음 상태가 주어진다. 각 줄은 길이 M의 문자열로 생명이 있는 칸은 '*', 빈칸은 '.'로 주어진다.
6 6 7
1 2 3
.*....
..*...
***...
......
......
......
=> 바둑판 6 x 6
=> 정사각형: 3 x 3 (k=1)
=> a= 2, b= 3

N개의 줄에 걸쳐 바둑판의 상태를 출력한다. 각 줄은 길이 M의 문자열로 생명이 있는 칸은 '*', 빈칸은 '.'로 출력한다.
......
......
..*...
...**.
..**..
......
 */
public class 생명게임_17232 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N + 1][M + 1];

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                String s = br.readLine();
                for (int j = 1; j <= M; j++) {
                    char temp = s.charAt(j - 1);
                    if (temp == '*') {
                        arr[i][j] = 1;
                    }
                }
            }

            while (T-- > 0) {
                int[][] next = new int[N + 1][M + 1];

                //누적합 배열 계산
                int[][] prefix = prefixSum(arr, N, M);

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        int x1 = Math.max(1, i - K);
                        int y1 = Math.max(1, j - K);
                        int x2 = Math.min(N, i + K);
                        int y2 = Math.min(M, j + K);

                        //주위: (x1, y1) 부터 (x2, y2) 까지 영역의 합 - 자기자신
                        int surround = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1] - arr[i][j];

                        //생존규칙 적용
                        if (arr[i][j] == 1) {
                            next[i][j] = (surround >= a && surround <= b) ? 1 : 0;
                        } else if (arr[i][j] == 0) {
                            next[i][j] = (surround > a && surround <= b) ? 1 : 0;
                        }
                    }
                }
                arr = next;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int temp = arr[i][j];
                    if (temp == 0) {
                        stringBuilder.append('.');
                    } else {
                        stringBuilder.append('*');
                    }
                }
                stringBuilder.append('\n');
            }
            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] prefixSum(int[][] arr, int N, int M) {
        int[][] prefix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + arr[i][j];
            }
        }
        return prefix;
    }

}

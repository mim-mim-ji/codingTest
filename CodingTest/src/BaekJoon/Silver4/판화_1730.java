package BaekJoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 판화_1730 {

    /*
    첫째 줄에 목판의 크기 N (2 ≤ N ≤ 10)이 주어진다. 행 열의 점들이 찍혀 있다는 의미이다.
    둘째 줄에 로봇팔의 움직임이 한 줄로 공백 없이 입력된다. 위쪽으로 이동은 'U', 아래쪽으로 이동은 'D', 왼쪽으로 이동은 'L', 오른쪽으로 이동은 'R'로 표시된다.
    로봇팔의 움직임을 나타내는 이 문자열의 길이는 최대 250이다.

    로봇팔이 지나지 않은 점은 '.'으로, 로봇팔이 수직 방향으로만 지난 점은 '|'으로, 로봇팔이 수평 방향으로만 지난 점은 '-'으로,
    수직과 수평 방향 모두로 지난 점은 '+'로 표기하도록 한다. 네 문자의 ASCII 코드는 각각 46, 124, 45, 43이다.

5
DRDRRUU

|..|.
++.|.
.+-+.
.....
.....
     */
    static int N;
    static int[] dx = {-1, 1, 0, 0}; //U, D, L, R
    static int[] dy = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            char[] move = br.readLine().toCharArray();
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(grid[i], '.');
            }
            solution(move, grid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(char[] move, char[][] grid) {
        int x = 0;
        int y = 0;
        for (char c : move) {
            int d = getDirection(c);
            if (d == -1)
                continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (c == 'U' || c == 'D') { //세로 이동
                grid[x][y] = (grid[x][y] == '-') ? '+' : (grid[x][y] == '+' ? '+' : '|');
                grid[nx][ny] = (grid[nx][ny] == '-') ? '+' : (grid[nx][ny] == '+' ? '+' : '|');
            } else {
                grid[x][y] = (grid[x][y] == '|') ? '+' : (grid[x][y] == '+' ? '+' : '-');
                grid[nx][ny] = (grid[nx][ny] == '|') ? '+' : (grid[nx][ny] == '+' ? '+' : '-');
            }
            x = nx;
            y = ny;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(new String(grid[i]));
        }
    }

    private static int getDirection(char c) {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == c)
                return i;
        }
        return -1;
    }

}

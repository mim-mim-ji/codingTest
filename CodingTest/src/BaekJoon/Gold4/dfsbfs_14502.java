package BaekJoon.Gold4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfsbfs_14502 {

    static int N; //세로
    static int M; //가로

    static int[][] map;
    static int[][] copy_map;

    static int result = Integer.MIN_VALUE; //안전지역 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        copy_map = new int[N][M];

        //지도입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //지도카피
        copy_map = map.clone();

        //벽세우면서 바이러스 뿌리기 시작
        dfs(0);

        System.out.println(result);

    }

    //벽세우기
    private static void dfs(int depth) {
        //벽 3개를 다 세웠으면 바이러스 뿌려
        if (depth == 3) {
            bfs();
            return;
        }

        //벽 3개 못 세웠으면 다시 세워
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { //빈칸이라면
                    map[i][j] = 1; //벽세우기
                    dfs(depth + 1);
                    map[i][j] = 0; //다시돌려놓기
                }
            }
        }
    }

    //상하좌우 이동할 수 있는 좌표
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    private static void bfs() {
        int[][] virus_map = new int[N][M];
        Queue<Virus> queue = new LinkedList<>();

        //virus_map 카피
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_map[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //바이러스면 큐에 넣기
                if (virus_map[i][j] == 2) {
                    queue.add(new Virus(i, j));

                    while (!queue.isEmpty()) {
                        Virus v = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = v.x + dx[d];
                            int ny = v.y + dy[d];

                            //범위 밖이면 무시
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                                continue;

                            //빈칸이면 바이러스 퍼뜨리기
                            if (virus_map[nx][ny] == 0) {
                                virus_map[nx][ny] = 2;
                                queue.add(new Virus(nx, ny));
                            }
                        }
                    }
                }
            }
        }

        safe(virus_map);

    }

    private static void safe(int[][] virus_map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0)
                    count++;
            }
        }
        result = Math.max(count, result);
    }

    static class Virus {

        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}

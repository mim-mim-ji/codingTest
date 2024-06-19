package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_1012 {

    static int N; //세로
    static int M; //가로
    static int K; //배추가 심어져 있는 위치의 개수

    static int[][] map;
    static boolean[][] visited;
    static int count; //지렁이 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int z = 0; z < K; z++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //방문하지않았고 배추가 있으면
                    if (!visited[j][k] && map[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,1,-1};
    static int nx, ny;
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx <0 || ny <0 || nx >= N || ny >= M) continue;

            //방문하지않았고 배추가 있는 곳만 방문 가능
            if(!visited[nx][ny] && map[nx][ny]==1){
                dfs(nx,ny);
            }
        }

    }
}

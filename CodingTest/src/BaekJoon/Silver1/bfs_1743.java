package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_1743 {
    static int N; //세로
    static int M; //가로
    static int K; //음식물 쓰레기 개수
    static int[][] map;
    static boolean[][] visited;
    static int count, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }

        //bfs로 탐색
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                cnt = 1;
                if(!visited[i][j] && map[i][j]==1){
                    bfs(i,j);
                    count = Math.max(cnt,count);
                }
            }
        }
        System.out.println(count);
    }
    static int nx, ny;
    static int[] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (! queue.isEmpty()){
            int xx = queue.poll();
            int yy = queue.poll();

            for(int i=0;i<4;i++){
                nx = xx + dx[i];
                ny = yy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny]==1){
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
    }
}

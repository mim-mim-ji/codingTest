package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_1743 {
    //음식물피하기

    static int N; //세로
    static int M; //가로
    static int K; //음식물 쓰레기 개수
    static int[][] map;
    static boolean[][] visited;
    static int count, temp ,cnt;
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

        //dfs로 탐색
       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               if(!visited[i][j] && map[i][j]==1){ //쓰레기의 위치탐색
                   temp = 0;
                   dfs(i,j); //dfs를 통해 쓰레기의 크기를 구해줌
                   count = Math.max(count,temp); //둘 중 큰 값이 정답
               }
           }
       }

       System.out.println(count);

    }

    static int nx, ny;
    static int[] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    private static void dfs(int x, int y) {
        temp++;
        visited[x][y] = true;

       for(int i=0;i<4;i++){
           nx = x + dx[i];
           ny = y + dy[i];

           if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

           if(!visited[nx][ny] && map[nx][ny]==1){
               dfs(nx,ny);
           }
       }
    }
}

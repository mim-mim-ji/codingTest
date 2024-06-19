package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_4963 {
    //한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형
    //너비 w와 높이 h
    //둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
    //입력의 마지막 줄에는 0이 두 개 주어진다.

    static int w,h;
    static int [][]map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = " ";

        while (! (str = br.readLine()).equals("0 0") ){
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken()); //가로
            h = Integer.parseInt(st.nextToken()); //세로

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        count++;
                        dfs(map, i, j);
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    //대각선
    // 0 0  0 1  0 2
    //      1 1
    // 2 0  2 1  2 2
    static int [] dx = {-1,1,0,0,-1,-1,1,1};
    static int [] dy = {0,0,-1,1,-1,1,-1,1};
    static int nx,ny;
    private static void dfs(int[][] map, int x, int y) {
        visited[x][y] = true;

        //8개의 방향탐색하므로 8번 반복해야함!!
        for(int i=0;i<8;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

            if(! visited[nx][ny] && map[nx][ny] ==1){
                dfs(map, nx,ny);
            }
        }
    }
}

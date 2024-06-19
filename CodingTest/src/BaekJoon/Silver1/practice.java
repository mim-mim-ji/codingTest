package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice {
    static int w;
    static int h;
    static boolean visited[][];
    static int map[][];
    static int count;

    /*
    5 4
    1 0 1 0 0
    1 0 0 0 0
    1 0 1 0 1
    1 0 0 1 0
     */

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); // 너비
        h = Integer.parseInt(st.nextToken()); // 세로

        map = new int[h][w];

        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[h][w];
        count = 0;

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(! visited[i][j] && map[i][j]==1){
                    dfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    static int dx[] = {0,0,-1,1,1,1,-1,-1};
    static int dy[] = {1,-1,0,0,1,-1,1,-1};
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

            if(! visited[nx][ny] && map[nx][ny]==1){
                dfs(nx,ny);
            }

        }
    }



}

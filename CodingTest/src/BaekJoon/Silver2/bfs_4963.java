package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_4963 {
    static int w,h;
    static int [][] map;
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
                        bfs(i, j);
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);

    }

    static int [] dx = {-1,1,0,0,-1,-1,1,1};
    static int [] dy = {0,0,-1,1,-1,1,-1,1};
    static int nx,ny;
    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(x);
        queue.offer(y);

        while (! queue.isEmpty()){
            int tempx = queue.poll();
            int tempy = queue.poll();

            for(int i=0;i<8;i++){
                nx = tempx + dx[i];
                ny = tempy + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

                if(!visited[nx][ny] && map[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.offer(nx);
                    queue.offer(ny);
                }
            }
        }

    }
}

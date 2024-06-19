package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_1012 {
    /*
가로 세로
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
     */
    static int N; //세로
    static int M; //가로
    static int K; //배추가 심어져 있는 위치 개수

    static int [][] map;
    static boolean [][] visited;
    static int count; //지렁이 개수

    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = 8;
        M = 10;
        K = 17;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[N][M];
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        visited = new boolean[N][M];
        count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(! visited[i][j] && map[i][j] ==1 ){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);

    }

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,1,-1};
    static int nx, ny;
    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y] = true;

        while (! queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if(nx <0 || ny <0 || nx >= N || ny >= M) continue;

                if(! visited[nx][ny] && map[nx][ny]==1){
                    queue.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }

}

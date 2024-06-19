package BaekJoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_7576 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static int count = 0;
    static int answer = 0;

    static class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        map = new int [N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){ //익은토마토
                    bfs(i,j);
                }
            }
        }
        int max = Integer.MIN_VALUE;

        //map을 다 만든 후에도 안익은토마토가 있으면 -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, map[i][j]);
            }
        }
        //그렇지 않다면 최대값을 출력한다.
        System.out.println(max -1);
    }

    static int nx, ny;
    static int[] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void bfs(int x, int y) {
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) { //안익은토마토
                    queue.offer(new Node(nx, ny));
                    //최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
                    map[nx][ny] = map[node.x][node.y] + 1;
                }
            }
        }
    }
}

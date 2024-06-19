package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs_2468 {
    static int N; //행렬크기
    static int [][] map;
    static boolean [][] visited;
    static List<Integer> list = new ArrayList<>(); //전체 높이를 중복없이 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(! list.contains(map[i][j])){ //높이 저장
                    list.add(map[i][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int num : list){
            visited = new boolean[N][N];
            int safeArea = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(! visited[i][j] && map[i][j] >= num){
                        bfs(i,j,num);
                        safeArea++;
                    }
                }
            }
            max = Math.max(safeArea,max);
        }
        System.out.println(max);
    }

    static int nx, ny;
    static int[] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    private static void bfs(int x, int y, int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(x); queue.add(y);

        while(! queue.isEmpty()){
            int tempx = queue.poll();
            int tempy = queue.poll();
            for(int i=0;i<4;i++){
                nx = tempx + dx[i];
                ny = tempy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(! visited[nx][ny] && map[nx][ny] >= num) {
                    queue.add(nx); queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

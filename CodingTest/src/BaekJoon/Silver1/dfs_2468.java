package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dfs_2468 {

    static int N; //행렬크기
    static int [][] map;
    static boolean [][] visited;
    static List<Integer> list = new ArrayList<>();

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
            int safeArea = 0;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(! visited[i][j] && map[i][j] >= num){
                        dfs(i,j,num);
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
    private static void dfs(int x, int y, int num) {
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(! visited[nx][ny] && map[nx][ny] >= num) {
                dfs(nx, ny, num);
            }
        }
    }
}

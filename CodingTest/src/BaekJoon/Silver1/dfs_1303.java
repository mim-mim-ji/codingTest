package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_1303 {

    static int N;
    static int M;
    static boolean visited[][];
    static char [][] map;
    static int white_count = 0;
    static int blue_count = 0;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 새로

        //방문체크할 배열
        visited = new boolean[M][N];

        //1. 색 저장할 map 만들기
        map = new char[M][N];
        for(int i=0;i<M;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
            }
        }

        //2. dfs로 탐색
        for(int i=0;i<M;i++){ //세로
            for(int j=0;j<N;j++){ //가로
                if(! visited[i][j]){
                    char color = map[i][j];
                    count = 1; //1*1 = 1
                    dfs(i,j,color);

                    if(color == 'W'){
                        white_count += count * count;
                    }else {
                        blue_count += count * count;
                    }
                }
            }
        }
        System.out.println(white_count + " " + blue_count);
    }

    //상하좌우 이동할 수 있는 좌표
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    //새로운 x,y
    static int nx;
    static int ny;
    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            //현재좌표가 maps에서 벗어날 경우 다음 반복으로 넘어감
            if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                continue;
            }

            //아직 방문하지 않았고 색도 같을때
            if(visited[nx][ny] == false && color == map[nx][ny]){
                dfs(nx,ny,map[nx][ny]);
                count++;
            }
        }
    }
}

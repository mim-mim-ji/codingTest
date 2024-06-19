package BaekJoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_1303 {
    /*
    N명이 뭉쳐있을 때는 N제곱의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가?
    당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷
    단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
    첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다.
    그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다.
    모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.

    5 5 (가로 x 세로)
    WBWWW
    WWWWW
    BBBBB
    BBBWW
    WWWWW
     */

    static int N; //가로
    static int M; //세로
    static boolean visited[][];
    static char map[][];
    static int white_cnt = 0;
    static int blue_cnt = 0;

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        //방문여부를 체크할 배열
        visited = new boolean[M][N];

        //흰색과 파란색을 넣을 배열
        map = new char[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            for(int j=0;j<N;j++){
                char ch = temp.charAt(j);
                map[i][j] = ch;
            }
        }

        //bfs로 2차원 배열 순환
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                //false -> 방문한 적이 없는 곳일 경우
                if(! visited[i][j]){
                    if(map[i][j] == 'W'){
                        int num = bfs(i,j,'W');
                        white_cnt += num * num;
                    }else{
                        int num = bfs(i,j,'B');
                        blue_cnt += num * num;
                    }
                }
            }
        }
        System.out.println(white_cnt + " " + blue_cnt);
    }

    static int count;
    //상하좌우 이동할 수 있는 좌표
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    private static int bfs(int x, int y, char ch) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        count = 1;
        visited[x][y] = true;

        //queue가 빌때까지 계속
        while(! queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                //현재좌표가 maps에서 벗어날 경우 다음 반복으로 넘어감
                if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                    continue;
                }

                //아직 방문하지 않았고 색도 같을때
                if(visited[nx][ny] == false && ch == map[nx][ny]){
                    queue.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                    count++;
                }

            }
        }
        return count;
    }


}

package Programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Gamemap_bfs {
    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        // answer = 11
        // 벽:0, 갈수있는 길:1
        System.out.println(solution(maps));
    }

    static int [][] visited;
    // 상하좌우 이동할 수 있는 좌표
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length][maps[0].length];

        bfs(maps,visited);

        //도달해야하는 좌표
        answer = visited[maps.length-1][maps[0].length-1];

        System.out.println(Arrays.deepToString(visited));

        if(answer == 0){ //목표 좌표 도달X
            answer = -1;
        }
        return answer;
    }

    //최단거리 탐색이므로 bfs사용해야함
    private static void bfs(int[][] maps, int [][] visited) {
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0,0}); //queue에 시작 정점 추가
        visited[0][0] = 1; //시작노드 방문했다고 체크

        while (! queue.isEmpty()){
            for(int [] q : queue){
                System.out.println(Arrays.toString(q));
            }
            int [] current = queue.poll(); //정점 하나 꺼내기
            int x = current[0];
            int y = current[1];

            //상하좌우 이동경우 모두 탐색
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //현재좌표가 maps에서 벗어날 경우 다음 반복으로 넘어감
                if(nx < 0 || ny < 0 || nx > maps.length-1 || ny > maps[0].length-1){
                    continue;
                }

                //아직방문하지 않았고 벽이 아닐경우
                if(visited[nx][ny] ==0 && maps[nx][ny] ==1){
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}

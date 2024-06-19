package Programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_거리두기확인하기 {
    public static void main(String[] args) {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places))); //[1, 0, 1, 1, 1]
    }

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int [places.length];

        for(int i=0;i<places.length;i++){
            String [] place = places[i];
            boolean check = true;

            for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(place[r].charAt(c)=='P'){
                        check = bfs(place, r, c);
                    }
                    //check가 false면 바로 0넣고 break
                    if(! check){
                        answer[i] = 0;
                        break;
                    }
                }
            }
            if(check) answer[i] = 1;
        }

        return answer;
    }

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    private static boolean bfs(String[] place, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        boolean [][] visited = new boolean[place.length][place.length];
        queue.offer(new Node(x,y));
        visited[x][y] = true;

        while (! queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int manhatan = Math.abs(x - nx) + Math.abs(y - ny);

                //범위아웃인거 건너뛰기
                if(nx < 0 || ny < 0 || nx >= place.length || ny >= place.length) continue;
                //이미 방문한곳 또는 맨해튼거리가 2가 넘는것 건너뛰기
                if(visited[nx][ny] || manhatan > 2) continue;

                //이미 방문X 중 파티션은 건너뛰기
                if(place[nx].charAt(ny)=='X') continue;
                //사람이 있는 경우는 false
                else if(place[nx].charAt(ny)=='P') return false;
                //책상이 있는 곳만 큐에 넣고 돌리기
                else queue.offer(new Node(nx,ny));
                //방문표시
                visited[nx][ny] = true;
            }
        }

        return true;
    }

}

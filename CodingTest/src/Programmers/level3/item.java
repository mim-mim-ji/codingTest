package Programmers.level3;

import java.util.*;

public class item {
    /*
    지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle,
    초기 캐릭터의 위치 characterX, characterY,
    아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때,
    캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.

    제한사항
    rectangle의 세로(행) 길이는 1 이상 4 이하입니다.
    rectangle의 원소는 각 직사각형의 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] 좌표 형태입니다.
    직사각형을 나타내는 모든 좌표값은 1 이상 50 이하인 자연수입니다.
    서로 다른 두 직사각형의 x축 좌표, 혹은 y축 좌표가 같은 경우는 없습니다.
    문제에 주어진 조건에 맞는 직사각형만 입력으로 주어집니다.
    charcterX, charcterY는 1 이상 50 이하인 자연수입니다.
    지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.
    itemX, itemY는 1 이상 50 이하인 자연수입니다.
    지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.
    캐릭터와 아이템의 처음 위치가 같은 경우는 없습니다.
     */
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(solution(rectangle,characterX,characterY,itemX,itemY)); //17
    }

    static int[][]map;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int answer;
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;

        //1) map을 만든다.
        map = new int[101][101];

        //2) 좌표에 따라 map에 값을 넣을건데, 테두리에만 1을 넣을것이다.(*좌표는 두배로)
         for(int i=0;i<rectangle.length;i++){
             fill(2*rectangle[i][0],2*rectangle[i][1],2*rectangle[i][2],2*rectangle[i][3]);
         }

        //3) bfs로 테두리 따라 양쪽으로 가보고 min값 채택
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);

        return answer/2;
    }

    private static void bfs(int startX, int startY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);

        while(! queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0; i<4; i++){
                int nx= x+dx[i];
                int ny= y+dy[i];

                if(nx<0||ny<0||nx>100||ny>100) continue; //범위 아웃

                if(map[nx][ny]!=1||visited[nx][ny]) continue; //테두리인데 방문함

                //가능한 경우 : map[nx][ny]==2이고 방문한적 없음
                map[nx][ny]=map[x][y]+1;
                if(nx==itemX && ny==itemY){ //목표점 도달
                    answer= map[nx][ny];
                    //answer= (answer==0)? map[nx][ny]:Math.min(answer,map[nx][ny]);
                    continue;
                }
                visited[nx][ny]= true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    //x1,y1,x2,y2 => (x1,y1)~(x2,y1), (x1,y2)~(x2,y2), (x1,y1)~(x1,y2), (x2,y1)~(x2,y2)
    //편하게 두 배 해준 좌표를 받는다.
    // 테두리에는 1을 넣어주고, 내부에는 2를 넣어줌
    private static void fill(int x1, int y1, int x2, int y2) {
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(map[i][j] == 2) continue;
                map[i][j] = 2;
                if(i==x1 || i==x2 || j==y1 || j==y2){
                    map[i][j] = 1;
                }
            }
        }
    }
}

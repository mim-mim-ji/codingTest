package Programmers.level0;

import java.util.Arrays;

public class CharacterKeyBorad {
    //[0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1], down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다.
    //[0,0]은 board의 정중앙에 위치합니다. 예를 들어 board의 가로크기가 9라면 캐릭터는 최대 [-4,0]까지 오른쪽으로 최대 [4,0]까지 이동할 수 있다.
    public static void main(String[] args) {
        String[] keyinput = {"left", "right", "up", "right", "right"};
        int[] board = {11,11};
        System.out.println(Arrays.toString(solution(keyinput,board)));
    }

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;
        int xmax = board[0]/2;
        int ymax = board[1]/2;

        for(String key : keyinput) {
            if (key.equals("up")) y++;
            else if (key.equals("down")) y--;
            else if (key.equals("left")) x--;
            else x++;

            if(Math.abs(x) > xmax) x = x > 0 ? xmax : -xmax;
            if(Math.abs(y) > ymax) y = y > 0 ? ymax : -ymax;
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}

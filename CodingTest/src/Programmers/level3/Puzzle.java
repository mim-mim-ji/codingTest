package Programmers.level3;

public class Puzzle {
    /*
    3 ≤ game_board의 행 길이 ≤ 50
    game_board의 각 열 길이 = game_board의 행 길이
    즉, 게임 보드는 정사각 격자 모양입니다.
    game_board의 모든 원소는 0 또는 1입니다.
    0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
    퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
    table의 행 길이 = game_board의 행 길이
    table의 각 열 길이 = table의 행 길이
    즉, 테이블은 game_board와 같은 크기의 정사각 격자 모양입니다.
    table의 모든 원소는 0 또는 1입니다.
    0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
    퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
    game_board에는 반드시 하나 이상의 빈칸이 있습니다.
    table에는 반드시 하나 이상의 블록이 놓여 있습니다.

    조각은 한 번에 하나씩 채워 넣습니다.
    조각을 회전시킬 수 있습니다.
    조각을 뒤집을 수는 없습니다.
    게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
     */
    public static void main(String[] args) {

        int [][]game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board,table)); //14
    }
    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;



        return answer;
    }
}

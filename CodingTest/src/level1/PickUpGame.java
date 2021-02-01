package level1;

import java.util.*;

public class PickUpGame {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, //만일 moves가 2면   0,1  1,1  2,1  3,1  4,1
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}};

		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves)); //4
	}

	//Stack이용하는 문제!!
//	public Element push(Element item); // Stack에 객체 추가
//	public Element pop(); // 맨 위에 저장된 객체를 꺼냄
//	public Element peek(); // 맨 위에 저장된 객체 조회
//	public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
//	public int search(Object o); // 인자값으로 받은 객체의 위치 반환, 못 찾으면 -1 반환

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<Integer>();	

		for(int move : moves) { 
			int moveIndex = move -1;
			for(int i=0;i<board.length;i++) {	
				int k = board[i][moveIndex];
				if(k ==0) {
					continue;
				}
				if(! stack.empty() && stack.peek()==k) {	
					stack.pop();
					answer++;
				} else {
					stack.push(k);
				}
				board[i][moveIndex] = 0;
				break;
			}			
		}

		return answer*2;
	}

}

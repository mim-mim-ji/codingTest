package Programmers.level2;

import java.util.*;

public class Rotation {

	public static void main(String[] args) {
		int rows =6;
		int columns=6;
		int[][]queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

		System.out.println(Arrays.toString(solution(rows, columns, queries)));
		//{8, 10, 25}
	}

	static int[][]matrix;
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		matrix = new int[rows][columns];

		//행렬 초기화
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				matrix[i][j] = i*columns+j+1;
			}
		}

		for(int i=0;i<queries.length;i++) {
			answer[i] = rotate(queries[i]);
		}

		return answer; 
	}

	public static int rotate(int[] query) {
		int x1 = query[0]-1; 
		int y1 = query[1]-1; 
		int x2 = query[2]-1; 
		int y2 = query[3]-1; 

		int temp = matrix[x1][y1]; 
		int min = temp; //시작위치 값 임시저장

		//왼쪽
		for(int i=x1;i<x2;i++) {
			matrix[i][y1] = matrix[i+1][y1];
			if(min > matrix[i][y1]) min = matrix[i][y1];			
		}

		//오른쪽
		for(int i = x2; i > x1; i--){
			matrix[i][y2] = matrix[i-1][y2];
			if(min > matrix[i][y2]) min = matrix[i][y2];
		}

		//위쪽
		for(int i = y2; i > y1; i--){ 
			matrix[x1][i] = matrix[x1][i-1];
			if(min > matrix[x1][i]) min = matrix[x1][i];
		}

		//아래쪽
		for(int i=y1;i<y2;i++) {
			matrix[x2][i] = matrix[x2][i+1];
			if(min > matrix[x2][i+1]) min =  matrix[x2][i];
		}
		
		matrix[x1][y1+1] = temp; // 임시저장한 값 저장

		return min;

	}

}

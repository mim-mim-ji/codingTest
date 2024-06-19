package Programmers.level1;

import java.util.Arrays;

public class __Test3 {

	public static void main(String[] args) {

		int[][]v={{1, 4}, {3, 4}, {3, 10}};
		System.out.println(Arrays.toString(solution(v))); 
	}


	public static int[] solution(int[][] v) {
		int[] answer = new int[2];

		for(int i=0;i<answer.length;i++){
		     if(v[0][i]==v[1][i]){
		        answer[i] = v[2][i];
		    }else if(v[0][i]==v[2][i]){
		        answer[i] = v[1][i];
		    }else if(v[1][i]==v[2][i]){
		        answer[i] = v[0][i];
		    }
		}
		return answer;
	}

}

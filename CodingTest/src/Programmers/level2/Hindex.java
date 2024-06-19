package Programmers.level2;

import java.util.Arrays;

public class Hindex {

	/*
	 * 어떤 과학자가 발표한 논문 n편 중, 
	 * h번 이상 인용된 논문이 h편 이상이고 
	 * 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
	 */

	public static void main(String[] args) {
		int [] citations = {0,1,3,5,6};
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations); //0,1,3,5,6
		
		for(int i=0;i<citations.length;i++) {
			if(citations[i]>=citations.length-i) { //i는 인덱스
				answer = citations.length-i;
				break;
			}
		}		
		
		return answer;
	}
	
	public static int solution2(int[] citations){
		 Arrays.sort(citations);

	        int max = 0;
	        for(int i = citations.length-1; i > -1; i--){
	            int min = (int)Math.min(citations[i], citations.length - i);
	            System.out.println(min);
	            if(max < min) max = min;
	            System.out.println(max);
	        }

	        return max;
	}
	
}


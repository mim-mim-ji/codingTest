package Programmers.level2;

import java.util.*;

public class RangeMaximum {

	public static void main(String[] args) {
		int [] numbers = {6,2,1,0};
		System.out.println(solution(numbers)); //6210
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
				
		//int배열을string 배열로 변환
		String[] result = new String[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			result[i] = String.valueOf(numbers[i]);
		}
		
		//배열 정렬, 정렬규칙 : 2개를 더해서 더 큰 쪽이 우선순위가 있도록
		Arrays.sort(result, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {				
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		//0으로만 구성되어있으면 0 return
		if(result[0].equals("0")) return "0";
		
		//배열을 순차적으로 더해서 answer에 넣어줌
		for(String s : result) {
			answer += s;
		}
		
		return answer;
	}
	
}

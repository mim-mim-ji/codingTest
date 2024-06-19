package Programmers.level1;

import java.util.*;

//모의고사
public class ArrayReturn {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(answers)));
	}
	
	public static int[] solution(int[] answers) {
		
		int[] person1 = {1, 2, 3, 4, 5};
		int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		/*
		 * 각각의 배열은 계속 반복됨
		 * answers 배열 내용과 각각의 배열을 비교
		 * 각각의 학생이 맞힌 문제 수를 리턴
		 * 가장 문제를 많이 맞춘 학생을 배열에 담아 리턴
		 */
		
		int a=0; int b=0; int c=0;
		for(int i =0; i<answers.length; i++){
            if(person1[i%person1.length] == answers[i]) a++; //0 1 2 3 4 
            if(person2[i%person2.length] == answers[i]) b++; 
            if(person3[i%person3.length] == answers[i]) c++;
        }
	
    	//a,b,c중 가장 큰 수 구하기
    	int max = Math.max(Math.max(a, b), c);
		
    	if(max==a) list.add(1);
    	if(max==b) list.add(2);
    	if(max==c) list.add(3);
    	
    	int[] answer = new int[list.size()];
    	for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
				
		return answer;
	}
}

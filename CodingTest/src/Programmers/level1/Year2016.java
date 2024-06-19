package Programmers.level1;

public class Year2016 {

	/*
	 * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 
	 * 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
	 * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
	 */

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		System.out.println(solution(a,b)); 
	}

	public static String solution(int a, int b) {

		String [] day = {"FRI","SAT","SUN","MON","TUE","WED","THU",};
		int[] dayCnt = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		String answer = "";
		
		int diff = 0;
		for(int i=0;i<a-1;i++) {
			diff += dayCnt[i]; 
		}
		diff += b-1;
		//System.out.println(diff);
		
		answer = day[diff%7]; 
					
		return answer;

	}
}

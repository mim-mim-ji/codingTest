package Programmers.level1;

/* 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
 * 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 */

public class StringBasic {
	public static void main(String[] args) {

		String s1 = "a234";
		String s2 = "1234";

		System.out.println(solution2(s1));
		System.out.println(solution2(s2));
	}


	public static boolean solution(String s) {
		boolean answer = true; 

		char[] arr = s.toCharArray();
 
		for(int i=0;i<s.length();i++) {
			if(arr.length ==4 || arr.length ==6) {				
				if(arr[i] >= 65 && arr[i] <=90) {
					answer = false;
				}else if(arr[i] >=97 && arr[i] <= 122) {
					answer = false;
				}
			}else {
				answer = false;
			} 

		}

		return answer;
	}
	
	// NumberFormatException 사용하는 방법도 있음!!!
	public static boolean solution2(String s) {
		if(s.length()==4 || s.length() == 6) {
			try {
				int x = Integer.parseInt(s);
				return true;
			} catch(NumberFormatException e){
				return false;
			}
		} else return false;
	}

}

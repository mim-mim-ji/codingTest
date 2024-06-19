package Programmers.level1;

public class AZ {

	public static void main(String[] args) {

		String s = "abcz";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		int answer = 0;

		char[] ch = s.toCharArray();
		String temp = "";
		for(char c : ch) {
			if(c=='a' || c=='z') {
				temp += c;
			}			
		}
		System.out.println(temp);
		answer = temp.length()-1;
		
		return answer;
	}

}


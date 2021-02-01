package level1;

import java.util.Arrays;

//서울에서 김서방 찾기
public class KimSeobang {

	public static void main(String[] args) {
		String[] seoul= {"Jane", "Kim"};
		System.out.println(solution(seoul)); //김서방은 1에 있다 
		System.out.println(solution2(seoul));
		System.out.println(solution3(seoul));
	}

	public static String solution(String[] seoul) {

		int index =0;
		for(int i=0;i<seoul.length;i++) {       	
			if(seoul[i].equals("Kim")) {
				index = i;
				break;
			}
		}

		String answer = "김서방은 "+index+"에 있다";

		return answer;
	}

	public static String solution2(String[] seoul) {

		int index =0;

		for(String string : seoul) {
			if(string.equals("Kim")) {
				break;
			}
			index++;
		}
		String answer = "김서방은 "+index+"에 있다";

		return answer;

	}
	
	public static String solution3(String[] seoul) {
	
		int index = Arrays.asList(seoul).indexOf("Kim");
		
		String answer = "김서방은 "+index+"에 있다";

		return answer;
		
	}


}

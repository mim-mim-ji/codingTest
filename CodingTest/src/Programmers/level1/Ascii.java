package Programmers.level1;

public class Ascii {
	public static void main(String[] args) {
		String s = "Y";
        String s2 = "z";
        String s3 = "a B z";

        System.out.println(solution(s, 2));
        System.out.println(solution(s2, 1));
        System.out.println(solution(s3, 4));

        char a = 'a'; //아스키코드 97
        System.out.println(a+10); //97+10
	}
	
	static String solution(String s, int n) {
				
		String answer = "";
		
		char[] arr = s.toCharArray(); //character 배열로 반환
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] ==' ') { //공백
				continue;
			}
				
			//대문자(65~90)(A~Z)
			if(arr[i] >= 65 && arr[i] <=90) { //범위안에 있으면
				arr[i] += n;			
				if(arr[i] > 90) { 
					arr[i] -= 26; //Z를 넘은 경우 1만큼 밀리면 A로 돌아가야하기 때문에 -26
				} 
			}

			//소문자(97~122)
			if(arr[i] >= 97 && arr[i] <= 122) {
				arr[i] += n;
				if(arr[i] > 122) {
					arr[i] -= 26;
				}
			}
		}			

		answer = String.valueOf(arr); 
		return answer;
	}
		
}

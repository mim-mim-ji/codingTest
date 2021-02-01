package level1;

public class StringToInteger {
	public static void main(String[] args) {
		String str = "-1234";
		System.out.println(solution(str));
	}
	
	public static int solution(String s) {
        int answer = 0;
        
        answer = Integer.parseInt(s);
        return answer;
    }  
	
}

package Programmers.level1;


//수박수박수박수.....?
public class RoutineString {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(n));
		
	}
	
	public static String solution(int n) {
        String answer = "";
        
        String[] arr = {"수", "박"};
     
        int j=0;
    	for(int i=0; i < n ; i++) { 
    		j = i % arr.length; //0%2=0 1%2=1 2%2=0 3%2=1 => 0,1,0,1반복
    		answer += arr[j]; 
    	}
        
        return answer;
    }

}

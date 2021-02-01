package level1;

public class OrderSum {

	public static void main(String[] args) {
		int a1 = 3; int b1 = 3;
		int a2 = 3; int b2 = 5;
		int a3 = 5; int b3 = 3;

		System.out.println(solution(a1,b1));
		System.out.println(solution(a2,b2));
		System.out.println(solution(a3,b3));
	}
	
	public static long solution(int a, int b) {
		 long answer = 0;
		 
		 if(a==b) {
			 answer = a;
		 }else {
			 if(a<b) {
				 for(int i=a;i<=b;i++) {
					 answer += i;
				 }
			 } else {
				 for(int i=b;i<=a;i++) {
					 answer += i;
				 }
			 } 
			 
		 }
			 
		 
	     return answer;
	}

}

package Programmers.level1;

public class mod1mod2 {

	
	/* 1부터 max_range까지의 수 중에서
	 * mod1으로는 나누어 떨어지지만 mod2로는 안 나누어떨어지는 수의 개수를 구하시오
	 * 
	 * 쉽지만 효율성이 중요한 문제
	 */
	
	public static void main(String[] args) {
		int mod1=3;
		int mod2=4;
		int max = 20;
		System.out.println(solution(mod1,mod2,max));
	}

	public static int solution(int mod1, int mod2, int max_range) {
		int answer = max_range/mod1; // 20/4 = 5 -> 4의 배수는 5개

		int temp = 1;
		for(int i=1;i<=answer;i++){           
			temp = i*mod1;  //temp = 4,8,12,16,20
			System.out.println(temp);
			if(temp%mod2==0)
				answer--;
		}
		return answer;
	}
	
	
	//for문이 1부터 max_range까지 돌기 때문에 효율성이 떨어짐
	public int solution2(int mod1, int mod2, int max_range) {
        int answer = max_range/mod1;

       for(int i=1;i<=max_range;i++){           
          if(i%mod1==0 && i%mod2==0){
              answer--;
          }
        }
        return answer;
    }
	
	//가장 기본적으로 생각할 수 있는 풀이지만 효율성이 떨어짐
	public int solution3(int mod1, int mod2, int max_range) {
       int answer = 0;

       for(int i=1;i<=max_range;i++){           
          if(i%mod1==0){
        	  if(i%mod2!=0) {
        		  answer++;
        	  }            
          }
        }
        return answer;
    }

}

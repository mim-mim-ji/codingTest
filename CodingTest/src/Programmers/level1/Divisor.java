package Programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisor {

	public static void main(String[] args) {
		int n=30;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				list.add(i);
				if(i*i<n) list.add(n/i);
			}
		}
		Collections.sort(list);
		System.out.println(list);
	}
	
	public int solution(int left, int right) {
		int answer = 0;
		
		for(int i=left;i<=right;i++) {
			int temp = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) temp++;
			}
			answer += (temp%2==0) ? i : -i;
		}
		return answer;
	}
	
	public int solution1(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            int temp = 1; //자기자신 포함
            for(int j=1;j<=i/2;j++){
                if(i%j==0){
                    temp++;
                }
            }
            answer += (temp%2==0) ? i : -i;
        }
    
        return answer;
    }
	
    public int solution3(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
           int temp = 0; 
           for(int j=1;j<=Math.sqrt(i);j++) {
			    if(i%j==0) {
				    temp++;
				    if(j*j<i) temp++;
			    }
		    }
            answer += (temp%2==0) ? i : -i;
        }
    
        return answer;
    
    }
	
	public int solution4(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
	

}

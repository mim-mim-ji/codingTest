package Programmers.level1;

import java.util.*;

public class Uniform {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println(solution(n,lost,reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;

		Map<Integer,Integer> map = new HashMap<>();     

		for(int i=1;i<=5;i++) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		System.out.println(map);
		for(int re:reserve) {
			map.put(re,map.get(re)+1);
		}

		System.out.println(map);

		for(int minus:lost){
			map.put(minus,map.get(minus)-1); 

			if(minus<n) {
				if(map.get(minus+1)==2){
					map.put(minus,map.get(minus)+1);
					map.put(minus+1,map.get(minus+1)-1);
				}
			}           
		}

		System.out.println(map);


		for(int key:map.keySet()){
			if(map.get(key)==0) answer--;
		}

		return answer;
	}

	public static int solution2(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        return answer;
	}
	
	public static int solution3(int n, int[] lost, int[] reserve) {
		
		int answer = n-lost.length;
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int re : reserve) {
			set.add(re);
		}
		
		//여벌 체육복을 도난 당한 경우
		for(int i=0;i<lost.length;i++) {
			if(set.contains(lost[i])) {
				answer++;
				set.remove(lost[i]);
				lost[i] = -1;
			}			
		}
		
		System.out.println(set);
		
		for(int i=0;i<lost.length;i++) {
			if(set.contains(lost[i]-1)) {
				answer++;
				set.remove(lost[i]-1);
			}else if(set.contains(lost[i]+1)) {
				answer++;
				set.remove(lost[i]+1);
			}
		}
		
		System.out.println(set);
		
		return answer;
		
	}

}

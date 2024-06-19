package Programmers.level1;

import java.util.*;

public class Marathon {

	public static void main(String[] args) {
		String[] participant = {"mislav", "bb", "mislav", "ana"};
		String [] completion = {"bb", "ana", "mislav"};
		System.out.println(solution(participant,completion));
		System.out.println(solution2(participant,completion));
	}
	
	
	 public static String solution(String[] participant, String[] completion) {
	        Arrays.sort(participant);  // ana bb mislav mislav 
	        Arrays.sort(completion);   // ana bb mislav 
	        int i;
	        for ( i=0; i<completion.length; i++){
	            if (!participant[i].equals(completion[i])){
	                return participant[i]; //return으로 메서드종료, 반복문 탈출
	            }
	        }
	        
	        return participant[i]; //만일 마지막이 정답일 경우 리턴할 값(i++이므로 가능)
	    }
	 
	 public static String solution2(String[] participant, String[] completion) {
		 String answer = "";
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 
		 for(String par : participant) {
			 hm.put(par, hm.getOrDefault(par, 0)+1); 		 
		 }
		 System.out.println(hm); //{ana=1, mislav=2, stanko=1}
		
		 for(String com : completion) {
			 hm.put(com, hm.get(com)-1); 
		 }
		 System.out.println(hm); //{ana=0, mislav=1, stanko=0}
		 
		 for(String key : hm.keySet()) { 
			 if(hm.get(key) != 0) {				 
				 answer = key;
				 break;
			 }
		 }
		 
		 return answer;
	 
	 }	 
}

package level1;

import java.util.*;

public class Marathon {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String [] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution2(participant,completion));
	}
	
	
	 public static String solution(String[] participant, String[] completion) {
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        int i;
	        for ( i=0; i<completion.length; i++){

	            if (!participant[i].equals(completion[i])){
	                return participant[i];
	            }
	        }
	        return participant[i];
	    }
	 
	 public static String solution2(String[] participant, String[] completion) {
		 String answer = "";
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 
		 for(String player : participant) {
			 hm.put(player, hm.getOrDefault(player, 0)+1);
		 }
		 for(String player : completion) {
			 hm.put(player, hm.get(player)-1);
		 }
		 
		 for(String key : hm.keySet()) {
			 if(hm.get(key) != 0) {
				 answer = key;
				 break;
			 }
		 }
		 
		 return answer;
	 
	 }
	 
}

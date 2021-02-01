package level1;

import java.util.*;

public class StringOrder {
	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		System.out.println(Arrays.toString(solution(strings,1)));  //"car", "bed", "sun"
	}

	public static String[] solution(String[] strings, int n) {
		
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				char c1 = o1.charAt(n);  
				char c2 = o2.charAt(n);
							
				if(c1 > c2) {
					return 1;
				} else if(c1 == c2) { //n번째 문자가 같을 경우에 원본 스트링을 사전순으로
					return o1.compareTo(o2);
				} else return -1;
				
				/*
				  if(c1 == c2){
                  	 return s1.compareTo(s2);
              	  }  else return c1 - c2;
				 */
			}
		});
		
		return strings;
		
	}
}

package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MusicFound {

	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00","12:14","HELLO","CDEFGAB", 
								"13:00","13:05","WORLD","ABCDEF"};
		
		System.out.println(solution(m,musicinfos));

	}
	
	public static int getMin(String startTime,String endTime) {
		String[] arr;
		arr = startTime.split(":"); 
		int startMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
		
		arr = endTime.split(":");
		int endMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);

		return Math.abs(endMin - startMin); //절대값반환함수로 입력된 두 시간이 몇분차이나는지 리턴

	}
	
	public static String replaceSharp(String m) {
		return m.replace("C#", "c")
				.replace("D#", "d")
				.replace("E#", "E")
				.replace("F#", "f")
				.replace("G#", "g")				
				.replace("A#", "A");		
	}
	
	public static String solution(String m, String[] musicinfos) {
        
		//#이 붙어있는 것들은 소문자로 변경
		m = replaceSharp(m);		
		int playMin = 0;
		
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> matchMusic = new ArrayList<String>();		

        for(String str : musicinfos) { 
        	
	    	arr.add(str);
        	playMin = getMin(arr.get(0), arr.get(1)); //실제 재생 분
        	
        	String orgPlay = arr.get(3); //원곡의 음표 
        	orgPlay = replaceSharp(orgPlay); //# 제거 -> 소문자로 변경
        	
        	//실제 재생된 음표를 구함
        	int j=0;
        	String realPlay = "";
        	for(int i=0; i < playMin ; i++) { //playMin = 14
        		j = i % orgPlay.length();  //CDEFGAB -> 7, j=0~6 
        		realPlay += orgPlay.charAt(j); //realPlay = CDEFGABCDEFGAB
        	}
 

        	if(realPlay.contains(m)) { //CDEFGABCDEFGAB 안에 CDEFGAB가 포함되어있다면
        		matchMusic.add(str);   //리스트에 str을 추가
        	}

        }	        
	        
	    //조건에 맞는 음악이 여러개인 경우 재생시간이 긴 곡, 재생시간도 같다면 먼저 입력된 곡
        Collections.sort(matchMusic, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] arr = o1.split(",");
				int len1 = getMin(arr[0], arr[1]);
				int len2 = getMin(arr[0], arr[1]);				
				return len2 - len1;
			}     	
		});
        

		String answer = "(None)";
        if(matchMusic.size() > 0) {
        	answer = matchMusic.get(2);
        }
        return answer;
    }

}


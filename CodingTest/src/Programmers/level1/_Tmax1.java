package Programmers.level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class _Tmax1 {

	
	
	public static void main(String[] args) throws ParseException {
		String logs="2019/05/01 00:59:19\n"
				+ "2019/06/01 00:35:20\n"
				+ "2019/08/01 17:01:22\n"
				+ "2019/09/01 18:22:24";
		System.out.println(solution(logs));
	}
	
	public static int[] solution(String logs) throws ParseException {
		int [] answer = new int[25];
		
		String[] logTime = logs.split("\n");
		
		for(String log:logTime) {
				
			Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(log);
			System.out.println(date);
			String newString = new SimpleDateFormat("HH:mm").format(date);
			System.out.println(newString);
			int theTime = Integer.parseInt(newString.split(":")[0])+9;
			
			if(theTime>24) {
				theTime -= 24;
			}
			
			for(int h=0;h<25;h++) {
				if(h-theTime==0) {
					answer[h]++;
				}
			}
			
			System.out.println(theTime);
		}
		
				
		System.out.println(Arrays.toString(answer));		
		return answer;
	}

}

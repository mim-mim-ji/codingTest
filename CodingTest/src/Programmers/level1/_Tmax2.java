package Programmers.level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _Tmax2 {

	public static void main(String[] args) throws ParseException {
		String logs="2019/05/01 00:59:19\n"
				+ "2019/06/01 00:35:20\n"
				+ "2019/08/01 17:01:22\n"
				+ "2019/09/01 18:22:24";
		System.out.println(solution(logs));
	}
	
	public static int[] solution(String logs) throws ParseException {
		int[] answer= {};
		
		String[] logTime = logs.split("\n");
		for(String log:logTime) {
			
			String pattern = "yyyy/MM/dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat =
					new SimpleDateFormat(pattern);
			
			Date date = simpleDateFormat.parse(log);
			String newString = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
			System.out.println(date);
			System.out.println(newString);
		}
	
		return answer;
	}

}

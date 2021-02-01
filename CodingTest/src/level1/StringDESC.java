package level1;

import java.util.Arrays;

//문자열내림차순으로 정렬
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
public class StringDESC {

	public static void main(String[] args) {

		String s = "Zbcdefg";	
		System.out.println(solution(s)); //gfedcbZ
		
		String s1 = "Zbcdefg";	
		System.out.println(reverseStr(s1)); //gfedcbZ
	}
	
	 public static String solution(String s) {
		 String answer = "";
		 
		 char[] arr = s.toCharArray();
		 
		 char temp;

		 for(int i=1;i<arr.length;i++) {  // 1<=i<7까지 반복 => 아래 for문을 6번 반복
			 for(int j=0;j<arr.length-i;j++) {  // 0<=j<6 => 5,4,3,2,1,0 => s의 크기-1만큼 반복 : 맨앞의 숫자랑 비교해서 뒤로 보냄
				 if(arr[j] <= arr[j+1]) {
					 temp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = temp;
				 }
			 }
		 }
	 
		 answer = String.valueOf(arr);

		 return answer;
	 }
	 
	 //다른 풀이
	 public static String reverseStr(String s) {
		 char[] sol = s.toCharArray();
		 Arrays.sort(sol); // 배열 오름차순 정렬
		 
		 //StringBuilder(String str) -> 정렬한 sol을 String타입으로 바꿔서 넣어주기
		 StringBuilder sb = new StringBuilder(new String(sol));
		 
		 //String타입으로 리턴해야하므로 toString()메서드를 사용
		 return sb.reverse().toString();
	 }
	

}

package Programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumber {

	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers)); //3

	}

	public static int solution(String numbers) {
		int answer = 0;
		
		String[] st = numbers.split("");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		
		System.out.println(map);

		return answer;
	}

}

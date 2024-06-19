package Programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(String num : phone_book) {
			hm.put(num, 0);
		}

		System.out.println(hm.keySet());
		for(String num : hm.keySet()) {
			for(int i=1;i<=num.length()-1;i++) {
				if(hm.containsKey(num.substring(0,i))) {

					System.out.println(num.substring(0,i));
					return false;
				}
			}		
		}

		return true;
		//정확성: 83.3
		//효율성: 16.7
	}

	public static boolean solution2(String[] phone_book) {
		Arrays.sort(phone_book);
		System.out.println(Arrays.toString(phone_book));
		for (int i=0; i<phone_book.length-1; i++) { 
			if (phone_book[i+1].startsWith(phone_book[i])) { 
				return false;
			}
			System.out.println(i);
		}
		return true;
		//정확성: 83.3
		//효율성: 16.7
	}

}

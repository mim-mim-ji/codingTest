package Programmers.level1;

import java.util.*;

public class Ponketmon {

	public static void main(String[] args) {

		int []nums= {3,1,2,3};
		System.out.println(solution3(nums));
		
	}

	public static int solution(int[] nums) {
		int answer = nums.length/2;

		List<Integer>list = new ArrayList<>();        
		int current = 0;

		Arrays.sort(nums);

		//중복되지 않는 수만 추가
		for(int num:nums){
			if(num != current){
				list.add(num);
			}
			current = num;
		}

		System.out.println(list);

		//리스트의 크기가 더 작으면 answer는 리스트 크기
		if(list.size() < answer){
			answer = list.size();
		}

		return answer;

	}
	
	public static int solution2(int []nums) {
		int answer = nums.length/2;
		//set은 중복허용X
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int num:nums) {
			set.add(num);
		}
		
		System.out.println(set);
		
		if(set.size() < nums.length/2) {
			answer = set.size();
		}
	
		return answer;
		
	}
	public static int solution3(int []nums) {
		int answer = nums.length / 2;

		List<Integer> list = new ArrayList<>();

		for(int num : nums){
			if(! list.contains(num)) list.add(num);
		}

		if(answer > list.size()) answer = list.size();

		return answer;
	}
}

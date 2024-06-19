package Programmers.level1;

import java.util.*;

public class Lotto_Winnums {

	public static void main(String[] args) {
		int[] lottos = {8, 7, 0, 4, 5, 6};
		int[] win_nums = {7, 8, 9, 10, 11, 12};
		int[] answer = solution(lottos,win_nums);
		int[] answer2 = solution2(lottos,win_nums);
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(answer2));
		//[3, 5]
	}

	public static int[] solution(int[] lottos, int[] win_nums) {

		ArrayList<Integer> list = new ArrayList<>();

		int min = 0;//0을 제외하고 맞힌 개수
		int max = 0; //0 포함 맞힌 개수

		for(int i=0;i<lottos.length;i++) {
			list.add(win_nums[i]);
			int index = 6;
			for(int lotto:lottos) {
				if(list.contains(lotto)) {
					index = list.indexOf(lotto);
					list.remove(index);
					min++;
				}
			}
		}	

		System.out.println(list); // 못 맞힌 로또 리스트

		max = min;
		for(int lotto : lottos) {			
			if(lotto ==0) {
				max++;
			}			
		}

		System.out.println(min);
		System.out.println(max);		

		//등수 구하기
		min = 7 - min; 
		max = 7 - max; 

		if(min > 6) min = 6;		
		if(max > 6) max=6;

		int[] answer = {max,min};

		return answer;
	}

	public static int[] solution2(int[] lottos, int[] win_nums) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int zeroCount = 0;

		for(int lotto : lottos) {
			if(lotto == 0) {
				zeroCount++;
				continue;
			}
			map.put(lotto, true);
		}
		
		System.out.println(map);

		int sameCount = 0;
		for(int winNum : win_nums) {
			if(map.containsKey(winNum)) sameCount++;
		}

		int maxRank = 7 - (sameCount + zeroCount);
		int minRank = 7 - sameCount;
		if(maxRank > 6) maxRank = 6;
		if(minRank > 6) minRank = 6;

		return new int[] {maxRank, minRank};
	}

}

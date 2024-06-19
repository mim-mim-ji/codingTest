package Programmers.level1;

import java.util.ArrayList;
import java.util.*;

public class __Test1 {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] answer = solution(lottos,win_nums);
		System.out.println(Arrays.toString(answer));
		//[3, 5]
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int result = 0;
		ArrayList<Integer> templist = new ArrayList<Integer>();

		Arrays.sort(win_nums); 
		Arrays.sort(lottos);  

		int expect=0;
		for(int i:lottos) {
			if(i==0) {
				expect++;
			}
		}

		int cnt=0; //로또랑 일치하는 개수
		for(int i=0;i<win_nums.length;i++) {
			for(int j=0;j<lottos.length;j++) {
				if(win_nums[i]==lottos[j]) { 
					cnt++;
				}
			}   	   
		}

		expect += cnt;
		
		switch (expect) {
		case 6:
			result = 1;
			break;
		case 5:
			result = 2;
			break;
		case 4:
			result = 3;
			break;
		case 3:
			result = 4;
			break;
		case 2:
			result = 5;				
			break;
		default:
			result = 6;
		}

		templist.add(result);

		switch (cnt) {
		case 6:
			result = 1;
			break;
		case 5:
			result = 2;
			break;
		case 4:
			result = 3;
			break;
		case 3:
			result = 4;
			break;
		case 2:
			result = 5;				
			break;
		default:
			result = 6;
		}


		templist.add(result);
		int index=0;
		for(int num : templist) {
			answer[index++]=num;
		}

		return answer;

	}
}

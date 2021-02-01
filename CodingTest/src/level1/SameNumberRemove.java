package level1;

import java.util.*;

//<같은 숫자는 싫어>
//배열 arr에서 연속적으로 나타나는 숫자는 제거하고 
//남은 수들을 return 하는 solution 함수를 완성해 주세요.
public class SameNumberRemove {
	public static void main(String[] args) {

		int[] arr = {1,1,1,2,3};
		int[] arr2 = {4,4,4,3,3};
		
		System.out.println(Arrays.toString(solution(arr)));
		System.out.println(Arrays.toString(solution(arr2)));		
	}

	public static int[] solution(int []arr) {
		
		ArrayList<Integer> templist = new ArrayList<Integer>();
		int current = 10;
		
		for(int num : arr) { 
			if(current != num) {
				templist.add(num);				
			}
			current = num;
		}
		int[] answer = new int[templist.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = templist.get(i);
		}

		return answer;
	}
}
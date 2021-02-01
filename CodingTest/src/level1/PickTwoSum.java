package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//두개 뽑아서 더하기

public class PickTwoSum {
	public static void main(String[] args) {
		int[] numbers1 = {2,1,3,4,1};					
		System.out.println(Arrays.toString(solution(numbers1)));	//[2,3,4,5,6,7]
						
		int [] numbers2 = {5,0,2,7}; 	
		System.out.println(Arrays.toString(solution(numbers2))); //[2,5,7,9,12]
	}
	
	
	
	public static int[] solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
		
			
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				int sum = numbers[i] + numbers[j];   // 0 -> 1 2 3 4     1 -> 2 3 4 
				if(list.indexOf(sum) < 0) { //없으면 -1을 반환
					list.add(sum);		
				}										
			}
		}		
		
		
		int[] answer = new int[list.size()];	
		for(int i=0;i<list.size();i++) {
				answer[i] = list.get(i);								
		}
		
		Arrays.sort(answer);
		
		
        return answer;
    }
	
	
	
	
	
}

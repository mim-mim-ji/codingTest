package Programmers.level1.DFS;

import java.util.Arrays;

public class CombPractice {

	/*
	 * 7개의 합이 100이 되는 조합을 구하시오
	 */
	public static void main(String[] args) {
		int[]arr = {20,7,23,19,10,15,25,8,13};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	static int[]answer;
	public static int[] solution(int[]arr) {
		answer=new int[7];
		boolean[]visited= new boolean[arr.length];
		
		comb(arr,visited,0,7);
		
		return answer;
	}
	
	public static void comb(int[]arr,boolean[]visited,int start,int r) {
		int idx = 0;
		int sum = 0;
		int index=0;
		if(r==0) {
			int[]temp = new int[7];
			for(int i=0;i<arr.length;i++) {				
				if(visited[i]==true) {
					sum += arr[i];
					temp[idx++] = arr[i];
				}
			}
			
			if(sum==100) {
				for(int i=0;i<temp.length;i++) {
					answer[i] = temp[i];
				}
				Arrays.sort(answer);
			}	
			
			return;
		}else {
			for(int i=start;i<arr.length;i++) {
				visited[i] = true;
				comb(arr,visited,i+1,r-1);
				visited[i] = false;
			}
		}
		
	}
	

}

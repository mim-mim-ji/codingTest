package Programmers.level1;

import java.util.*;

public class KNumber {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}
		};
		System.out.println(Arrays.toString(solution(array,commands))); //5, 6, 3
		System.out.println(Arrays.toString(solution2(array,commands)));
		System.out.println(Arrays.toString(solution3(array,commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {		

		int[] answer = new int [commands.length];

		for(int i=0;i<commands.length;i++) {  
			int start = commands[i][0]; 
			int end = commands[i][1]; 
			int cut = commands[i][2];
			
			int[] temp = new int [end-start+1];
			int cnt=0;
			for(int j=start-1;j<end;j++) {
				temp[cnt++] = array[j];
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int t : temp) {
				list.add(t);
			}
			
			Collections.sort(list);
			answer[i] = list.get(cut-1);
		}
		
		return answer;

	}
	
	public static int[] solution2(int[] array, int[][] commands) {
		int [] answer = new int [commands.length];
		
		for(int i=0;i<commands.length;i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}
		return answer;
	}
	
	public static int[] solution3(int[] array, int[][] commands) {
		
		int[] answer = new int[commands.length];
		int index=0;
		
		for(int i=0;i<commands.length;i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int k = commands[i][2];
			
			int[] temp = new int[end-start+1];
			
			int a=0;
			for(int j=start-1;j<end;j++) {
				temp[a++] = array[j];
			}
			
			Arrays.sort(temp);
			answer[index++] = temp[k-1];
		}
		return answer;
	}
	
	
	
}

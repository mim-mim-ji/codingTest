package Programmers.level1.DFS;

import java.util.Arrays;

public class DFS1 {

	public static void main(String[] args) {

		int[][] arr = {{1,2,3},
				       {4,5,6},
				       {7,8,9}};

		int [] history = new int[3];

		dfs(arr, 0, history);
	}

	private static void dfs(int[][]arr, int depth, int[] history) {
		if(depth== history.length){
			System.out.print(Arrays.toString(history));
			return;
		}
		if(depth==0){
			for(int num : arr[depth]){
				history[depth] = num;
				dfs(arr,depth+1,history);
			}
		}else{
			for(int num : arr[depth]){
				//이전숫자가 짝수, 새로들어올 숫자는 홀수
				if(history[depth-1]%2==0 && num%2!=0){
					history[depth] = num;
					dfs(arr,depth+1,history);
				}
				//이전숫자가 홀수, 새로들어올 숫자는 짝수
				if(history[depth-1]%2!=0 && num%2==0){
					history[depth] = num;
					dfs(arr,depth+1,history);
				}
			}
		}
		return;
	}
}

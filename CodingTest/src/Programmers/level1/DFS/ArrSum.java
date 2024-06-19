package Programmers.level1.DFS;

public class ArrSum {

	/*
	 * int[]arr = {2,5,3,8,1}
	 * int k=3 , int t=11
	 * k개 이상의 원소들을 arr배열에서 뽑아
	 * 그 숫자들의 합이 t이하가 되는 경우의 수를 구하라
	 * 단, 순서대로 뽑아야함
	 * (답은 6)
	 * 
	 * k <= arr.length
	 * 
	 * k=3인 경우
	 * [2,5,3] = 10 *
	 * [2,5,8] = 15 
	 * [2,5,1] = 8 *
	 * [2,3,8] = 13 
	 * [2,3,1] = 6 *
	 * [2,8,1] = 11 *
	 * [5,3,8] = 16 
	 * [5,3,1] = 9 *
	 * [5,8,1] = 14
	 * [3,8,1] = 12
	 * 
	 * k=4인 경우
	 * [2,5,3,8] = 18 
	 * [2,5,3,1] = 11 *
	 * [2,5,8,1] = 16
	 * [2,3,8,1] = 14
	 * [5,3,8,1] = 17
	 * 
	 * k는 1~15이하
	 */

	public static void main(String[] args) {
		int[]arr = {2,5,3,8,1};
		int k=3;
		int t=11;
		System.out.println(solution(arr, k, t));
		System.out.println(solution2(arr, k, t));
	}

	static int answer = 0;
	public static int solution(int[]arr,int k, int t) {
		
		//백트랙킹 이용
		boolean[] visited = new boolean[arr.length];
		
		System.out.println("----------백트래킹 이용----------");
		//n개 중 k개 이상을 뽑아야 함
		for(int r=k;r<=arr.length;r++) {
			comb(arr,visited,0,r,t);
		}
       
        return answer;
       
	}
	
	public static void comb(int[]arr, boolean[] visited, int start, int r, int t) {
		
		int sum = 0; //t와 비교
		
		//r==0이면 다 뽑은 것 -> 리턴
		if(r==0) {
			for(int i=0;i<arr.length;i++) {
				if(visited[i]==true) { //뽑힌 수(true)만 
					System.out.print(arr[i]+" ");
					sum += arr[i];     //sum에 더해줌
				}
			}
			System.out.println();
			if(sum <= t) {
				System.out.println("=> "+sum+"은 "+t+"보다 작음");				
				answer++;
			}
			System.out.println();
			return;
		}else {
			for(int i=start;i<arr.length;i++) {
				visited[i] = true;
				comb(arr,visited,i+1,r-1,t);
				visited[i] = false;
			}
		}		
	}
	
	static int answer2 = 0;
	public static int solution2(int[]arr,int k, int t) {
		
		//재귀함수 이용
		System.out.println("----------재귀함수 이용----------");
		boolean[] visited = new boolean[arr.length];
		
		for(int r=k;r<=arr.length;r++) {
			comb2(arr,visited,0,r,t);
		}
		
		return answer2;		
	}
	
	public static void comb2(int[]arr, boolean[]visited, int depth, int r, int t) {
		int sum = 0;
		
		//r==0이면 다 뽑은 것 -> 리턴
		if(r==0) {
			for(int i=0;i<arr.length;i++) {
				if(visited[i]==true) {
					System.out.print(arr[i]+" ");
					sum+=arr[i];
				}
			}

			if(sum <= t) {
				System.out.println("=>sum = "+sum+"<="+t);
				answer2++;
			}
			System.out.println();
			return;
		}		
		//depth==arr.length는 모든 인덱스를 다 본 것 -> 리턴
		else if(depth==arr.length) {
			return;
		}else {
			visited[depth] = true;
			comb2(arr,visited,depth+1,r-1,t);
			
			visited[depth] = false;
			comb2(arr,visited,depth+1,r,t);
		}
		
	}
	

}

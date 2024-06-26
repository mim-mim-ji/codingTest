package Programmers.level1.DFS;

public class _Combination {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3}; //조합을 만들 배열 
		boolean[] visited = new boolean[arr.length];
		
		//조합 경우의 수
		System.out.println("조합 경우의 수: "+combination(3,2));
		System.out.println();

		//1. 백트래킹을 이용해 구현
		System.out.println("-------- 1. 백트래킹 ---------");

		for(int r = 1; r <= arr.length; r++) {
			System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
			comb1(arr, visited, 0, r);
		}

		//2. 재귀를 이용해 구현
		System.out.println("\n---------- 2. 재귀 ----------");

		for(int r = 1; r <= arr.length ; r++) {
			System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
			comb2(arr, visited, 0, r);
		}
	}
	
	public static int combination(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return combination(n - 1, r - 1) + combination(n - 1, r); 
	}

	//1. 백트래킹을 이용해 구현
	static void comb1(int[] arr, boolean[] visited, int start, int r) {
		if(r == 0) {
			for(int i=0;i<arr.length;i++) {
				if(visited[i] == true)
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		} else {
			for(int i = start; i < arr.length; i++) {
				//i를 뽑음
				visited[i] = true;
				//특정원소를 포함하고 뽑는 경우 구현
				comb1(arr, visited, i + 1, r - 1);
				//이제 i를 뽑을 일이 없으므로 i 선택해제
				visited[i] = false;
				//특정 원소를 포함하지 않고 뽑는 경우를 구현하지않는 이유: 반복문을 통해서 다른 원소에 대해서도 구해주기 때문
			}
		}
	}


	//2. 재귀를 이용해 구현
	static void comb2(int[] arr, boolean[] visited, int depth, int r) {
		if(r == 0) {
			print(arr, visited);
			return;
		}
		if(depth == arr.length) {
			return;
		} else {
			//depth + 1 이 n-1의 역할을 했다고 생각하면됨
			//특정원소를 포함하고 뽑는 경우
			visited[depth] = true;
			comb2(arr, visited, depth + 1, r - 1);

			//특정원소를 포함하지 않고 뽑는 경우
			visited[depth] = false;
			comb2(arr, visited, depth + 1, r);
		}
	}

	// 배열 출력
	static void print(int[] arr, boolean[] visited) {
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}


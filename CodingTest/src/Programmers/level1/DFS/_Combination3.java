package Programmers.level1.DFS;

public class _Combination3 {
	
	//visited 배열을 쓰지 않고 정수 변수 index로 판별해 구해보기
	
	public static void main(String[] args) { 
		int[] arr = new int[3];
		int index = 0;
		int n = arr.length;
		int r = 2;
		
		combination(arr, index, n, r, 0);	
	} 
	
	public static void combination(int[] arr, int index, int n, int r, int target) { 
		if (r == 0) 
			print(arr, index); 
		else if (target == n) 
			return; 
		else { 
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1); 
			combination(arr, index, n, r, target + 1); 
		} 
	}

	//배열 출력 
	public static void print(int[] arr, int length) {
		for (int i = 0; i < length; i++) 
			System.out.print(arr[i] + " ");
		System.out.println(""); 
	} 
}

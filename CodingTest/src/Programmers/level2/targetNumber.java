package Programmers.level2;

public class targetNumber {
	
	/*
	 *  -1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
		
		DFS:깊이 우선 탐색법
	 */

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers,target)); //5

	}

	static int answer = 0;
	public static int solution(int[] numbers, int target) {

        Dfs(numbers,target, 0, 0);

        return answer;
    }
	//시작을 numbers[0]부터 하는게 아니고 0부터 시작하기 때문에 0 + numbers[0] / 0 - numbers[0] 두 경우 모두 포함
	
	public static void Dfs(int[] numbers, int target, int index, int sum) {
		if(index == numbers.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}else {
			Dfs(numbers, target, index+1, sum+numbers[index]);
			Dfs(numbers, target, index+1, sum-numbers[index]);
		}		
	}
}

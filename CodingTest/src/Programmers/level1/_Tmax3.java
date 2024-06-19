package Programmers.level1;

public class _Tmax3 {

	public static void main(String[] args) {
		int [] num = {1,2,3,4,5};
		System.out.println(solution(num));
	}
	
	public static int solution(int[] stats) {
        int answer = 1;

        for(int i=0;i<stats.length-1;i++){
            int max = stats[i];

            if(stats[i+1]<max){
                answer++;
            }           
            max = stats[i+1];
            answer = max;
        }

        return answer;
    }


}

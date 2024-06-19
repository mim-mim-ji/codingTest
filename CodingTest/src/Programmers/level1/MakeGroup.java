package Programmers.level1;

public class MakeGroup {

	/*
	 *  조 편성하기
	 *  int[]stats = {5,3,4,1,2,6}
	 *  [5,6]  5가 새로운 조를 만듦
	 *  [3,4]  3이 새로운 조를 만듦, 4는 5보다 작으므로 못 들어가고 새로운 조를 만들 수 있지만 조가 많아지므로 [3]조에 들어감
	 *  [1,2]  1이 새로운 조를 만듦, 2가 들어옴, 6은 어디든 들어갈 수 있지만 멤버가 가장 적은 [5]조에 들어감
	 *  답은 3
	 *  
	 *  자신보다 낮은 숫자에만 들어갈 수 있음
	 *  낮은 숫자가 없으면 새로운 조를 만들 수 있음
	 *  조별 멤버수는 적을 수록 좋음
	 *  
	 *  만들 수 있는 조의 최소 개수를 구하시오
	 */
	
	public static void main(String[] args) {
		int[]stats = {1,2,3,4,5,6};
		System.out.println(solution(stats));
	}
	
	public static int solution(int[] stats) {
        int answer = 1;
      
        for(int i=0;i<stats.length-1;i++){
        	int max = stats[answer-1];
            if(stats[i+1]<max){
            	System.out.println(max);
                answer++;
            }
            max = stats[i+1];
        }

        return answer;
    }

}

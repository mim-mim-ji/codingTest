package Programmers.level1;

import java.util.*;
public class Fail {

	public static void main(String[] args) {
		int N = 5;
		int[]stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(Arrays.toString(solution2(N,stages)));
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int [N];

		int clearuser = stages.length;
		double fail = 1;

		Map<Integer,Double> map = new HashMap<>();

		for(int stage : stages){
			if(stage<=N){
				map.put(stage,map.getOrDefault(stage,0.0)+1);    
			}
			for(int i=1;i<=N;i++){
				map.put(i,map.getOrDefault(i,0.0));
			}                
		}
		System.out.println(map);

		for(int key : map.keySet()){ 
			if(map.get(key)!=0.0){
				fail = map.get(key)/clearuser;
				clearuser -= map.get(key);
				map.put(key,fail);                
			}
		}
		System.out.println(map);

		for (int i = 0; i < N; i++) {
			double max = -1;
			int maxKey = 0;

			for (int key : map.keySet()) {
				if (max < map.get(key)) {
					max = map.get(key);
					maxKey = key;
				}
			}

			answer[i] = maxKey;
			map.remove(maxKey);
		}


		return answer;
	}
	
	public static int[] solution2(int N, int[] stages) {
        int[] answer = new int[N];
        double[] tempArr = new double[N];
        int arrLength = stages.length;
        int idx = arrLength;
        double tempD = 0;
        int tempI = 0;
        
        for (int i = 0; i < arrLength; i++) {
            int stage = stages[i];
            if (stage != N + 1)
                answer[stage - 1] += 1;
        }
        
        System.out.println(Arrays.toString(answer));
        
        for (int i = 0; i < N; i++) {
            int personNum = answer[i];
            tempArr[i] = (double) personNum / idx;
            idx -= personNum;
            answer[i] = i + 1;
        }
        System.out.println(Arrays.toString(tempArr));

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (tempArr[j - 1] < tempArr[j]) {
                    tempD = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tempD;

                    tempI = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tempI;
                }
            }
        }
        return answer;
       
    }

}

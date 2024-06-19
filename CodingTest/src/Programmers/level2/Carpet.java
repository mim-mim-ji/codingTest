package Programmers.level2;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[]  answer = solution(brown,yellow);
        System.out.println(Arrays.toString(answer));

        System.out.println(Arrays.toString(solution2(brown,yellow)));
    }

    private static int[] solution(int brown, int yellow){
        int[] answer = new int[2];

        for(int i=3;i<=yellow+2;i++){
            for(int j=3;j<=yellow+2;j++){
                if(i >= j){
                    if((i-2) * (j-2) == yellow){
                        if(i*j - yellow == brown) {
                            System.out.println("가로:" + i + ", 세로:" + j);
                            answer[0] = i;
                            answer[1] = j;
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static int[] solution2(int brown, int yellow){
        int[] answer = new int[2];

        //yellow의 약수를 찾기
        for(int i=1;i<=yellow;i++){
            int a = 0;
            int b = 0;
            if (yellow % i == 0){
                a = yellow / i;
                b = i;
            }
            if((a+2)*(b+2)-yellow==brown){
                if(a >= b){
                    answer[0] = a+2;
                    answer[1] = b+2;
                }
            }
        }

        return answer;
    }

}

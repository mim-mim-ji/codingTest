package Programmers.level0;

import java.util.Arrays;

public class 배열두배 {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i < numbers.length;i++){
           int temp = numbers[i] * 2;
           answer[i] = temp;
        }
        return answer;
    }
}

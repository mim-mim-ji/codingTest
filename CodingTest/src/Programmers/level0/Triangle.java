package Programmers.level0;

public class Triangle {
    public static void main(String[] args) {
        int [] sides = {11,7};
        //가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다
        //나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
        System.out.println(solution(sides));
    }
    public static  int solution(int[] sides) {
        int answer = 0;

        int max = Math.max(sides[0],sides[1]);
        int min = Math.min(sides[0],sides[1]);
        //sides에 가장 큰 변이 있는 경우 - 둘 중 더 큰 수가 기준
        for(int i=max-min+1;i<=max;i++){
            answer++;
        }

        //나머지 한 변이 가장 큰 변일 경우
        for(int i=max+1;i<max+min;i++){
            answer++;
        }

        return answer;
    }
}

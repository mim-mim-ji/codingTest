package Programmers.level0;

public class FloatToInt {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        System.out.println(solution(a,b));

        String str = "abcdbbbbbbb";
        System.out.println(str.replaceAll("[b,a]","x"));
    }

    //   Math.ceil 은 소수값이 존재할 때 값을 올리는 역활을 하는 함수이며,
    //
    //   Math.floor 는 소수값이 존재할 때 소수값을 버리는 역활을 하는 함수이며,
    //
    //   Math.round 는 소수값에 따라 올리거나 버리는 역활을 하는 반올림 함수입니다.

    public static int solution(int num1, int num2) {
        double divide = (double) num1 / num2;
        System.out.println(divide);
        int answer = (int) Math.floor(divide*1000);
        return answer;
    }
}

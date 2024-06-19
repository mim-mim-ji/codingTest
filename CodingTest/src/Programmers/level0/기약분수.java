package Programmers.level0;

import java.util.Arrays;

public class 기약분수 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int numer2 = 3;
        int denom2 = 4;
        System.out.println(Arrays.toString(solution(a,b, numer2,denom2)));
    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int numer3 = numer1 * denom2 + numer2 * denom1;
        int denom3 = denom1 * denom2;
        int gcd= getGcd(numer3, denom3); //최대공약수를 구해준다.
        System.out.println(numer3/gcd+" "+denom3/gcd); //기약분수 출력
        answer = new int[]{numer3 / gcd, denom3 / gcd};
        return answer;
    }

    //최대공약수 - 유클리드 호제법
    private static int getGcd(int a,int b){
        if(a % b ==0){
            return b;
        }
        return getGcd(b, a % b);
    }
}

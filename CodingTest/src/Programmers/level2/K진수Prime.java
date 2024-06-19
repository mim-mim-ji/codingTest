package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K진수Prime {
    /*
    양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
        0P0처럼 소수 양쪽에 0이 있는 경우
        P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
        0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
        P처럼 소수 양쪽에 아무것도 없는 경우
     */
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(solution(n,k)); //3
        //211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P

//        int n = 110011;
//        int k = 10;
//        System.out.println(solution(n,k)); //2
    }

    public static int solution(int n, int k) {
        int answer = 0;
        //10진수 -> n진수 : Integer.toString(n,k)
        System.out.println(Integer.toString(n,k));

        String[] temp = Integer.toString(n,k).replaceAll("0"," ").split(" ");

        System.out.println(Arrays.toString(temp));

        List<String> list = new ArrayList<>();

        for(String s : temp){
            if(s.trim().length()!=0) list.add(s);
        }

        for(String li : list){
            long num = Long.parseLong(li);
            if(isPrime(num) && num >=2) answer++;
        }

        System.out.println(list);
        return answer;
    }

    private static boolean isPrime(long num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}

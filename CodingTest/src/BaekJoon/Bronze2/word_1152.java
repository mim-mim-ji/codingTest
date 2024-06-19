package BaekJoon.Bronze2;

import java.util.Scanner;

public class word_1152 {
    public static void main(String[] args) {
        //영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
        //이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        sc.close();
        solution(S);
    }

    private static void solution(String s) {
        //split(" ") 은 공백도 단어로 처리함
        s = s.trim();
        if(s.equals("")){
            System.out.println(0);
        }else{
            String[] st = s.split(" ");
            System.out.println(st.length);
        }
    }
}

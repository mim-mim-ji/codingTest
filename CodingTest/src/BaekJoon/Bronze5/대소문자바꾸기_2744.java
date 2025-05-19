package BaekJoon.Bronze5;

import java.util.Scanner;

public class 대소문자바꾸기_2744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }

    private static void solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            }else{
                answer.append(Character.toUpperCase(c));
            }
        }
        System.out.println(answer);
    }
}

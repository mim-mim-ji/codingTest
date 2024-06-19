package 개념정리.인프런.자료구조;

import java.util.Scanner;

public class Nhap_11720 {
    /*
        숫자의 개수 N
        숫자 N개가 주어졌을 때 숫자 N개의 합을 구하라

        //문제분석하기
        1<= N <= 100 -> int/long으로 받을 수 없음 => String으로 받아야함
        문자열 -> 문자배열로 변환
        toCharArray

        문자배열값을 순서대로 읽으면서 숫자형으로 변환하여 더해야함

        문자열 -> 숫자형으로 변경: 아스키코드
        문자 1의 아스키코드 값: 49
        문자 1 -> 숫자 1로 변환: '1' - 48 또는 '1' - '0'

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();

        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for(int i=0;i<cNum.length;i++){
            sum += cNum[i] - '0'; // '0'을 안빼주면 해당 문자의 아스키코드가 sum에 들어감
        }
        System.out.println(sum);
    }
}

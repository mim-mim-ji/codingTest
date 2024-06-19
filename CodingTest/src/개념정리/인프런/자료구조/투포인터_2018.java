package 개념정리.인프런.자료구조;

import java.util.Scanner;

public class 투포인터_2018 {
    /*
    투포인터

    연속된 자연수의 합 구하기
    //문제분석
    N이 매우 큼
    O(n) 시간복잡도 -> 투포인터
    시작,종료인덱스 각각 N의 시간복잡도 2N -> 결국 N의 시간복잡도
    시작인덱스 종료인덱스를 지정

    N=15일 경우
    15까지 들어있는 A배열을 만듦
    시작인덱스를 모두 첫번째 인덱스
    sum = 1, count =1

    이동원칙
    sum > N: sum = sum-startindex; startindex++
    sum < N: endindex++; sum = sum + endindex;
    sum == N: count++ endindex++; sum = sum+endindex;

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int count =1;
         int start_index = 1;
         int end_index = 1;
         int sum = 1;

         while(end_index!=N){
             if(sum == N){
                 count++;
                 end_index++;
                 sum += end_index;
             }else if(sum > N){
                 sum -= start_index;
                 start_index++;
             }else{
                 end_index++;
                 sum += end_index;
             }
         }
        System.out.println(count);
    }
}

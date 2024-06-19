package 개념정리.인프런.자료구조;

import java.util.Scanner;

public class avg_1546 {
    /*
       시험을 본 과목의 개수 N<=1000
       현재 성적

       최대값 M
       모든 성적 / M *100 으로 변경해서 새로운 평균을 구하라

       //문제분석
       최고점을 별도로 저장
       수학적으로 정리하면 (A + B + C) * 100 / M / N

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int A[] = new int[N];
//        for(int i=0;i<N;i++){
//            A[i] = sc.nextInt();
//        }
        long sum = 0;
        long max = 0;

        for(int i=0;i<N;i++){
            //if(A[i]>max) max = A[i];
            // sum += A[i];
            int temp = sc.nextInt();
            if(temp >max) max = temp;
            sum += temp;
        }

        System.out.println(sum*100.0/max/N);
    }
}

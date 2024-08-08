package 개념정리.인프런.탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 이진탐색_1920 {
    /*
    N개의 정수
    N<=10만이므로 n제곱 알고리즘은 사용 X

    이진탐색의 핵심은 데이터가 정렬되어있어야하므로 정렬이 먼저 수행되어야함
    n개 데이터 정렬할때
    자바의 기본 정렬은 nlogn의 시간복잡도를 가지므로 정렬을 수행해도 제한시간을 초과하지 않음
    //nlogn + nlogn = 2nlogn => nlogn(상수 무시)


     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            boolean find = false;
            int target = sc.nextInt();

            int start = 0;
            int end = A.length -1;
            while (start <= end){
                int mid_index = (start + end)/2; //중간인덱스
                int mid_value = A[mid_index]; //중앙값
                if(mid_value > target){
                    end = mid_index -1;
                } else if(mid_value < target){
                    start = mid_index +1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find) System.out.println(1);
            else System.out.println(0);
        }

    }
}

package 개념정리.인프런.정렬;

import java.util.Scanner;

public class 선택정렬_1427 {
    /*
    대상데이터에서 최대나 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택하는 방법

    시간복잡도 O(n2): N개 중에 최솟값 찾기 -> N만큼 탐색, N-1만큼 탐색 .... -> N만큼 반복 = N*N = N2

    핵심이론: 최솟값 또는 최댓값을 찾고, 남은 정렬부분의 가장 앞에 있는 데이터와 swap하는 것


     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        for(int i=0;i<str.length();i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }
        //선택정렬
        for(int i=0;i<str.length();i++){
            int Max = i;
            for(int j=i+1;j<str.length();j++){
                if(A[j] > A[Max]){
                    Max = j;
                }
            }
            //swap
            if(A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        for(int i=0;i<str.length();i++){
            System.out.print(A[i]);
        }
    }
}

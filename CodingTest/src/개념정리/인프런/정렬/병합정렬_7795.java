package 개념정리.인프런.정렬;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 병합정렬_7795 {
    /*
    시간제한 1초
    1<= N, M <= 20,000

    1억번연산 = 1초
    nlogn 시간복잡도로 풀어야함!


2
5 3
8 1 7 3 1
3 6 1
3 4
2 13 7
103 11 290 215
------------------
7
1
     */
    public static void main(String[] args) {
        /*
        1. 두개의 데이터셋을 합쳐가면서 sort
        2. 이때 각각의 데이터셋을 정렬
         */
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i=0;i<testCase;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            for(int j=0;j<N;j++){
                A.add(sc.nextInt());
            }
            for(int j=0;j<M;j++){
                B.add(sc.nextInt());
            }
            Collections.sort(A, Collections.reverseOrder());
            Collections.sort(B, Collections.reverseOrder());
            int pointerA = 0;
            int pointerB = 0;
            int result = 0;
            while (pointerA < A.size()){
                if(pointerB == B.size()) break;
                while (pointerB<B.size() && A.get(pointerA) <= B.get(pointerB)){
                    pointerB++;
                }
                result += (B.size()-pointerB);
                pointerA++;
            }
            System.out.println(result);
         }
    }
}

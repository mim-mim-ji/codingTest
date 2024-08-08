package 개념정리.인프런.탐욕알고리즘;

import java.util.Scanner;

public class 그리디_11047 {
    /*
    N 종류
    K 를 만들어야함
    K원을 만드는데 필요한 동전 개수의 최솟값
    => 그리디: 현재상태에서 best 수를 선택해서 해를 찾는 방법
    => 최대한 큰 금액의 동전부터 차례대로 사용하면 됨

    반례 주의!
    배수의 형태로 주어졌기 때문에 반례X -> 그리디로 풀이가능
    반례 ex) 1, 3, 5 -> 9를 만드는 경우 3을 3번 사용하면 9
           5부터 안써도됨

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A[] = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }

        //그리디 알고리즘 -> 큰 동전 먼저 사용하기
        int count = 0;
        for(int i=N-1;i>=0;i--){
            if(A[i] <= K){
                count += (K / A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
    }
}

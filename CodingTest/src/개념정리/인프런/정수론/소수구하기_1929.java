package 개념정리.인프런.정수론;

import java.util.Scanner;

public class 소수구하기_1929 {
    /*
    소수: 1과 자기 자신 외에 약수가 존재하지 않는 수

    소수를 구하는 대표적인 판별볍: 에라토스테네스의 체 원리

    시간복잡도 O(nlog(logN))

----------------------------------------------------
    N의 최대범위가 백만이므로 일반적인 풀이법으로 풀면안됨
    -> 에라토스테네스의 체를 사용하기

    1. 크기가 N+1인 배열을 선언한 후 각각의 인덱스값으로 채우기
    2. 1은 소수가 아니므로 삭제
    3. 2부터 N의 제곱근까지 값을 탐색, 값이 인덱스값이면 그대로 두고(=소수로 인정)
        그 값의 배수를 탐색해 0으로 변경
    4. 배열에 남아있는 수 중 M이상 N이하의 수를 모두 출력

    axb = N = 루트N x 루트N


     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j <= N; j += i) {
                A[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}

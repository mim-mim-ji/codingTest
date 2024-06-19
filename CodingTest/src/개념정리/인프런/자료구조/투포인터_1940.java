package 개념정리.인프런.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 투포인터_1940 {
    /*

    N개의 수가 주어짐
    2개 재료 합쳐서 M을 만들어야함

    1. 주어진 숫자를 오름차순 정렬
    2. 양쪽 끝의 위치를 투포인터로 지정해 접근
        제일 작은 수랑 제일 큰수랑 더해서 M이 나오는지 확인

    정렬 알고리즘의 시간복잡도는 O(nlogn)

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0; //A[0] -> min
        int j = N-1; //A[N-1] -> max

        while(i < j){
            if(A[i] + A[j] < M) i++;
            else if (A[i] + A[j] > M) j--;
            else count++; i++; j--;
        }
        System.out.println(count);
    }
}

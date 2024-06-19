package BaekJoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer_1806 {
    //10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
    //이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;
        int length = 0;

        while(end <= N){
            if(sum >= S ){
                sum -= arr[start++];
                length = end - start + 1; //길이
                if(answer > length) answer = length; //길이의 최소값

            }else if(sum < S){
                sum += arr[end++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}

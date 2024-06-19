package 개념정리.인프런.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합_11659 {
    /*
        수의 개수와 합을 구해야하 횟수는 최대 100,000
        구간마다 합을 매번 계산하면 0.5초 안에 모든 구간합 계산을 끝낼 수 없음
        (최악의 경우 1억회 이상의 연산, 1초 이상의 수행시간이 필요함 (자바에서는 1억번 = 1초))
        => 구간 합을 이용해야함

        1) N개의 수를 입력받음과 동시에 합배열을 생성하기
        S[i] = S[i-1] + A[i]

        2) 구간 i~j가 주어지면 구간합을 구하는 공식으로 정답을 출력
        i~j까지 구간합 : S[j] - S[i-1]

     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new  long[suNo+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1;i<=suNo;i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q=0;q<quizNo;q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}

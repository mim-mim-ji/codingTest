package 개념정리.인프런.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩윈도우_12891 {
    //슬라이딩 윈도우
    //2개의 포인터로 범위(window)를 지정한 다음 범위를 유지한 채로 이동하며 문제를 해결한다
    //배열 길이만큼만 탐색을 진행하면 되므로 => 시간복잡도: O(n)
    //넣고 빠지는 데이터 체크하면됨
    /*
    AAACCTGCCAA
    부분 문자열의 길이 4
    A는 1개 이상 C는 1개이상 G는 1개이상 T는 0개 이상
    => GCCA 를 비밀번호로 사용가능


    예제)
    9 8 //문자열의 길이, 부분문자열의 길이=window
    CCTGGATTG //임의로 만든 문자열
    2 0 1 1 //포함되어야 할 최소개수
    {A,C,G,T}
     */
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); //문자열 크기
        int P = Integer.parseInt(st.nextToken()); //부분 문자열 크기
        int Result = 0;

        checkArr = new int[4]; //비밀번호 체크배열
        myArr = new int[4]; //현재상태배열: 현재 들어온 부분문자열에서 A C G T 가 몇개인지 체크
        checkSecret = 0; //몇개의 문자와 관련된 개수를 충족했는지 판단하는 변수: 예를 들어 A만 충족이 되면 1일 것이고 다 만족하면 주어진 문자 수 만큼 만족

        char A[] = bf.readLine().toCharArray(); //임의로 만든 문자열

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4;i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] ==0){ //체크해야할 문자가 하나 줄어듦
                checkSecret++;  //4개를 만족해야하는데 0이 들어오면 이미 만족했다는 뜻이므로
            }
        }

        for(int i=0;i<P;i++){ //부분문자열 처음 받을 때 셋팅: 이미 한번 슬라이딩윈도우 체크
            Add(A[i]);
        }

        //슬라이딩윈도우 -> 부분문자열 처음 받을 때 셋팅 다음부터 넣어줌
        for(int i=P;i<S;i++){ //맨 오른쪽
            int j = i-P;    //맨 왼쪽
            Add(A[i]);
            Remove(A[j]);

            if(checkSecret == 4) Result++;
        }

        System.out.println(Result);
        bf.close();
    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                 myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                 myArr[2]--;
                break;
           case 'T':
                if(myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                 myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
           case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}

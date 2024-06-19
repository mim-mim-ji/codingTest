package Programmers.level1;

import java.util.Arrays;

public class OrderKSu {
    //크기가 N×N인 배열 A
    //배열에 들어있는 수 A[i][j] = i×j
    //일차원 배열 B에 넣으면 B의 크기는 N×N
    //B를 오름차순 정렬했을 때, B[k] = ?
    //배열 A와 B의 인덱스는 1부터 시작
    public static void main(String[] args) {
        int[][] A = {};
        int N = 3;
        int [] B = new int [N * N];
        int K = 7;
        System.out.println(solution(N,K));
    }

    private static int solution(int n, int k) {
        int answer = 0;
        int[][] A = new int[n+1][n+1];
        int [] B = new int [n * n];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                A[i][j] = i*j;
            }
        }
        System.out.println(Arrays.deepToString(A));
        int index = 0;
        for(int [] arr: A){
            for(int a:arr){
                if(a != 0){
                    B[index++] = a;
                }
            }
        }
        Arrays.sort(B); //정렬
        answer = B[k];

        return answer;
    }

}

//public class Main {
//    static int N, k;
//    static int[] arr;
//
//    public static void main(String[] args)throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        k = Integer.parseInt(br.readLine());
//
//        int min = 1;
//        int max = k;
//
//        while(min < max) {
//
//            int mid = (min + max)/2;
//
//            int cnt = 0;
//            for(int i = 1 ; i <= N ; i++) {
//                cnt += Math.min(mid/i, N);
//            }
//
//            if( cnt >= k)
//                max = mid;
//            else
//                min = mid+1;
//        }
//        System.out.println(min);
//    }
//}

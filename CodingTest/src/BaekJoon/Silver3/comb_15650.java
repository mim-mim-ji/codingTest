package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class comb_15650 {
    //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    static int N;
    static int M;
    static int [] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        int [] arr = new int[N];
//        for(int i=0;i<N;i++){
//            arr[i] = i+1;
//        }
//        boolean[] visited = new boolean[N];
//
//        dfs(arr,visited,0,M);

        arr = new int[M];
        visited = new boolean[N]; //1~N까지 자연수 중 방문한 자연수를 저장할 배열
        dfs(0,0);
    }

    private static void dfs(int depth, int start) {
        if(depth==M){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=start;i<N;i++){
                if(! visited[i]) {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }

    /*
    private static void dfs(int[] arr, boolean[] visited, int start, int r) {
        if(r==0){
            for(int i=0;i<arr.length;i++){
                if(visited[i]) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=start;i<arr.length;i++){
                visited[i] = true;
                dfs(arr, visited, i+1, r-1);
                visited[i] = false;
            }
        }
    }
    */
}

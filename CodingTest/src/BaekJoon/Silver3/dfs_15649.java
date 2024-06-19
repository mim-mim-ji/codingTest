package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
public class dfs_15649 {
    static int N;
    static int M;
    static boolean [] visited;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; //M개를 뽑을 것
        visited = new boolean[N]; //1~N까지 자연수 중 방문한 자연수를 저장할 배열

        dfs(visited,0);
    }

    private static void dfs(boolean[] visited, int depth) {
        if(depth==M){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        } else{
            for(int i=0;i<N;i++){
                if(! visited[i]){
                    visited[i] = true;
                    arr[depth] = i+1;
                    dfs(visited,depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}

package BaekJoon.Silver3;

import java.util.Scanner;

public class Permutation_10974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        //1부터 N까지의 수로 이루어진 순열

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        int [] output = new int[N];
        boolean [] visited = new boolean[N];

        permutation(arr,output, visited, 0,N);

    }

    private static void permutation(int[] arr,int []output, boolean[] visited, int depth, int r) {
        if(depth == r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=0;i<arr.length;i++){
                if(! visited[i]){ //첫번째 인덱스부터 살펴보므로 TRUE인지 FALSE인지 확인해야함
                    visited[i] = true;
                    //depth번째 인덱스에 값넣기
                    output[depth] = arr[i];
                    permutation(arr,output, visited,depth+1,r);
                    visited[i] = false;
                }
            }
        }
    }
}

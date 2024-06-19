package Programmers.level1.DFS;

public class Permutation {

    //순열 : 순서가 있는 조합
    public static void main(String[] args) {

        //원본배열
        int [] arr = {1,2,3};
        //출력하고자 하는 배열
        int [] output = new int[arr.length];
        //방문여부 체크
        boolean [] visited = new boolean[arr.length];

        for(int i=1;i<=arr.length;i++){
            //배열에서 i개를 뽑는 경우
            System.out.println(arr.length+"개 중에서 "+i+"개 뽑아서 정렬");
           dfs(arr,output,visited,0,i);
        }

    }

    //depth : 현재 탐색하고 있는 인덱스
    //r : 뽑고자 하는 개수
    public static void dfs(int[]arr, int[] output, boolean[] visited, int depth, int r){
        if (depth == r) {
            for(int i=0;i<r;i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }else{
            for(int i=0;i<arr.length;i++){
                if(! visited[i]){
                    visited[i] = true;
                    output[depth] = arr[i];
                    //System.out.println(Arrays.toString(output));
                    dfs(arr, output,visited,depth+1,r);
                    visited[i] = false;
                }
            }
        }
    }
}

package Programmers.level1.DFS;

public class Combination {

    public static void main(String[] args) {
        //원본배열
        int [] arr = {1,2,3};
        //방문여부 체크
        boolean [] visited = new boolean[arr.length];

        for(int i=1;i<=arr.length;i++){
            //배열에서 i개를 뽑는 경우
            System.out.println(arr.length+"개 중에서 "+i+"개 뽑음");
            dfs(arr,visited,0,i);
        }
    }

    private static void dfs(int[] arr, boolean[] visited, int start, int r) {
        if(r==0){
            for(int i=0;i<arr.length;i++){
                if(visited[i])
                    System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=start;i<arr.length;i++){
//                if(! visited[i]){
//                    visited[i] = true;
//                    dfs(arr,visited,i+1,r-1);
//                    visited[i] = false;
//                }
                visited[i] = true;
                dfs(arr,visited,i+1,r-1);
                visited[i] = false;
            }
        }
    }
}

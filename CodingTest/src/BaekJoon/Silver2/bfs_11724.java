package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_11724 {
    static int N;
    static int [][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        arr = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //무방향그래프: x노드에 y노드 연결
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        visited = new boolean[N+1];
        int count = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=1;i<=N;i++){
                if(!visited[i] && arr[cur][i]==1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

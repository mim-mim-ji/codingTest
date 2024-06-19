package BaekJoon.Silver2;

import java.util.*;

public class graph_1260 {

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            putEdge(graph,x,y);
        }

        for(int i=0;i<=N;i++){
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N+1];

        dfs(V, visited);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void putEdge(ArrayList<ArrayList<Integer>> graph,int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(" ");

        for(int no : graph.get(node)){
            if(!visited[no]){
                dfs(no, visited);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[N+1];
        queue.add(v);
        visited[v] = true;
        while (! queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");

            for(int no : graph.get(node)){
                if(visited[no]) continue;
                queue.add(no);
                visited[no] = true;
            }
        }
    }
}

package BaekJoon.Silver3;

import java.util.ArrayList;
import java.util.Scanner;

public class graph_2606 {
    static boolean [] visited;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            putEdge(graph,x,y);
        }

        visited = new boolean[N+1];

        dfs(1);

        System.out.println(answer-1);

    }

    private static void dfs(int node) {
        visited[node] = true;
        answer++;

        for(int no : graph.get(node)){
            if (! visited[no]) dfs(no);
        }
    }

    private static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}

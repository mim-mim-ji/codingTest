package BaekJoon.Gold4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start, end, weight;

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //간선의 가중치 오름차순
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class MST_1197 {
    //최소 신장 트리(MST, Minimum Spanning Tree)
    //트리: 노드 N개와 N-1개의 간선으로 이루어져 있으며 모든 노드가 서로 연결되어있는 구조

    static int[] parent;
    static int V,E;
    static List<Edge> list = new ArrayList<>();
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //노드
        V = Integer.parseInt(st.nextToken());
        //간선
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];

        for(int i=0;i<=V;i++){
            parent[i] = i;
        }

        for(int i=0;i < E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(start,end,weight));
        }

        //1. 간선크기로 오름차순 정렬
        Collections.sort(list);

        int size = list.size();

        //2. 정렬된 순서대로 간선 탐색
        for(int i=0;i<size;i++){
            Edge edge = list.get(i);
            if(! same(edge.start, edge.end)){
                sum += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(sum);

    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int start, int end) {
        int a = find(start);
        int b = find(end);
        if(a != b){
            parent[b] = a;
        }
    }

    private static boolean same(int start, int end) {
        return find(start) == find(end);
    }
}

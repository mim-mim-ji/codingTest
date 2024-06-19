package Programmers.level2.Node;

import java.util.*;

public class FarNode {
    /*
    n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
    1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
    노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
    1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String[] args) {
        int n =6;
        int[][]vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        //System.out.println((solution(n, vertex))); //3

        solution2(n,vertex);
    }

    static boolean[] visited;
    static boolean[][] relative; //인접행렬

    public static  int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        relative = new boolean[n+1][n+1];

        answer = bfs(edge);

        return answer;
    }

    //거리가 가까운 순으로 탐색해야 하므로 bfs를 사용해야함!
    public static int bfs(int[][]edge){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); //1번 노드부터 탐색 시작
        visited[1] = true;

        for(int i=0;i<edge.length;i++){
            int x = edge[i][0];
            int y = edge[i][1];

            relative[x][y] = true;
            relative[y][x] = true;
        }
        System.out.println(Arrays.deepToString(relative));

        int size = 0;

        while(! queue.isEmpty()){
            size = queue.size();

            for(int i=0;i<size;i++){
                int current = queue.poll();

                for(int j=1;j<visited.length;j++){
                    if(!visited[j] && relative[current][j]){
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }

        return size;
    }

    private static void solution2(int n, int[][] vertex) {
        //인접리스트
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int M = vertex.length; // 간선개수

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] ver : vertex){
            graph.get(ver[0]).add(ver[1]);
            graph.get(ver[1]).add(ver[0]);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(graph.get(i));
        }

        System.out.println(graph);

        int answer = bfs2(graph,1);

        System.out.println(answer);
    }

    private static int bfs2(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[graph.size()+1];
        queue.add(n); //시작노드 추가
        visited[n] = true; //방문체크

        int size = 0;

        while(! queue.isEmpty()){
            size = queue.size();

            System.out.println(queue);
            for(int i=0;i<size;i++){
                int current = queue.poll();
                for(int j=0;j<graph.get(current).size();j++){
                    if(! visited[graph.get(current).get(j)]){
                        visited[graph.get(current).get(j)] = true;
                        queue.add(graph.get(current).get(j));
                    }
                }
            }
        }
        return size;
    }

}

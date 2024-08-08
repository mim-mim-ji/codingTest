package 개념정리.인프런.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dfs_11724 {

    /*
    노드의 개수 N 최대 1000 -> N2이하 알고리즘 모두 사용
    엣지 개수 M
    연결요소는 엣지로 연결된 노드의 집합

    방향이 없는 그래프이기 때문에 양쪽 방향으로 엣지를 모두 저장
    1을 시작점으로 정하고 탐색 시작

    dfs의 수행횟수 = 연결요소개수
    만일 노드가 모두 연결되어있었다면 dfs는 1번 실행 = 연결요소 1개

     */

    static boolean[] visited;
    static ArrayList<Integer>[] A;  //인접리스트 방식
    public static void main(String[] args) throws IOException {
        /*
        재귀 형식으로 구현 = 스택과 같은 방식
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1]; //0번 인덱스 사용안하려고
        A = new ArrayList[N+1];

        //각 노드에 리스트 초기화
        for(int i=1 ; i<N+1 ; i++){
            A[i] = new ArrayList<>();
        }

        //리스트에 데이터 넣기
        for(int i=0; i<M ;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //시작점
            int e = Integer.parseInt(st.nextToken()); //종료점

            //방향성이 없기 때문에 양쪽으로 연결해주어야함
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1;i<N+1;i++){
            System.out.println(A[i]);
        }

        //dfs 수행횟수 = 연결요소개수를 구할 count
        int count = 0;
        //1번 노드부터 탐색
        for(int i=1 ; i<N+1 ;i++){
            if(! visited[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v){
        if(visited[v]){ //방문노드이면 return
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(! visited[i]){
                DFS(i);
            }
        }
    }
}

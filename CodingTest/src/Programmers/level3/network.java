package Programmers.level3;

import java.util.Arrays;

public class network {
    public static void main(String[] args) {
        /*
        컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
        각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
        i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
        computer[i][i]는 항상 1입니다.
         */
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int[][] computers1 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println("answer: "+solution(n,computers)); //네트워크 개수 : 2
    }

    static boolean [] visited;
    static int answer;
    private static int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(! visited[i]){
                dfs(computers,i);
                answer++;
            }
        }
        System.out.println(Arrays.toString(visited));
        return answer;
    }

    private static void dfs(int[][] computers, int i) {
        visited[i] = true;

        for(int j=0;j<computers.length;j++){
            if(i!=j && computers[i][j]==1 && visited[j]==false) {
                dfs(computers, j);
            }
        }
    }

}

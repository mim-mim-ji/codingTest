package Programmers.level3;

public class Rank {
    //선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
    // 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
    /*
    선수의 수는 1명 이상 100명 이하입니다.
    경기 결과는 1개 이상 4,500개 이하입니다.
    results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
    모든 경기 결과에는 모순이 없습니다.

    *힌트
    DFS로 탐색한다 => 처음 시작하는 부모 노드가 나머지 자식 노드를 다 이길수 있다는 뜻입니다!
    순위를 알 수 있다 => 모든 노드와의 관계를 알고 있다는 뜻 입니다!
     */

    public static void main(String[] args) {
        int n = 5;
        int[][] results ={{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution(n,results)); //2

    }

    static int[][] relatives;
    public static  int solution(int n, int[][] results) {
        int answer = 0;

        relatives = new int[n+1][n+1];

        for(int i=0;i<results.length;i++){
            int x = results[i][0];
            int y = results[i][1];

            //x > y
            relatives[x][y] = 1;
            relatives[y][x] = -1;
        }

        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                for(int j=1;j<=n;j++){
                    if(relatives[i][k] ==1 && relatives[k][j]==1){
                        relatives[i][j] = 1;
                        relatives[j][i] = -1;
                    }
                    if(relatives[i][k] == -1 && relatives[k][j]== -1){
                        relatives[i][j] = -1;
                        relatives[j][i] = 1;
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j : relatives[i]){
                if(j!=0) cnt++;
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }
}

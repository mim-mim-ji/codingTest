package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //1,2,3,6,9,8,7,4,5
        System.out.println(spiralOrder2(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = col-1;
        int top = 0;
        int bottom = row-1;

        while(left <= right && top <=bottom){
            //오른쪽으로 이동
            for(int i=left;i<= right;i++){
                answer.add(matrix[top][i]);
            }
            top++;

            //아래로 이동
            for(int i=top;i<=bottom;i++){
                answer.add(matrix[i][right]);
            }
            right--;

            //왼쪽으로 이동
            if(top <= bottom){
                for(int i=right;i>= left;i--){
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //위로 이동
            if(left<=right){
                for(int i=bottom;i>= top;i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }

        return answer;
    }


    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length; //행
        int n = matrix[0].length; //열

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        ans.add(matrix[0][0]);

        int dis = 0;
        dfs(matrix,visited,0,0,m,n,ans,dis);

        return ans;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int x, int y, int m, int n, List<Integer> ans, int dis) {
        //오른쪽 -> 아래 -> 왼쪽 -> 위 순서
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(ans.size() != m*n){
            int nx = x + dx[dis];
            int ny = y + dy[dis];

            if(nx <0 || ny<0 || nx >= n || ny >= m || visited[nx][ny]){
                if(dis==3) dis =0;
                else dis += 1;
                continue;
            }

            visited[nx][ny] = true;
            ans.add(matrix[nx][ny]);
            dfs(matrix,visited,nx,ny,m,n,ans,dis);
            return;
        }
    }
}

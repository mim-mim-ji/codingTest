package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //Output: {1,2,4,7,5,3,6,8,9}
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0)return new int[0];

        int N = matrix.length; //세로
        int M = matrix[0].length; //가로

        int [] result = new int[N*M];
        int k=0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for(int d=0;d<N+M-1;d++){
            //d에 따라 intermediate가 바뀌므로 초기화
            intermediate.clear();

            //각 대각선의 시작점을 찾아야함
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            //대각선의 시작점에서부터 하나씩 감소시켜서 원소를 찾은 후 리스트삽입
            while(r<N && c > -1){
                intermediate.add(matrix[r][c]);
                r++;
                c--;
            }

            if(d%2==0){
                Collections.reverse(intermediate);
            }

            for(int i=0;i<intermediate.size();i++){
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}

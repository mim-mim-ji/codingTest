package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        /*
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
         */
        int numRows = 5;
        System.out.println(generate(numRows));
        System.out.println(generate2(numRows));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> start = new ArrayList<>();
        start.add(1);

        answer.add(start);

        if(numRows==1) return answer;

        start = Arrays.asList(1,1);
        answer.add(start);

        for(int i=1;i<numRows-1;i++){ //이전인덱스
            List<Integer> cur = new ArrayList<>();
            cur.clear();

            cur.add(1);
            for(int j=0;j<i;j++){ //현재리스트
                int temp = answer.get(i).get(j) + answer.get(i).get(j+1);
                cur.add(temp);
            }
            cur.add(1);

            answer.add(cur);
        }

        return answer;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            Integer[] temp = new Integer[i+1];
            Arrays.fill(temp,1);
            answer.add(Arrays.asList(temp));
        }

        for(int i=2;i<numRows;i++){
            for(int j=1;j<answer.get(i).size()-1;j++){
                answer.get(i).set(j,answer.get(i-1).get(j-1)+answer.get(i-1).get(j));
            }
        }

        return answer;
    }
}

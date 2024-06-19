package Programmers.level1.DFS;

import java.util.ArrayList;
import java.util.List;

public class _Combination4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        boolean[] visited = new boolean[n];

        //1. List<List<Integer>> 로 조합의 경우의 수 모두 반환
        // n개 중 2개를 뽑는 경우
        List<List<Integer>> comblist1 = combination1(arr, visited, 0, n ,2);
//        for(List<Integer> list : comblist1){
//            for(int val : list){
//                System.out.printf("%d ",val);
//            }
//            System.out.println();
//        }
        System.out.println(comblist1);
    }

    //백트래킹으로 구현
    private static List<List<Integer>> combination1(int[] arr, boolean[] visited, int start, int n, int r) {
        List<List<Integer>> comblist1 = new ArrayList<>();
        if(r == 0) {
            //comblist1에 추가
            addList(arr, visited, n, comblist1);
        }
        for(int i=start; i < n;i++) {
                    visited[i] = true;
                    comblist1.addAll(combination1(arr, visited, i+1, n, r-1));
                    visited[i] = false;
        }
        return comblist1;
    }

    private static void addList(int[] arr, boolean[] visited, int n, List<List<Integer>> comblist1) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(visited[i]) list.add(arr[i]);
        }
        comblist1.add(list);
    }

}

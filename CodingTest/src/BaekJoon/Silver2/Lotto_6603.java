package BaekJoon.Silver2;

import java.util.*;

public class Lotto_6603 {
    static int K;
    static int[] lotto;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            K = sc.nextInt();

            if(K==0) break;

            lotto = new int[K];

            for(int i=0;i<K;i++){
                lotto[i] = sc.nextInt();
            }
            visited = new boolean[K];

            comb(lotto, visited, 0, 6);
            System.out.println();
        }
    }

    private static void comb(int[] lotto, boolean[] visited, int start, int r){

        if(r==0){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<lotto.length;i++){
                if(visited[i]){
                    list.add(lotto[i]);
                }
            }
            Collections.sort(list);
            for(int li : list){
                System.out.print(li+" ");
            }
            System.out.println();
            return;
        }else {
            for (int i = start; i < lotto.length; i++) {
                visited[i] = true;
                comb(lotto, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}

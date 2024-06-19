package BaekJoon.Bronze2;

import java.util.Scanner;

public class BlackJack_2798 {
    //N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

    static boolean [] visited;
    static int M;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N(3 ≤ N ≤ 100)
        M = sc.nextInt(); // M(10 ≤ M ≤ 300,000)
        int [] cards = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            cards[i] = sc.nextInt();
        }
        sc.close();
        max = -1;
        comb(cards,visited,0,3);

        System.out.println(max);
    }

    private static void comb(int[] cards, boolean [] visited, int start, int r){

        if(r == 0){
            int sum = 0;
            for(int i=0;i<cards.length;i++){
                if(visited[i] == true){
                    sum+= cards[i];
                }
            }
            if(sum <= M && max < sum){
                max = sum;
            }
            return;
        }else{
            for(int i=start;i< cards.length;i++){
                visited[i] = true;
                comb(cards,visited,i+1,r-1);
                visited[i] = false;
            }
        }
    }
}

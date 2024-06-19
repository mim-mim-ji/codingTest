package BaekJoon.Gold5;

import java.util.*;

public class password_1759 {
    static boolean []visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //3 ≤ L ≤ C ≤ 15
        int L = sc.nextInt();
        int C = sc.nextInt();

        String [] st = new String[C];

        visited = new boolean[C];
        for(int i=0;i<C;i++){
            st[i] = sc.next();
        }
        Arrays.sort(st);
        comb(st,visited,0,L);

    }

    private static void comb(String[] st, boolean[] visited, int start, int r){

        if(r==0){
            String s = "";
            for(int i=0;i<st.length;i++){
                if(visited[i]){
                    s += st[i];
                }
            }
            char[] ch = s.toCharArray();
            int mo = 0;
            int ja = 0;
            for(char c : ch){
                if(c == 'a' || c == 'e'  || c == 'i'  || c == 'o'  || c == 'u' ){
                    mo++;
                }else{
                    ja++;
                }
            }
            if(mo >= 1 && ja >=2){
                System.out.println(s);
            }
            return;
        }else{
            for(int i=start;i<st.length;i++){
                visited[i] = true;
                comb(st,visited,i+1,r-1);
                visited[i] = false;
            }
        }
    }
}

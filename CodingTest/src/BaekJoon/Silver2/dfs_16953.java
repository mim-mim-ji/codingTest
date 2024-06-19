package BaekJoon.Silver2;

import java.util.Scanner;

public class dfs_16953 {
    //A->B
    //2를 곱하거나 뒤에 1 더하기
    //2 → 4 → 8 → 81 → 162
    //100 → 200 → 2001 → 4002 → 40021

    static int A;
    static int B;
    static int cnt=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        dfs(B);

        System.out.println(cnt);
    }

    private static void dfs(int B) {
        int result = 0;
        String s = String.valueOf(B);

        if(B < A){
            cnt = -1;
            return;
        }else if(B == A){
            return;
        }

        if(B % 2==0) {
            cnt++;
            result = B / 2;
            dfs(result);
        }else if(s.charAt(s.length()-1) == '1'){
            cnt++;
            result = Integer.parseInt(s.substring(0,s.length()-1));
            dfs(result);
        }else{
            cnt = -1;
            return;
        }
    }
}

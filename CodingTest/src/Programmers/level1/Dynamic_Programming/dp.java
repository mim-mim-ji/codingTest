package Programmers.level1.Dynamic_Programming;

import java.util.Arrays;

public class dp {

    //1,3,4 동전으로 N을 만들때 드는 동전의 최소 개수

    public static void main(String[] args) {

        int N = 6;

        int[] f = new int[N+1];

        /*
        i가 만들어지기 직전 상황
        1을 더해서 i가 되는 숫자 : i-1
        3을 더해서 i가 되는 숫자 : i-3
        4를 더해서 i가 되는 숫자 : i-4
         */

        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 1;
        f[4] = 1;

        //f[i] : 1,3,4의 합으로 i를 만들때 드는 동전의 최소 개수

        for(int i=5;i<= N;i++){
            f[i] = Math.min(Math.min(f[i-1],f[i-3]),f[i-4]) + 1;
        }

        System.out.println(Arrays.toString(f));
        System.out.println(f[N]);
    }
}

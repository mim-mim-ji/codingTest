package BaekJoon.Bronze1;

import java.util.Scanner;

/*
Mississipi -> ?
zZa -> Z
 */

public class 단어공부_1157{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        int[] cnt = new int[26];
        for(char c : arr){
            char c1 = Character.toUpperCase(c);
            cnt[c1 - 'A']++;
        }

        char answer = '?';
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cnt.length; i++) {
            if(max == cnt[i]){
                answer = '?';
            }else if(max < cnt[i]){
                max = Math.max(max, cnt[i]);
                answer = (char)(i + 'A');
            }
        }
        System.out.println(answer);
    }
}

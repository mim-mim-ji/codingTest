package BaekJoon.Bronze2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alphabet_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        //영어소문자 아스키코드 97~122
        sc.close();

        solution(S);
    }

    private static void solution(String s) {
        int [] arr = new int[26];
        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            int temp = (int)s.charAt(i) - 97;

            if(! list.contains(temp)){
                arr[temp] = i;
            }
            list.add(temp);
        }
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
}

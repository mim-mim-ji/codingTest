package Programmers.level0;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        int index = 0;
        while(true) {
            int ran = (int)(Math.random()*45+1); //1 ~ 45 난수생성
            int i=0;
            //같은건 빼기
            for(i=0;i<index;i++) {
                if(lotto[i]==ran) {
                    break;
                }
            }
            if(i==index) {
                lotto[index++] = ran;
            }
            if(index==6) {
                break;
            }
        }
        System.out.println(Arrays.toString(lotto));

    }
}

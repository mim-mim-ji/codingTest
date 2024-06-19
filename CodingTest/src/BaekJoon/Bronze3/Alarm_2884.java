package BaekJoon.Bronze3;

import java.util.Scanner;

public class Alarm_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = 0;
        int M = 0;
        //0 ≤ H ≤ 23, 0 ≤ M ≤ 59
        //H시 M분

        H = sc.nextInt();
        M = sc.nextInt();

        // 10 10 -> 9 25
        solution(H,M);
    }
    public static void solution(int H, int M) {

        if(M < 45){
            M = 60 - (45 - M);
            H--;
            if(H < 0) H = 23;
        }else{
            M = M - 45;
        }
        System.out.println(H);
        System.out.println(M);
    }
}

package BaekJoon.Bronze3;

import java.util.Scanner;

public class 소금폭탄_13223 {

    /*
    첫번째랑 두번째 시간 차이
    12:34:56
    14:36:22
    => 02:01:26
    hh:mm:ss

    20:00:00
    04:00:00
    1. 4 - 20 = -16
        24 - 16 = 8
    2. 22 - 56 = -34
        60 - 34 = 26
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] now = sc.nextLine().split(":");
        String[] after = sc.nextLine().split(":");

        System.out.println(solution(now, after));
        System.out.println(solution2(now, after));
    }

    private static String solution(String[] now, String[] after) {
        int next = 0;
        int[] result = new int[3];

        for (int i = 2; i > -1; i--) {
            int dif = Integer.parseInt(after[i]) - Integer.parseInt(now[i]) - next;
            next = 0;
            if (dif < 0) {
                if (i == 0)
                    dif += 24;
                else
                    dif += 60;
                next++;
            }
            result[i] = dif;
        }
        // 시, 분, 초가 모두 0이면 24:00:00으로 바꿔줌
        if (result[0] == 0 && result[1] == 0 && result[2] == 0) {
            result[0] = 24;
        }
        return String.format("%02d:%02d:%02d", result[0], result[1], result[2]);
    }

    private static String solution2(String[] now, String[] after) {
        int nowSec = toSecond(now);
        int afterSec = toSecond(after);
        int dif = afterSec - nowSec;

        if (dif <= 0)
            dif += 24 * 60 * 60;

        int h = dif / 3600;
        int m = (dif % 3600) / 60;
        int s = dif % 60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    private static int toSecond(String[] time) {
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);
        return h * 3600 + m * 60 + s;
    }

}

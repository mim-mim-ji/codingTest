package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색_1543 {

    /*
    ababababa
    aba
    -> 2
    최대 몇 번 중복되지 않게 등장?
    a a a a a
    a a
    -> 2
    ababababa
    ababa
    -> 1
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            System.out.println(solution3(s1, s2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(String s1, String s2) {
        int cnt = 0;
        int startIdx = 0;
        while (true) {
            int findIdx = s1.indexOf(s2, startIdx); //찾는 단어가 처음 등장하는 인덱스 구하기
            if (findIdx < 0)
                break;
            cnt++;
            startIdx += findIdx + s2.length();
        }

        System.out.println(cnt);
    }

    private static void solution2(String s1, String s2) {
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j) || (i + j) >= s1.length()) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                cnt++;
            i += s2.length() - 1;
        }

        System.out.println(cnt);
    }

    private static int solution3(String s1, String s2) {
        int cnt = 0;

        while (s1.contains(s2)) {
            s1 = s1.substring(s1.indexOf(s2) + s2.length());
            cnt++;
        }
        return cnt;
    }

}

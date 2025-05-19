package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class 단어정렬_1181 {

    /*
    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

    길이가 짧은 것부터
    길이가 같으면 사전 순으로
    단, 중복된 단어는 하나만 남기고 제거해야 한다.
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            //            List<String> words = new ArrayList<>();
            //            for (int i = 0; i < N; i++) {
            //                String s = br.readLine();
            //                if (words.contains(s)) {
            //                    continue;
            //                }
            //                words.add(s);
            //            }
            Set<String> wordSet = new LinkedHashSet<>();
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                wordSet.add(s);
            }
            List<String> words = new ArrayList<>(wordSet);

            words.sort((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            });

            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append("\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

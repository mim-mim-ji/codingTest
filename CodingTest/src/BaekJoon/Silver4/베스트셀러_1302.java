package BaekJoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 베스트셀러_1302 {
    /*
    첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다.
    책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
9
table
chair
table
table
lamp
door
lamp
table
chair
     */

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> bookMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String book = br.readLine();
                bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
            }

            String result = "";
            int max = 0;
            for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    result = entry.getKey();
                } else if (max == entry.getValue()) {
                    if (entry.getKey().compareTo(result) < 0) {
                        result = entry.getKey();
                    }
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

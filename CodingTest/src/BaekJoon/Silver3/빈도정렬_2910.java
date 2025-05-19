package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도정렬_2910 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            Map<Integer, Integer> countMap = new HashMap<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i] = temp;
                countMap.put(temp, countMap.getOrDefault(temp, 0) + 1);
                indexMap.put(temp, indexMap.getOrDefault(temp, i));
            }

            List<Number> numbers = new ArrayList<>();
            for (int number : arr) {
                numbers.add(new Number(number, countMap.get(number), indexMap.get(number)));
            }
            Collections.sort(numbers);

            StringBuilder sb = new StringBuilder();

            for (Number number : numbers) {
                sb.append(number.getNumber()).append(' ');
            }

            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Number implements Comparable<Number> {

        private int num;
        private int count;
        private int idx;

        public Number(int num, int count, int idx) {
            this.num = num;
            this.count = count;
            this.idx = idx;
        }

        public int getNumber() {
            return num;
        }

        @Override
        public int compareTo(Number o) {
            if (this.count == o.count) {
                return this.idx - o.idx;
            }
            return o.count - this.count;
        }

    }

}

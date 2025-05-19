package BaekJoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 좌표압축_18870 {

    /*
    수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
    X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
    1 ≤ N ≤ 1,000,000
    -109 ≤ Xi ≤ 109

5
2 4 -10 4 -9
-> 2 3 0 3 1
=> 자기보다 작은 수가 몇개인가?
2: -10, -9 -> 2
4: 2, -10, -9 -> 3
-10: 자기보다 작은 수 없으므로 -> 0
-10 -9 2 4
         */

    /*
        TreeSet 쓰니까 시간초과 남(≤ N ≤ 1,000,000)
    ->  TreeSet은 내부적으로 Red-Black Tree로 동작 → 삽입/탐색에 O(log N) 걸림
        추가로 HashMap을 사용하면 logN이 누적되어서 시간초과 남

     */
    //    public static void main(String[] args) {
    //        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    //            int N = Integer.parseInt(br.readLine());
    //            Map<Integer, Integer> map = new HashMap<>(); //압축값 저장 map
    //            int[] arr = new int[N]; //기존 배열
    //            Set<Integer> set = new TreeSet<>(); //중복제거할 set - 오름차순 정렬
    //
    //            StringTokenizer st = new StringTokenizer(br.readLine());
    //            for (int i = 0; i < N; i++) {
    //                int num = Integer.parseInt(st.nextToken());
    //                set.add(num);
    //                arr[i] = num;
    //            }
    //
    //            int idx = 0;
    //            for (int num : set) {
    //                map.put(num, idx++);
    //            }
    //
    //            StringBuilder stringBuilder = new StringBuilder();
    //            for (int num : arr) {
    //                stringBuilder.append(map.get(num)).append(" ");
    //            }
    //
    //            System.out.println(stringBuilder);
    //
    //        } catch (IOException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>(); //압축값 저장 map
            int[] arr = new int[N]; //기존 배열
            int[] sorted = new int[N]; //정렬한 배열

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(input[i]);
                arr[i] = num;
                sorted[i] = num;
            }

            Arrays.sort(sorted);

            int idx = 0;
            for (int x : sorted) {
                if (!map.containsKey(x)) {
                    map.put(x, idx++);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int num : arr) {
                stringBuilder.append(map.get(num)).append(" ");
            }

            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

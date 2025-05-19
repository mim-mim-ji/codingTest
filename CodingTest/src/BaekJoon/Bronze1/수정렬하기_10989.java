package BaekJoon.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기_10989 {
    /*
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
    N(1 ≤ N ≤ 10,000,000)
    N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
     */

    // 삽입정렬 사용 => 삽입정렬은 N이 작을 때는 괜찮지만, N = 10,000,000이면 절대 쓰면 안 돼.
    // 삽입정렬 O(N²) 시간 복잡도
    //    public static void main(String[] args) throws IOException {
    //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //        int N = Integer.parseInt(br.readLine());
    //        int[] arr = new int[N];
    //        arr[0] = Integer.parseInt(br.readLine());
    //
    //        for (int i = 1; i < N; i++) {
    //            int current = Integer.parseInt(br.readLine());
    //
    //            int k = i - 1; // 그 전까지 정렬되어 있다고 가정
    //
    //            // 정렬된 영역을 오른쪽으로 밀면서 삽입할 위치 찾기
    //            while (k >= 0 && arr[k] > current) {
    //                arr[k + 1] = arr[k];
    //                k--;
    //            }
    //            // current가 들어갈 자리를 찾았으니 삽입
    //            arr[k + 1] = current;
    //        }
    //        System.out.println(Arrays.toString(arr));
    //    }

    //계수정렬
    //핵심 전략: 숫자의 빈도만 저장해서 정렬하지 않고 출력
    //count[i]는 숫자 i가 몇 번 등장했는지 저장함
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[10001];

            for (int i = 0; i < N; i++) {
                count[Integer.parseInt(br.readLine())]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 10000; i++) {
                while (count[i]-- > 0) {
                    sb.append(i).append('\n');
                }
            }
            System.out.println(sb);
        }

    }

}

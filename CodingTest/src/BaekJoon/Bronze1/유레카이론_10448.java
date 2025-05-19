package BaekJoon.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 유레카이론_10448 {

    /*
    Tn = 1 + 2 + 3 + ... + n = n(n+1)/2
    T1 = 1
    T2 = 3
    4 = T1 + T2
    5 = T1 + T1 + T2
    6 = T2 + T2 or 6 = T3
    10 = T1 + T2 + T3 or 10 = T4
K가 정확히 3개의 삼각수의 합으로 표현될수 있다면 1을, 그렇지 않다면 0을 출력
K (3 ≤ K ≤ 1,000)

3
10
20
1000
=>
1
0
1

풀이)
1. 삼각수를 먼저 만들어 놓기
2. 3중 for문 돌려서 정답찾으면 return
     */
    static List<Integer> triangles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            for (int n = 1; ; n++) {
                int t = n * (n + 1) / 2;
                if (t > 1000)
                    break;
                triangles.add(t);
            }

            for (int i = 0; i < N; i++) {
                int K = Integer.parseInt(br.readLine());
                System.out.println(IsTriangle(K));
            }
        }
    }

    private static int IsTriangle(int num) {
        for (int i = 0; i < triangles.size(); i++) {
            for (int j = 0; j < triangles.size(); j++) {
                for (int k = 0; k < triangles.size(); k++) {
                    if (triangles.get(i) + triangles.get(j) + triangles.get(k) == num) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}

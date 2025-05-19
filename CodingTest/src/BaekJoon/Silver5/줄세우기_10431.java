package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기_10431 {
    /*
    4
1 900 901 902 903 904 905 906 907 908 909 910 911 912 913 914 915 916 917 918 919
2 919 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900
3 901 902 903 904 905 906 907 908 909 910 911 912 913 914 915 916 917 918 919 900
4 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900 919

자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다. 이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.

1 0
2 190
3 19
4 171
학생들이 뒤로 물러난 걸음 수의 총합 => 19의 배수
     */

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int P = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int[] arr = new int[20];
                int num = Integer.parseInt(st.nextToken());
                int cnt = 0;

                for (int j = 0; j < 20; j++) {
                    int current = Integer.parseInt(st.nextToken());

                    int k = j - 1;
                    while (k >= 0 && arr[k] > current) {
                        arr[k + 1] = arr[k];
                        cnt++;
                        k--;
                    }
                    arr[k + 1] = current;
                }
                System.out.println(num + " " + cnt);
            }

        }

    }

}

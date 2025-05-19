package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {

    /*
    n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
    ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
    자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

    첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

9
5 12 7 10 9 1 2 3 11
13
=> 3


1 2 3 5 7 9 10 11 12
투포인터
left = 0
right = n-1
arr[left] + arr[right] = sum
 sum = x -> count++, left++, right--
 sum < x -> left++
 sum > x -> right--

     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int x = Integer.parseInt(br.readLine());

            System.out.println(twoPointer(arr, x));
        }
    }

    private static int twoPointer(int[] arr, int x) {
        int count = 0;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

}

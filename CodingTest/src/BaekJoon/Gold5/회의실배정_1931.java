package BaekJoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    /*
    한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
    각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
    단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
->첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
->4
(1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.

끝나는 시간 오름차순 정렬, 같으면 시작시간 빠른순
1 4
5 7
8 11
12 14

현재회의랑 다음회의랑 비교
-> 이전회의 종료시간 <= 다음회의 시작시간
-> count++
-> 다음회의로 이동
만일 시작시간 = 끝나는시간이면 count++하고 다음회의로 넘어가기

     */

    static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.add(new Meeting(start, end));
            }

            Collections.sort(meetings);

            int count = 0;
            int lastEndTime = 0; //종료시간 초기화
            for (Meeting meeting : meetings) {
                if (meeting.start >= lastEndTime) {
                    count++;
                    lastEndTime = meeting.end;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Meeting implements Comparable<Meeting> {

        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

    }

}

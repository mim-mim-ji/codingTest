package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ALPS식투표_2817 {

    /*
    우선 대회 참가자들은  "수고비를 받을 가치가 있는 스태프" 한 명을 선택해 투표를 한다. (참가자가 투표를 하지 않을 수도 있다.)
    이 투표결과, 전체 대회 참가자의 5% 미만의 득표를 얻은 사람은 열심히 일을 하지 않은 스태프이므로 후보에서 제외해버린다.
    이제 남은 스태프마다, 받은 득표수를 1로 나눈 값, 2로 나눈 값... 14로 나눈 값을 구한다. 이렇게 구한 14개의 실수가 그 스태프의 '점수'들이 된다.
    이렇게 14 * (후보 스태프의 명수) 개의 실수를 가진 점수집합을 얻을 수 있다.
    이 점수집합에서의 값에 따라 각 스태프들에게 14개의 칩을 나눠주는데,
    집합 내에서 가장 큰 점수를 가진 후보 스태프에게 1개의 칩을 주고, 집합 내에서 두 번째로 점수가 큰 후보 스태프에게 1개의 칩을, ... 14번째로 점수가 큰 후보 스태프에게 1개의 칩을 준다.
    최종적으로 스태프마다 득표수에 따라 칩의 개수가 다르게 지급될 것이다. 이것이 바로 ALPS식 투표이다. 성진은 스태프가 가진 칩의 개수에 비례해서 수고비를 지급하기로 했다.
    신비롭게도, 점수집합에 있는 실수들은 항상 서로 다르도록 투표결과가 나온다고 한다.
    우리는 각 스태프마다 몇개의 표를 얻었는지를 알고있다. 이 득표수를 토대로, ALPS식 투표를 수행하게 된 후, 각 스태프가 받을 칩의 개수를 구하는 프로그램을 작성하시오.
235217 : 참가자들의 수 X( 1 ≤ X ≤ 2,500,000)
3 : 참가한 스태프의 수 N (0 ≤ N ≤ 10)
A 107382
C 18059
B 43265
->
A 9
B 4
C 1
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int X = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            List<Staff> staffList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int voteCount = Integer.parseInt(st.nextToken());

                if (X * 0.05 > voteCount) {
                    continue;
                }
                staffList.add(new Staff(voteCount, name));
            }

            List<Score> scoreList = new ArrayList<>();

            //득표수를 1~14로 나눈 값 추가
            for (int i = 1; i <= 14; i++) {
                for (Staff staff : staffList) {
                    scoreList.add(new Score((float)staff.vote / i, staff.name));
                }
            }

            scoreList.sort((o1, o2) -> Float.compare(o2.votes, o1.votes));

            for (int i = 0; i < 14; i++) {
                for (Staff staff : staffList) {
                    if (scoreList.get(i).name.equals(staff.name)) {
                        staff.chip++;
                    }
                }
            }

            staffList.sort(Comparator.comparing(o -> o.name));

            for (Staff staff : staffList) {
                System.out.println(staff.name + " " + staff.chip);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static class Staff {

        int vote;
        int chip = 0;
        String name;

        public Staff(int vote, String name) {
            this.vote = vote;
            this.name = name;
        }

    }

    static class Score {

        float votes;
        String name;

        public Score(float votes, String name) {
            this.votes = votes;
            this.name = name;
        }

    }

}

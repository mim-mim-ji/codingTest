package BaekJoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사에있는사람_7785 {

    /*
    첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106)
    다음 n개의 줄에는 출입 기록이 순서대로 주어지며,
    각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
    "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
4
Baha enter
Askar enter
Baha leave
Artem enter
->
Askar
Artem
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Set<String> staffSet = new HashSet<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String log = st.nextToken();

                if (log.equals("enter")) {
                    staffSet.add(name);
                } else {
                    staffSet.remove(name);
                }
            }

            List<String> staffList = new ArrayList<>(staffSet);
            Collections.sort(staffList, Collections.reverseOrder());
            for (String staff : staffList) {
                System.out.println(staff);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

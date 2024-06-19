package Programmers.level3;

import java.util.*;

public class travelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //answer = "ICN", "JFK", "HND", "IAD"

        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        System.out.println(Arrays.toString(solution(tickets2)));
    }

    static boolean[] visited; // 티켓 사용 여부
    static List<String> list; // 티켓을 사용하는 경로의 경우의 수

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs("ICN", "ICN", visited, tickets, 0);

        Collections.sort(list);

        answer = list.get(0).split(" ");
        System.out.println(list);
        return answer;
    }

    private static void dfs(String start, String route, boolean[] visited, String[][] tickets, int r) {
        if (r == tickets.length) {
            list.add(route);
            return;
        }
            for (int i = 0; i < tickets.length; i++) {
                // 티켓을 아직 사용하지 않았고 해당 티켓의 출발지가 현재 위치와 같은 경우
                if (tickets[i][0].equals(start) && !visited[i]) {
                    visited[i] = true;
                    dfs(tickets[i][1],route+" "+tickets[i][1], visited, tickets,r+1);
                    visited[i] = false;
                }
            }
    }
}
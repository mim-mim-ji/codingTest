package Programmers.level1;

import java.util.*;

public class RunRace {
    public static void main(String[] args) {
        String[] players={"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players,callings)));
        //["mumu", "kai", "mine", "soe", "poe"]
    }
    public static String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }

        for(int i=0;i<callings.length;i++){
            int curIdx = map.get(callings[i]);
            //앞서가던 선수
            String frontPlayer = players[curIdx-1];

            players[curIdx-1] = callings[i];
            players[curIdx] = frontPlayer;

            map.put(callings[i],curIdx-1);
            map.put(frontPlayer,curIdx);
        }

        return players;
    }
}

package Programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenKakao {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }
    public static String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        //map의 key는 중복될 수 없음!!

        int index = 0;
        for(String rec : record) {
            String[] arr = rec.split(" ");

            String condition = arr[0];
            String key = arr[1];

            if (!condition.equals("Leave")) {
                map.put(key, arr[2]);
            }
            if (!condition.equals("Change")) index++;
        }
        System.out.println(map);
        String[] answer = new String [index];
        int i=0;
        for(String rec : record){
            String condition = rec.split(" ")[0];
            String key = rec.split(" ")[1];

            if(condition.equals("Enter")){
                answer[i++] = map.get(key)+"님이 들어왔습니다.";
            }else if(condition.equals("Leave")){
                answer[i++] = map.get(key)+"님이 들어왔습니다.";
            }
        }

        return answer;
    }
}

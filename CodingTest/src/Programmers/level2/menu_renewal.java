package Programmers.level2;
import java.util.*;
import java.util.Map.Entry;

public class menu_renewal {
    static boolean[] visited;

    public static void main(String[] args) {
        String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course = {2,3,4};
        System.out.println(solution(orders,course));
    }

    public static ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        //orders의 각 원소들을 오름차순 정령
        for(int i=0;i<orders.length;i++){
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }

        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE; //구한 조합들 중 가장 많이 주문된 횟수 저장

            for(int j=0;j<orders.length;j++){
                if(course[i]<=orders[j].length()){
                    //orders[j]문자열에서 문자 course[i]개 뽑기
                    visited = new boolean[orders[j].length()];
                    comb(orders[j],visited,0,course[i]);

                }
            }

            //가장 많이 주문된 횟수를 max에 저장
            for(Entry<String,Integer>entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }

            for(Entry<String,Integer>entry : map.entrySet()){
                if(max >= 2 && entry.getValue() == max){
                    answer.add(entry.getKey());
                }
            }

        }
        Collections.sort(answer);
        return answer;
    }

    static Map<String,Integer> map;

    private static void comb(String order,boolean[] visited,int start,int r){
        if(r == 0){
            String temp = "";
            for(int i=0;i< order.length();i++){
                if(visited[i]){
                    temp += String.valueOf(order.charAt(i));
                }
            }
            map.put(temp,map.getOrDefault(temp,0)+1);
            return;
        }else{
            for(int i= start;i<order.length();i++){
                visited[i] = true;
                comb(order,visited,i+1,r-1);
                visited[i] = false;
            }
        }
    }
}

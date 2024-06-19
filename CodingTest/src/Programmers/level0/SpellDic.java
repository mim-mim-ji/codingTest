package Programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class SpellDic {

    public static void main(String[] args) {
       String [] spell = {"z", "d", "x"};
       String [] dic = {"def", "dww", "dzx", "loveaw"};
        System.out.println(solution(spell,dic));
        System.out.println(solution2(spell,dic));
    }

    static boolean [] visited;
    static List<String> list;
    public static int solution(String[] spell, String[] dic) {
        int answer = 2;

        visited = new boolean[spell.length];
        String [] output = new String[spell.length];
        list = new ArrayList<>();

        dfs(spell, output, visited, 0, spell.length);

        System.out.println(list);

        for(String st : list){
            for(String di : dic){
                if(st.equals(di)) answer = 1;
            }
        }

        return answer;
    }

    private static void dfs(String[] spell, String [] output, boolean[] visited, int depth, int r) {
        if(depth==r){
            String str = "";
            for(int i=0;i<r;i++){
                str += output[i];
            }
            list.add(str);
            return;
        }else{
            for(int i=0;i<spell.length;i++){
                if(!visited[i]){
                    visited[i] = true;
                    output[depth] = spell[i];
                    dfs(spell,output, visited,depth+1,r);
                    visited[i] = false;
                }
            }
        }
    }

    public static int solution2(String[] spell, String[] dic) {
        int answer = 2;
        for(String st : dic){
            int count = 0;
            for(int i=0;i<spell.length;i++){
                if(st.contains(spell[i])) count++;
            }
            if(count == spell.length) answer = 1;
        }

        return answer;
    }
}

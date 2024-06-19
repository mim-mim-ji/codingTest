package Programmers.level1.DFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17")); //7,17,71
        System.out.println(s.solution("011")); //11,101
    }
    //각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성하라
    static class Solution {
        boolean[] check;
        int len;
        Map<Integer,Boolean> map; //만든 소수를 넣을 맵

        public int solution(String numbers) {
            len  = numbers.length();
            check = new boolean[len];
            map = new HashMap<>();

            String[] card = numbers.split("");//각 원소들을 하나씩 배열에 넣기
            Arrays.sort(card, Collections.reverseOrder());//내림차순 정렬

            search(card,"");
            System.out.println(map);
            return map.size();
        }

        private void search(String[] card, String str) {
            if(len == str.length()) return;

            for(int i=0;i<card.length;i++){
                if(!check[i]){
                    check[i] = true;
                    String temp = str + card[i];
                    System.out.println(temp);
                    int num = Integer.parseInt(temp);
                    boolean isPrime = false;
                    if(num >= 2) isPrime = isPrimeNumber(temp); //소수인지 아닌지 판별
                    //isPrime값이 true면 소수 + map에 없는 경우
                    if(isPrime && !map.containsKey(num)) map.put(num,true);

                    search(card,temp);
                    check[i] = false;
                }
            }
        }

        private boolean isPrimeNumber(String temp) {
            int num = Integer.parseInt(temp);
            for(int i=2; i<=Math.sqrt(num);i++){
                if(num % i==0) return false;
            }
            return true;
        }
    }
}

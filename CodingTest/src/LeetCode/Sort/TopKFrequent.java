package LeetCode.Sort;

import java.util.*;

public class TopKFrequent {
    /*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    (가장 많이 등장하는 k 개의 원소를 반환하라)
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums,k);
    }

    public static int[] topKFrequent(int[]nums, int k){
        Map<Integer,Integer>map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Pair> list = new ArrayList<>();

        for(int key : map.keySet()){
            list.add(new Pair(key, map.get(key)));
        }

        Collections.sort(list);

        int[] answer = new int[k];

        for(int i=0;i<k;i++){
            answer[i] = list.get(i).num;
        }
        return answer;
    }

    static class Pair implements Comparable<Pair>{
        int num;
        int cnt;

        Pair(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o){
            return o.cnt - this.cnt;
        }
    }
}

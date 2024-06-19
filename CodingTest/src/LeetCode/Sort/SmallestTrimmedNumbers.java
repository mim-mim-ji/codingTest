package LeetCode.Sort;

import java.util.*;

public class SmallestTrimmedNumbers {

    public static void main(String[] args) {
        String[] nums = {"102","473","251","814"};
        int[][] queries = {{1,1},{2,3},{4,2},{1,2}};
        int [] answer = smallestTrimmedNumbers(nums,queries);
        System.out.println(Arrays.toString(answer));
    }

    private static class Pair{
        String s;
        int idx;
        Pair(String s, int idx){
            this.s = s;
            this.idx = idx;
        }
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries){
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for(int i=0; i < nums.length ; i++){
            String str = nums[i];
            int n = str.length();
            int l = n;
            for(int j=0; j < n ; j++){
                map.putIfAbsent(l, new ArrayList<>());
                Pair pr = new Pair(str.substring(j), i);
                map.get(l--).add(pr);
            }
        }
        System.out.println(map);

        int [] ans = new int[queries.length];
        int index = 0;
        for(int [] query : queries){
            int kthEl = query[0];
            int key = query[1];

            List<Pair> list = map.get(key);
            Collections.sort(list, (p1, p2) -> {
                if(p1.s.equals(p2.s)) {
                    return p1.idx - p2.idx;
                } else {
                    return p1.s.compareTo(p2.s);
                }
            });
            ans[index++] = list.get(kthEl - 1).idx;
        }
        return ans;
    }

//    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries){
//
//       if(nums.length == 0){
//           return new int [0];
//       }
//
//       int [] result = new int[queries.length];
//       int strLen = nums[0].length();
//       int [] index = new int[1];
//
//       PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
//            for(int i=index[0]; i<strLen; i++){
//                if(nums[a].charAt(i) != nums[b].charAt(i)){
//                    return nums[b].charAt(i) - nums[a].charAt(i);
//                }
//            }
//           return b-a;
//       });
//
//       for(int i=0; i < queries.length ; i++){
//
//           index[0] = strLen - queries[i][1];
//           queue.clear();
//
//           for(int j=0; j < nums.length ; j++){
//               queue.add(j);
//               if(queue.size() > queries[i][0]) queue.poll();
//           }
//           result[i] = queue.poll();
//       }
//
//        return result;
//    }
}

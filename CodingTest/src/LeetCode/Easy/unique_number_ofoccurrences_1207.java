package LeetCode.Easy;

import java.util.*;

public class unique_number_ofoccurrences_1207 {

    public static void main(String[] args) {
        int[]arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
        System.out.println(uniqueOccurrences2(arr));
        System.out.println(uniqueOccurrences3(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        Collection <Integer> val = map.values();
        List<Integer> list = new ArrayList<>(val);
        Set<Integer> set = new HashSet<>(val);

        return set.size()==list.size()?true:false;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        Set<Integer> set = new HashSet<>(map.values());

        return set.size()==map.size()?true:false;
    }

    public static boolean uniqueOccurrences3(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return map.values().stream().distinct().count() == map.values().size();
    }
}



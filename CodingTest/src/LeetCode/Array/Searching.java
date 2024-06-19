package LeetCode.Array;

import java.util.*;

public class Searching {
    /*
    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
     */
    public static void main(String[] args) {
        int [] arr = {10,2,5,3};
        System.out.println(checkIfExist2(arr)) ;
    }

    //1. Brute force approach:
    public static boolean checkIfExist1(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i!=j && arr[i] == 2 * arr[j])
                    return true;
            }
        }
        return false;
    }

    //2. Binary Search
    public static boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int target = 2 * arr[i];
            int left = 0;
            int right = arr.length-1;

            while(left <= right){
                int mid = (left + right) / 2;
                if(arr[mid]==target && mid != i) return true;
                if(arr[mid] < target) left = mid + 1;
                else right = mid-1;
            }
        }
        return false;
    }

    //3. Using HashMap:
    public static boolean checkIfExist3(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(2*arr[i]) && map.get(2*arr[i])!=i){
                return true;
            }
        }

        return false;
    }

    //4. Using HashSet: 중복 허용X
    public static boolean checkIfExist4(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            if(set.contains(num*2) || (num%2==0 && set.contains(num/2))){
                return true;
            }
            set.add(num);
        }
        return false;
    }

}

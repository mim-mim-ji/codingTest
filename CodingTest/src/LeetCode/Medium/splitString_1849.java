package LeetCode.Medium;

import java.util.Arrays;

public class splitString_1849 {
    /*
 Check if we can split s into two or more non-empty substrings such that the numerical values of the substrings are in descending order
 and the difference between numerical values of every two adjacent substrings is equal to 1.

 Return true if it is possible to split s as described above, or false otherwise.

 Input: s = "1234"
Output: false
Explanation: There is no valid way to split s.

Input: s = "050043"
Output: true
Explanation: s can be split into ["05", "004", "3"] with numerical values [5,4,3].

Input: s = "9080701"
Output: false
Explanation: There is no valid way to split s.


The values are in descending order with adjacent values differing by 1.
     */

    public static void main(String[] args) {
        String s = "050043";
        System.out.println(splitString(s));

    }

    public static boolean splitString(String s) {
        return dfs(s,0,-1,0);
    }

    private static boolean dfs(String s,int index, long prev, int count) {
        System.out.println(s+" "+ index+" "+prev+" "+count);
        if(index >= s.length()){
            if(count>=2) return true;
            return false;
        }

        long curr = 0;
        for(int i=index; i<s.length();i++){
            curr = curr * 10 + s.charAt(i) - '0'; //s.chartAt(i)-'0'은 아스키코드를 사용해서 정수로 만들어주는 역할
            System.out.println(prev +" "+ curr);
            if(prev == -1 || (prev - curr) == 1){ //curr = prev -1 을 충족해야함
                if(dfs(s, i+1, curr, count+1)){
                    return true;
                }
            }
        }
        return false;

    }
}

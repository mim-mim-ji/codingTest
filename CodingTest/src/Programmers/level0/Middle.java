package Programmers.level0;

import java.util.ArrayList;
import java.util.Collections;

public class Middle {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
       // System.out.println(solution(a,b));
    }

    public static int solution(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int a : array){
            arrayList.add(a);
        }
        //리스트 정렬
        Collections.sort(arrayList);
        int answer = arrayList.get(array.length /2);

//        // 내림차순으로 정렬
//        Collections.sort(arrayList, Collections.reverseOrder());
//        // 대소문자 구분없이 오름차순
//        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
//        // 대소문자 구분없이 내림차순
//        Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        return answer;
    }



}

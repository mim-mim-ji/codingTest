package Programmers.level1;

import java.text.ParseException;
import java.util.*;

public class privaciesTerms {

    /*
    고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다.
    약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
    당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다.
    수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
    모든 달은 28일까지 있다고 가정합니다.
     */

    public static void main(String[] args) throws ParseException {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today,terms,privacies)));

    }

    public static int[] solution (String today, String[] terms, String[] privacies)throws ParseException {

        String[] ar = today.split("[.]");
        int todayDays = 0;
        for(int i=0;i<ar.length;i++){
            todayDays = (Integer.parseInt(ar[0]) * 12 * 28) + (Integer.parseInt(ar[1]) * 28) + (Integer.parseInt(ar[2]));
        }

        Map<String,Integer> map = new HashMap<>();

        for(String term : terms){
            String [] arr = term.split(" ");
            map.put(arr[0],Integer.parseInt(arr[1]));
        }

        int days = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i< privacies.length;i++){

            String [] term = privacies[i].split(" ");
            String [] newPrivacy = term[0].split("[.]");

            int month = map.get(term[1]);

            //0년 1월 1일 기준 몇 번째 날짜인지 계산
            for(int j=0;j < newPrivacy.length;j++){
                days = (Integer.parseInt(newPrivacy[0]) * 12 * 28) + (Integer.parseInt(newPrivacy[1]) * 28) + (Integer.parseInt(newPrivacy[2]));
            }
            days += month * 28;

            int dif = todayDays - days;

            if(dif >= 0){
                list.add(i+1);
            }
            System.out.println(dif);
        }

        //int[] answer = new int[list.size()];

//        for(int i=0;i<list.size();i++){
//            answer[i] = list.get(i);
//        }

        //List에 받은 자료형은 Wrapper객체인 Integer이므로 Primitive 타입인 int 배열로 만들기 위해 형변환해줌(integer -> integer)
        return list.stream().mapToInt(integer -> integer).toArray();
    }
}

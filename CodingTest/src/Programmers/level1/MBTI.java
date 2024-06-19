package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class MBTI {
    /*
    survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
    survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.

    지표 번호	성격 유형
    1번 지표	라이언형(R), 튜브형(T)
    2번 지표	콘형(C), 프로도형(F)
    3번 지표	제이지형(J), 무지형(M)
    4번 지표	어피치형(A), 네오형(N)

    choices	뜻
    1	매우 비동의
    2	비동의
    3	약간 비동의
    4	모르겠음
    5	약간 동의
    6	동의
    7	매우 동의

    ex)4번지표
    선택지	    성격 유형 점수
    매우 비동의	네오형 3점
    비동의	    네오형 2점
    약간 비동의	네오형 1점
    모르겠음	    어떤 성격 유형도 점수를 얻지 않습니다
    약간 동의	    어피치형 1점
    동의	        어피치형 2점
    매우 동의	    어피치형 3점

    choices의 길이 = survey의 길이
     */
    public static void main(String[] args) {
        String [] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int [] choices = {5, 3, 2, 7, 5};
        //result = "TCMA"

        String [] survey1 = {"TR", "RT", "TR"};
        int [] choices1 = {7, 1, 3};
        //"RCJA"

        System.out.println(solution(survey,choices));
        System.out.println(solution(survey1,choices1));
    }
    public static  String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character,Integer> map = new HashMap<>();
        map.put('R',0); map.put('T',0);
        map.put('C',0); map.put('F',0);
        map.put('J',0); map.put('M',0);
        map.put('A',0); map.put('N',0);

        for(int i=0;i<choices.length;i++){

            //동의형 선택 -> survey[i]의 두번째 성격유형 선택
            if(choices[i]>4){
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+choices[i]-4);
            }else{
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+4-choices[i]);
            }
        }
        System.out.println(map);

        if(map.get('R') >= map.get('T')) answer+='R';
        else answer+='T';

        if(map.get('C') >= map.get('F')) answer+='C';
        else answer+='F';

        if(map.get('J') >= map.get('M')) answer+='J';
        else answer+='M';

        if(map.get('A') >= map.get('N')) answer+='A';
        else answer+='N';

        return answer;
    }
}

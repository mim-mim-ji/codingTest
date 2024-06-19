package Programmers.level2;

public class StringCompact {
    /*
    "aabbaccc"	7   2a 2b a 3c
    "ababcdcdababcdcd"	9    2ab 2cd 2ab 2cd    2ababcdcd
    "abcabcdede"	8   abcabc2de  2abcdede
    "abcabcabcabcdededededede"	14

    문자열을 2개 단위로 자르면 "ab ca bc ab ca bc 6de" 가 됩니다.
    문자열을 3개 단위로 자르면 "4abc ded ede ded ede" 가 됩니다.
    문자열을 4개 단위로 자르면 "abca bcab cabc 3dede" 가 됩니다.
    문자열을 6개 단위로 자를 경우 "2abcabc 2dedede"가 되며, 이때의 길이가 14로 가장 짧습니다.

    "xababcdcdababcdcd"	17

    문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
    따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.
    이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.

    압축할 문자열 s가 매개변수로 주어질 때,
    위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중
    가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
     */
    public static void main(String[] args) {

        String s1 = "aabbaccc";
        System.out.println("s1:"+solution(s1));
        String s2 = "ababcdcdababcdcd";
        System.out.println("s2:"+solution(s2));
//        String s3 = "abcabcdede";
//        System.out.println("s3:"+solution(s3));
//        String s4 = "abcabcabcabcdededededede";
//        System.out.println("s4:"+solution(s4));

    }
    public static int solution(String s) {
        int answer = s.length();

        for(int i=1;i<=s.length()/2;i++){
            //현재문자열
            String cur = "";
            //타겟문자 패턴설정
            String target = s.substring(0,i);
            //압축카운트
            int count = 1;
            StringBuilder sb = new StringBuilder();

            for(int start=i;start<=s.length();start +=i){
                //다음 자를 문자열의 길이가 단위보다 작으면 남은 글자를 저장
                if(start+i >= s.length()){
                    cur = s.substring(start,s.length());
                }else{
                    cur = s.substring(start,start+i);
                }

                //문자열이 같으면 압축카운트 증가
                if(cur.equals(target)) count++;
                else if(count==1){
                    sb.append(target);
                    target = cur;
                }else{ //다르면 압축카운트와 타겟추가하고 타겟변경 및 카운트 초기화
                    sb.append(count).append(target);
                    target = cur;
                    count = 1;
                }
            }
            //자르고 마지막 남은 문자열 추가
            if(i != target.length()) sb.append(target);

            answer = Math.min(answer,sb.toString().length());
        }


        return answer;
    }

}

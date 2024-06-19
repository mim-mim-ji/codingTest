package Programmers.level0;

import java.util.Arrays;

public class HiddenNumPlus {
    public static void main(String[] args) {
        String my_string ="aAb1B2cC34oOp";

        System.out.println(solution(my_string));
        System.out.println(solution2(my_string));
    }
    public static int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

        System.out.println(Arrays.toString(str));
        for(String s : str){
            if(!s.equals("")) answer += Integer.valueOf(s);
        }

        return answer;
    }

    public static int solution2(String my_string) {
        int answer = 0;
        String number = "";

        for(int i=0;i<my_string.length();i++){
            int num = my_string.charAt(i);
            if((num >= 65 && num <=90) || (num >= 97 && num <= 122)){ //문자일 경우
                if(number.length() == 0) continue;

                answer += Integer.parseInt(number);
                number = "";
            }else{
                if (i == my_string.length() - 1) {
                    number += my_string.charAt(i) +""; //문자로 변환
                    answer += Integer.parseInt(number);
                }else{
                    number += my_string.charAt(i)+""; //문자로 변환
                }
            }
            System.out.print(number+" ");
        }
        return answer;
    }

}

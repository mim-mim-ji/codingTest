package 개념정리.인프런.탐욕알고리즘;

import java.util.Scanner;

public class 그리디_1541 {
    /*
       가장 작은 최솟값을 만들기 위해서는 가능한 큰 수를 빼야함!
       마이너스 뒤에 숫자에 다시 마이너스가 나오기 전까지 괄호를 쳐서 모두 계산한 후 빼기

     */
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for(int i=0;i<str.length;i++){
            int temp = mySum(str[i]);
            if(i==0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }

    private static int mySum(String a) {
        int sum = 0;
        String[] temp = a.split("[+]");
        for(int i=0;i<temp.length;i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}

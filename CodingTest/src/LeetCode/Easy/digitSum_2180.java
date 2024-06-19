package LeetCode.Easy;

public class digitSum_2180 {
    /*
    Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
    The digit sum of a positive integer is the sum of all its digits.

    만일 123 이면 digit sum 은 1 + 2 + 3 = 6 이 되는 것

    이 문제는 주어진 num 까지 digit sum 이 짝수인 수의 개수를 구하는 것

     */
    public static void main(String[] args) {
        int num = 4;
        System.out.println(countEven(num));
    }

    public static int countEven(int num){
        int answer = 0;
        System.out.println("digit sum:");
        for(int i=1;i<=num;i++){
            int temp = 0;
            for(int j=i;j>0;j/=10){
                temp += j % 10;
            }
            System.out.print(temp + " ");
            if(temp % 2 ==0){
                answer++;
            }
        }
        System.out.println();
        return answer;
    }
}

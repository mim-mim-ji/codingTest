package Programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class Stock {
    public static void main(String[] args) {
        //가격이 떨어지지 않은 기간은 몇 초인지를 return
        int [] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution2(prices))); //4, 3, 1, 1, 0
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                answer[i]++;

                if(prices[j] < prices[i]){ //한번이라도 작아지면 break
                    break;
                }
            }
        }
        return answer;
    }
    public static int[] solution2(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int [] terms = new int[prices.length];

        stack.push(i);

        for(i = 1;i<prices.length;i++){
            while(! stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                terms[idx] = i - idx;
            }
            stack.push(i);
        }
        System.out.println(i);
        System.out.println(Arrays.toString(terms));

        while(! stack.isEmpty()){
            int idx = stack.pop();
            terms[idx] = i-idx-1;
        }
        return terms;
    }
}

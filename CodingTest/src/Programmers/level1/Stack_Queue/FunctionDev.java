package Programmers.level1.Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FunctionDev {
    //기능개발
    public static void main(String[] args) {

        int [] progresses = {93, 30, 55};
        int [] speeds = {1,30,5};
        solution(progresses,speeds);
        solution2(progresses,speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int [] answer = {};

        List<Integer> list = new ArrayList<>();

        int temp = 0;
        for(int i=0;i<progresses.length;i++){
            int current = Math.abs(progresses[i] - 100) / speeds[i];
            if(temp < current){
                temp = current;
                list.add(1);
            }else{
                list.set(list.size()-1,list.get(list.size()-1)+1);
            }
        }
        return answer;
    }

    private static int[] solution2(int[] progresses, int[] speeds) {
        int [] answer = {};

        Stack<Integer> stack = new Stack<>();

        for(int i=progresses.length-1;i>-1;i--){
            int current = Math.abs(progresses[i] - 100) / speeds[i];
            stack.push(current);
        }
        List<Integer> list = new ArrayList<>();
        while (! stack.isEmpty()){

            int count = 1; //count 초기화
            int top = stack.pop(); //stack 맨 위에를 미리 빼서 생각
            while (!stack.isEmpty() && top >= stack.peek()){
                count++;
                stack.pop();
            }
            list.add(count);
        }
        System.out.println(list);
        return answer;
    }

}

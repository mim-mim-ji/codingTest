package Programmers.level1.Stack_Queue;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {

        String s = ")()(";
        // (()(  )()(   : false
        System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') {
                stack.push(1);
            }
            if(c==')'){
                if(stack.isEmpty()) return false;
                stack.pop(); //'('를 빼줌
            }
        }
        return stack.isEmpty();
    }
    public static boolean solution2(String s) {
        boolean answer = false;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;

            //count < 0 이면 무조건 false
            if(count < 0 ) break;
        }
        if(count == 0) answer = true;

        return answer;
    }

    /*
        <leetcode> 20.valid-parentheses
        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
     */
    public static boolean solution3(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != ch){ //닫는 괄호가 없으면 false
                return false;
            }
        }
        return stack.isEmpty(); //stack이 비어있어야 세트가 맞게 들어간 것
    }
}

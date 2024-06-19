package Programmers.level1.Stack_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrinterQue {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        //높은숫자가 우선순위
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int pri : priorities) {
            que.offer(pri);
        }
        while (! que.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                //priorities의 i번째와 que의 가장 앞에 있는 수가 같으면
                if(priorities[i] == que.peek()){
                    if(i == location){
                        return answer;
                    }
                    que.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

}

package Programmers.level1.Stack_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Queue1 {
    public static void main(String[] args) {

        // 낮은 숫자가 우선 순위인 우선순위 큐
        PriorityQueue<Integer> que1 = new PriorityQueue<>();

        // 높은 숫자가 우선 순위인 우선순위 큐
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        que.add(3); que.add(5);
        que.add(2); que.add(1);
        que.add(4);

        while(! que.isEmpty()) {
            System.out.println(que.poll());
        }
    }
}

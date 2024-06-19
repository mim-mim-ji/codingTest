package Programmers.level1.Stack_Queue;

import java.util.*;

public class Queue2 {
    public static void main(String[] args) {
        PriorityQueue<String> que = new PriorityQueue<>(Collections.reverseOrder());

        que.offer("a");
        que.offer("b");
        que.offer("c");

        while(! que.isEmpty()){
            System.out.println(que.poll());
        }
    }
}

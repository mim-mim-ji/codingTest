package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter_933 {

    /*
        933. number-of-recent-calls
        RecentCounter 함수는 ping 함수가 호출될때마다 최근 3000밀리초 내에 발생한 요청 수를 리턴
        [t−3000, t] 사이의 요청 횟수를 반환

        Input
        ["RecentCounter", "ping", "ping", "ping", "ping"]
        [[], [1], [100], [3001], [3002]]

        Output
        [null, 1, 2, 3, 3]
     */


    Queue<Integer> queue = new LinkedList<>();
//    public RecentCounter() {
//        queue = new LinkedList<>();
//    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */

    public int ping(int t) {
        queue.add(t);
        int min = t-3000;
        while (queue.peek() < min){
            queue.remove();
        }
        return queue.size();
    }
}

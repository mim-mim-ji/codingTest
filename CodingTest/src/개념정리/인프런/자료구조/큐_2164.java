package 개념정리.인프런.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_2164 {
    /*
    가장위에 있는 카드를 가장 아래에 있는 카드 밑으로 옮기는 동작 = 선입선출

N = 6인경우
Queue: 1 2 3 4 5 6
front 1, rear 6
1) 가장 위 카드를 버림 = poll
    2 3 4 5 6
2) 그 다음 카드를 가장 아래에 있는 카드 밑으로 옮김 poll -> add
    3 4 5 6 2
3) 버림
    4 5 6 2
4) 옮김
    5 6 2 4
5) 버려
    6 2 4
6) 옮겨
    2 4 6
7) 버려
    4 6
8) 옮겨
    6 4
9) 버려
    4
    => 결과 4

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();

        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            myQueue.add(i);
        }

        while (myQueue.size()>1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }


}

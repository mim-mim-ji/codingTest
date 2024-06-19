package BaekJoon.Gold5;

import java.util.*;

public class sort_1461 {
    /*
    정리되어 있지 않은 책을 들고 원래 있던 자리에 모두 갖다 놓아야하는데, 이때 최소 이동 거리를 구해야했습니다.
    처음 생각할 수 있는 로직은 거리가 가까이 있는 M권의 책을 들고 이동하는 것입니다.
    다만, 문제의 예시에서 알 수 있듯이, M이 2이고, 음수 위치에 있는 책들이 [-39, -37, -29, -28, -6] 이라면 예외가 생깁니다.
    위의 로직을 따르면 (-6, -28), (-29, -37), (-39)를 가져갈텐데, 이것보다 (-6), (-28, -29), (-37, -39) 순서로 책을 가져가는 것이 더 이동거리가 짧습니다.
    따라서, 거리가 멀리 있는 M권의 책을 들고 이동해야 합니다.
    하지만, 음의 위치에 있는 책과 양의 위치에 있는 책을 동시에 들고 가면 어차피 한 권을 꽂고, 나머지 한 권을 꽂으려고 하면 원래 0 위치에 다시 오게 됩니다.
    따라서, 음의 위치에 있는 책을 담는 우선 순위 큐와 양의 위치에 있는 책을 담는 우선 순위 큐 2개를 정의하면 됩니다.
    이때, 정렬 기준은 절댓값 위치에 대해 내림차순 정렬하면 됩니다.
    그리고 (맨 꼭대기에 있는 값) x 2를 이동 거리로 취하고, M권의 책을 poll합니다. 이렇게 하면, 최소 이동 거리를 구할 수 있는데 한 가지 주의해야 합니다.
    모든 책을 가져다 놨으면 원래 0 위치로 돌아올 필요가 없으므로, ans에서 가장 먼 위치에 있는 책의 위치를 빼야 합니다.
    이 값을 빼는 이유는, 이 책을 가장 마지막에 두게 하게끔 조작하기위함입니다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        //내림차순 정렬
        PriorityQueue<Integer> posiQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negaQue = new PriorityQueue<>((p1, p2) -> p2 - p1);

        for(int i=0;i<N;i++){
            int temp = sc.nextInt();
            if(temp >0) posiQue.offer(temp);
            else negaQue.offer(Math.abs(temp));
        }

        //가장 멀리 있는 책의 위치 저장
        int max = 0;
        if(posiQue.isEmpty()){
            max = negaQue.peek();
        }else if(negaQue.isEmpty()){
            max = posiQue.peek();
        }else{
            max = Math.max(posiQue.peek(), negaQue.peek());
        }

        int answer = 0;

        while(! posiQue.isEmpty()){
            int temp = posiQue.poll();
            for(int i=0;i<M-1;i++){
                posiQue.poll();
                if(posiQue.isEmpty()) break;;
            }
            answer += temp * 2;
        }

        while(! negaQue.isEmpty()){
            int temp = negaQue.poll();
            //M권의 책을 poll
            for(int i=0;i<M-1;i++){
                negaQue.poll();
                if(negaQue.isEmpty()) break;
            }
            answer += temp * 2;
        }

        //가장 먼 곳에 있는 책을 마지막으로 갖다두기 위함
        answer -= max;

        System.out.println(answer);

    }
}

package 개념정리.인프런.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 절댓값힙_11286 {
    /*
    N 100,000 -> O(nlogn) 시간복잡도
    우선순위큐로 해결
    -> 절댓값 정렬이 필요하므로 우선순위큐의 정렬기준을 직접 정의해야함

    1) x = 0
    큐가 비어있으면 0 출력, 비어있지 않을때는 절댓값이 최소인 값을 출력
    절댓값이 같으면 음수먼저 출력
    2) x != 0
    add로 큐에 새로운 값을 추가하고 우선순위큐 정렬 기준으로 자동 정렬한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs){ //절댓값이 같으면 음수 우선 정렬
                return o1 > o2 ? 1 : -1;
            }
            return first_abs-second_abs; //절댓값 작은 데이터 우선정렬(오름차순)
        });

        for(int i =0;i<N;i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(queue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.add(request);
            }
        }
    }
}

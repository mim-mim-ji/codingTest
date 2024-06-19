package BaekJoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_9019 {

    static class Register{
        int num;
        String command;
        public Register(int num, String command){
            this.num = num;
            this.command = command;
        }

        int D(){
            return (num * 2) % 10000;
        }
        int S(){
            return num == 0 ? 9999 : (num -1);
        }
        int L(){
            return (num % 1000) * 10 + num / 1000; // 1234 -> 2341 : 1234를 1000으로 나눈 나머지(234)에 10을 곱함=2340, 1234를 1000으로 나누면 1, 2340+1=2341
        }
        int R(){
            return (num % 10) * 1000 + num / 10; // 1234 -> 4123 : 1234를 10으로 나눈 나머지에 1000 곱합 = 4000, 1234를 10으로 나누면 123, 4000+123=4123
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Queue<Register> queue = new LinkedList<>();

        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000]; //bfs 탐색의 방문 여부 체크
            visited[start] = true;

            queue.clear();
            queue.offer(new Register(start, ""));

            while(! queue.isEmpty()){
                Register reg = queue.poll();

                if(reg.num == target){
                    System.out.println(reg.command);
                    break;
                }

                if(! visited[reg.D()]){
                    queue.offer(new Register(reg.D(), reg.command + "D"));
                    visited[reg.D()] = true;
                }
                if(! visited[reg.S()]){
                    queue.offer(new Register(reg.S(), reg.command + "S"));
                    visited[reg.S()] = true;
                }
                if(! visited[reg.L()]){
                    queue.offer(new Register(reg.L(), reg.command + "L"));
                    visited[reg.L()] = true;
                }
                if(! visited[reg.R()]){
                    queue.offer(new Register(reg.R(), reg.command + "R"));
                    visited[reg.R()] = true;
                }
            }
        }
    }

}

package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_10158 {

    /*
     (p,q) 1시간 후 -> (p+1,q+1)
     오른쪽 위 45도 방향으로 일정한 속력으로 움직임
     경계면에 부딪치면 같은 속력으로 반사되어 움직인다.
     w×h인 격자 공간에서 처음에 (p,q)에서 출발하는 개미의 t시간 후의 위치 (x,y)를 계산하여 출력
     초기 위치 p와 q도 자연수이며 범위는 각각 0 < p < w과 0 < q < h
     w=6, h=4 -> (5,3)에 있었다면 매 시간마다 (6,4), (5,3), (4,2), (3,1)

    ** T는 최대 200억(2 * 10^10)까지 가능해서, 매 초마다 개미 위치를 일일이 계산하면 시간 초과가 남
    -> 주기를 구하는 게 중요!!

x축만 보면 4-> 5-> 6-> 5-> 4-> 3->2->1->0->1->2 ....=> 0 -> w -> 0 -> w으로 왕복 -> 2*w 마다 원래위치로 돌아옴
y축도 1->2->3->4->3->2->1->0->1... => h를 왕복 -> 2h마다 원래위치로 돌아옴

(p+t) % 2w -> 만일 벽에 부딪혔을 경우? 반대방향이므로 2w에서 빼주기
(q+h) % 2h
f(x) = w - |w-x| = w - |w-((p+t) % 2w)|

     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(br.readLine());

            int x = (p + t) % (2 * w);
            if (x > w)
                x = 2 * w - x;
            int y = (q + t) % (2 * h);
            if (y > h)
                y = 2 * h - y;

            System.out.println(x + " " + y);
        }
    }

    //    public static void main(String[] args) throws IOException {
    //        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    //            StringTokenizer st = new StringTokenizer(br.readLine());
    //            int w = Integer.parseInt(st.nextToken());
    //            int h = Integer.parseInt(st.nextToken());
    //
    //            st = new StringTokenizer(br.readLine());
    //            int p = Integer.parseInt(st.nextToken());
    //            int q = Integer.parseInt(st.nextToken());
    //            int t = Integer.parseInt(br.readLine());
    //
    //            int x = w - Math.abs(w - (p + t) % (2 * w));  //Math.abs() -> 절댓값 구하는 함수 사용해도 됨
    //            int y = h - Math.abs(h - (q + t) % (2 * h));
    //
    //            System.out.println(x + " " + y);
    //        }
    //    }

}

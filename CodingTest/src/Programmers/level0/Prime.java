package Programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    //어떤 자연수 n이 소수인지를 판별하려면 n을 2~√n 으로 나누면서 나누어 떨어지는지를 확인
    //소수 : 1과 자기자신으로만 나누어 떨어지는 수
    public static void main(String[] args) {

        boolean prime[];
        List<Integer> list = new ArrayList<>();

        int N = 41;

        prime = new boolean[N+1];
        prime[1] = true;

        //소수인게 false, 아닌것만 찾아서 true로 바꿔줌
        for(int i=2;i <= Math.sqrt(N);i++){
            if(!prime[i]) {
                //i의 배수들은 소수가 아님
                for(int j=i*i; j<=N; j+=i) prime[j]=true;
            }
        }

        for(int i=1; i<=N;i++){
            if(!prime[i]) list.add(i);
        }

        System.out.println(Arrays.toString(prime));
        System.out.println(list);

    }
}

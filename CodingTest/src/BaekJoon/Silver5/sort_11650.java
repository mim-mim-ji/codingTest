package BaekJoon.Silver5;

import java.util.*;

public class sort_11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int [][] arr = new int[N][2];

        for(int i=0;i<N;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //오름차순정렬:작은거에서 큰거빼기
       Arrays.sort(arr,(o1, o2) -> {
           if(o1[0]==o2[0]){
               return o1[1] - o2[1];
           }else{
               return o1[0] - o2[0];
           }
       });

        for(int i=0;i<N;i++){
            System.out.println(arr[i][0]+ " "+arr[i][1]);
        }

    }
}

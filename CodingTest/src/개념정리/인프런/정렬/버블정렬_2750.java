package 개념정리.인프런.정렬;

import java.util.Scanner;

public class 버블정렬_2750 {
    /*
    버블: 데이터의 인접 요소끼리 비교하고 swap 연산을 수행하며 정렬하는 방식

    시간복잡도: O(n2) - 다른 정렬 알고리즘보다 속도가 느린 편
    데이터가 n개가 있다면 루프가 한번 도는데 n의 시간복잡도 * 루프를 n번 돌아야하므로 n2

    만약 특정한 루프의 전체영역에서 swap이 한번도 발생하지 않았다면
    그 영역 뒤에 있는 데이터가 모두 정렬됐다는 뜻이므로 프로세스를 종료해도 됨

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[]A = new int[N];

        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }

        //버블 정렬을 구현하는 영역
        for(int i = 0; i < N-1 ; i++){ //loop의 개수
            for(int j = 0; j < N-1-i ; j++){ //정렬하는 범위: 아직 정렬되지 않은 배열의 영역
                //인접한 두 수끼리 비교해서 swap
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for(int i=0;i<N;i++){
            System.out.println(A[i]);
        }
    }
}

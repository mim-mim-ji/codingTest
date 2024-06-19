package 개념정리.인프런.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 스택_1874 {

    // 1부터 N까지 오름차순으로 스택에 push를 진행하면서 필요할 때마다 pop을 하여 주어진 임의의 수열을 출력할 수 있는지에 대한 문제
    /*
8 //수열개수
4
3
6
8
7
5
2
1
//결과
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i=0;i<N ;i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1; //push한 자연수
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i<A.length;i++){
            int su = A[i];
            if(su >= num){
                while (su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}

package Programmers.level2;

import java.util.*;

public class LGNum2 {
    // 3 <= n <= 30 , n은 문제 유형
    // 3<= 문제개수=행 길이 <= 16
    // problems의 열 길이 = n
    // problems의 행 길이 = 문제개수
    // problems[i][j] = 1이면 i+1번 문제는 j+1번 유형
    // 가장 적은 수의 문제를 풀어서 모든 문제유형을 풀 수 있는 문제의 조합을 배열로 반환하라
    // 여러개일 경우 오름차순의 첫번째 배열 반환

    public static void main(String[] args) {
        int[][]problems = {{1,1,0,0,1},{1,0,0,1,0},{0,0,1,1,0},{0,1,0,1,0,0},{1,0,1,0,0},{0,0,1,0,1}};
        //문제 1번: 유형 1,2,5
        //문제 2번: 유형 1,4
        //문제 3번: 유형 3,4
        //문제 4번: 유형 2,4
        //문제 5번: 유형 1,3
        //문제 6번: 유형 3,5

        System.out.println("answer: "+Arrays.toString(solution(problems)));
    }

    static int row;
    static int type;
    static int [] answer;
    public static int[] solution(int [][]problems) {
        row = problems.length; //문제개수
        type = problems[0].length; //유형개수

        List<String> list = new ArrayList<>();

        for(int i=0;i<row;i++){
            String temp = "";
            for(int j=0;j<type;j++){
                if(problems[i][j] != 0) {
                    temp += String.valueOf(j + 1);
                }
            }
            list.add(temp);
        }

        System.out.println(list);
        String[] arr = new String[list.size()];
        int index = 0;
        for(String st : list){
            arr[index++] = st;
        }

        boolean [] visited = new boolean[arr.length];
        //조합으로 2개 뽑는 경우부터 구하기
        for(int i=2;i<= arr.length;i++){
            System.out.println("\n" + row + "개 중에 " + i + "개 뽑음");
            dfs(arr,visited,0,i,"");
        }

        return answer;
    }

    public static void dfs(String[] arr, boolean [] visited,int start, int r, String str){
        String st = "";
        String ans = "";
        if(r == 0 && str.length()==type){
            int i;
            for(i=0;i<arr.length;i++) {
                if(visited[i] == true){
                    st += arr[i];
                    ans += i+1;
                }
                if(isAnswer(st)){
                    answer = new int[ans.length()];
                    for(int j=0;j<ans.length();j++) {
                        answer[j] = Integer.parseInt(String.valueOf(ans.charAt(j)));
                    }
                    System.out.println(ans);
                    break;
                }
            }
            System.out.println("str:"+str);
            return;
        }else{
            for(int i=start;i< arr.length;i++){
                    visited[i] = true;
                    String temp = str + arr[i];
                    dfs(arr, visited,i+1,r-1, temp);
                    visited[i] = false;
            }
        }
    }
    //모든 유형을 다 뽑았는지 확인
    public static boolean isAnswer(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String typeString = "";
        for(int i=0;i<type;i++){
            typeString += i+1;
        }
        if(String.valueOf(ch).equals(typeString)) return true;
        return false;
    }

}

package Programmers.level0;

import java.util.*;

public class HanWhaTest1 {
    //grade = 1시간 공부했을때 오르는 성적
    //n개의 시험과목이 주어질 때 goal(평균성적) 이상이 되는 시험점수를 받을 수 있는 최소 시간을 구하라
    //만점은 100점

    static int n;
    static int[] time;
    static Stack<Integer> st;
    static int [] grade;
    static int goal;
    static List<Integer> list;

    public static void main(String[] args) {
        grade = new int[]{45,30};
        goal = 60;

        n = grade.length;
        time = new int[n];

        for(int i=0;i<n;i++){
            time[i] = 100/grade[i] + 1;

            if(100%grade[i] == 0){
                time[i] = 100/grade[i];
            }
        }
        System.out.println(Arrays.toString(time));

        int maxTime = 0;
        for(int i=0;i<n-1;i++) {
            maxTime = Math.max(time[i], time[i + 1]);
        }

        int [] timeArr = new int [maxTime];
        for(int i=0;i<maxTime;i++){
            timeArr[i] = i+1;
        }
        System.out.println(Arrays.toString(timeArr));

        list = new ArrayList<>();
        st = new Stack<>();
        permutation(timeArr, n);

        System.out.println(list);
        Collections.sort(list);

        System.out.println("asnwer: "+list.get(0));

    }

    private static void permutation(int[] timeArr, int r) {
        if(st.size() == r){
            int sum = 0;
            int min = 0;
            int i = 0;
            int j=0;
            int temp = 0;
            int time =0;

            for(i=0;i<st.size();i++){
                time = st.get(i);
                temp = st.get(i)*grade[i];

                System.out.println("temp: "+temp);
                min += time;
                sum += temp;
            }

            System.out.println("sum: "+sum);
            System.out.println("min: "+min);
            if(sum >= goal*r){
                if(! list.contains(min)){
                    list.add(min);
                }
            }
            System.out.println();
            return;
        }
        for(int i=0;i<timeArr.length;i++){
            st.push(timeArr[i]);
            permutation(timeArr, r);
            st.pop();
        }

    }
}

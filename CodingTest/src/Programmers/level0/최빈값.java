package Programmers.level0;

public class 최빈값 {
    public static void main(String[] args) {

    }

    public static int solution(int[] array) {
        int answer = 0;

        int [] index = new int[1001];

        //해당인덱스에 해당하는 값의 카운트
        for(int i=0;i<array.length;i++){
            index[array[i]]++;
        }

        int max = Integer.MAX_VALUE; //최대값을 저장하기위한 변수

        for (int i=0; i< index.length; i++){
            if(max < index[i]){
                max = index[i]; //MAX: 최대횟수
                answer = i; //최빈값
            }
        }

        int count = 0; //최대값이 나온 횟수
        for(int i=0;i<index.length;i++){
            if(index[i] == max) count++;
        }
        if(count > 1) return -1;

        return answer;
    }
}

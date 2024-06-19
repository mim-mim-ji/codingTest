package Programmers.level0;

public class SelfTest {
    public static void main(String[] args) {
       for(int i=2;i<=9;i++){
           for(int j=1;j<=9;j++){
               System.out.printf("%d * %d = %d\t",i,j,i*j);
           }
       }
        String[] weekArray = {"Sunday", "Monday","Tuesday",
                "Wednesday","Thursday","Friday","Saturday"};

        for(String day:weekArray) {
            System.out.println(day);
        }

        int a = 1234;
        String st = String.valueOf(a);
        System.out.println(st);


        // 일반 배열
        for(int i=0;i<weekArray.length;i++) {
            System.out.println(weekArray[i]);
        }
        // break - 반복문 탈출
        // continue - 해당 경우 스킵, 이어서 계속 실행
        // return - 메서드를 종료하기 때문에 반복문 탈출도 당연히 가능
        for(int i=0;i<10;i++) {
            if(i==5) {
                //break;
                return; //main 메서드 종료 => main 밖으로 탈출
            }
            System.out.println(i);
        }
        System.out.println("메인 실행 종료"); //실행안됨

    }

    public static int solution(int a, int b) {

        return a+b;
    }
}

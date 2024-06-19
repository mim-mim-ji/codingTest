package 개념정리;

import java.util.Arrays;

public class 정리 {
    public static void main(String[] args) {
        /* 기본 데이터 타입
        byte a = (byte)128;
        short b = (short) 32768;
        int c = 2147483648; // int c = 2147483647;이 최대
        long d = 2147483648L;
        float e = 1.1f; // 1.100000
        double f = 1.1; // 1.100000
        boolean one = false; //초기값 = false
        char ch = 'A';
        String st = "A";
         */

        //문자열 -> 2,8,16진수로 변경 : Integer.parseInt(String s,2)
        String bin1 = "1100";
        int bin2 = Integer.parseInt(bin1, 16);
        System.out.println(bin2);

        //10진수 -> n진수 : Integer.toString(n,k)
        System.out.println(Integer.toString(2568,2));

        //정수 -> 2진수 String 으로 변환
        String s5 = Integer.toBinaryString(1234);
        System.out.println("s5:"+s5);

        //문자열과 다른 데이터타입의 연산은 전부 문자열로 리턴
        String s = "Hello"; s.substring(0,5);
        int a = 22;
        System.out.println(s+a); //Hello22 -> 문자열

        /* 참조 데이터 타입 - 배열, 연산자 */
        //배열
        int[] f = new int[5];
        System.out.println(f); // 주소값을 반환
        System.out.println(Arrays.toString(f)); // 배열의 주소값이 아닌 실제 값을 출력하는 메서드
        //연산자 - 형변환
        //큰 크기 변수의 값을 작은 크기 변수에 저장할 경우에는 명시적 형변환을 해야 함
        //데이터 타입의 크기: byte(1) -> short(2) -> char(2) -> int(4) -> long(8)
        // float(4) -> double(8)
        int b = 97;
        char ch = (char) b;
        System.out.println(ch); //아스키 코드: 97번째는 'a'
        char cc = 'b';
        int c = cc;
        System.out.println(c); //아스키 코드: 98번째는 'b'
        // int -> char : (char) 명시적 형변환
        // char -> int : 묵시적 형변환

        /*
           Math.round 반올림   Math.floor 버림   Math.ceil 올림
           (int)Math.random()*n + 1  : 1~n까지 난수 발생
           Math.abs(-123);
         */

        /*
         [오름차순]
         작은 원소가 큰 원소보다 앞에 있으므로 오름차순이다.
        public int compareTo(MyClass o) {
            return this.value - o.value;
        }
        public int compare(Myclass o1, MyClass o2) {
            return o1.value - o2.value;
        }

         [내림차순]
         큰 원소가 작은 원소보다 앞에 있으므로 내림차순이다.
        public int compareTo(MyClass o) {
            return o.value - this.value;
        }
        public int compare(Myclass o1, MyClass o2) {
            return o2.value - o1.value;
        }
        */

    }
}

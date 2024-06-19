package 개념정리.Stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        //reduce(accumulator)
        OptionalInt reduced = IntStream.range(1,4) //[1,2,3]
                .reduce((left, right) -> {
                    return Integer.sum(left,right);
                });
        System.out.println(reduced);

        //reduce(identity, accumulator)
        int reduced1 = IntStream.range(1,4) //[1,2,3]
                .reduce(10, (left, right) -> { //초기값 10
                    return Integer.sum(left,right);
                });
        System.out.println(reduced1);

        //reduce(identity, accumulator, combiner)
        int reduced2 = Stream.of(1,2,3)  //IntStream에는 3개의 파라미터를 갖는 reduce가 존재하지 않으므로 Stream.of()로 Stream을 생성해야 한다.
                .parallel()
                .reduce(10, Integer::sum, (a,b) -> {
                    System.out.println("combiner was called");
                    return a+b;
                });
        //11(10+1), 12(10+2), 13(10+3)
        System.out.println(reduced2);
    }
}

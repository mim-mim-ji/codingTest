package 개념정리.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    /*
        FlatMap
        - 2중 배열 또는 2중 리스트를 1차원으로 처리해야할 경우 사용
     */

    public static void main(String[] args) {

        // [[a], [b]] -> 이중리스트
        List<List<String>> list = Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));

        List<String> flatList = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);

        //2차원 배열
        Stream<String[]> strStream = Stream.of(
            new String[]{"a","b","c"}
            ,new String[]{"d","e","f"});

        //map을 사용하면 2중 stream 반환됨
        //Stream<Stream<String>> stream = strStream.map(Arrays::stream);

        //flatMap을 사용하면 1중 stream 으로 차원을 낮출 수 있음
        Stream<String> stream1 = strStream.flatMap(Arrays::stream);


        /*
            FlatMap 사용예제
         */
        List<String> list1 = Arrays.asList("Hello","World");

        //map을 사용하는 경우 원하는 List<String>을 만들 수 없음
        Stream<String[]> stream2 = list1.stream().map(s -> s.split("")); //["H", "e", "l", "l", "o"] ["W", "o", "r", "l", "d"]
        List<String[]> list2 = stream2.distinct().collect(Collectors.toList()); //중복된 항목 제거 X, ["H", "e", "l", "l", "o"], ["W", "o", "r", "l", "d"] 수집
        String[] arr = list2.get(0);
        System.out.println(Arrays.toString(arr));

        //flatmap을 사용하는 경우 여러 개의 Stream<String>을 하나의 Stream<String>으로 합칠 수 있음
        Stream<String> stream = list1.stream().map(s -> s.split("")).flatMap(Arrays::stream); //["H", "e", "l", "l", "o", W", "o", "r", "l", "d"]
        List<String> list3 = stream.distinct().collect(Collectors.toList()); //중복된 소스(l, o)가 제거, ["H", "e", "l", "o", "W", "r", "d"] 수집
        System.out.println(list3);

    }
}

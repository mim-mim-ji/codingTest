package 개념정리.Stream;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamEx2 {
    public static class Product{
        private int amount;
        private String name;

        public Product(int amount, String name){
            this.amount = amount;
            this.name = name;
        }

        public int getAmount() {
            return amount;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        //최댓값/최솟값/총합/평균/갯수 - Max/Min/Sum/Average/Count
        OptionalInt min = IntStream.of(1,3,5,7,9).min();
        System.out.println(min);

        int max = IntStream.of().max().orElse(0);
        System.out.println(max);

        IntStream.of(1,3,5,7,9).average().ifPresent(System.out::println);

        long count = IntStream.of(1,3,5,7,9).count();
        System.out.println(count);

        long sum = IntStream.of(1,3,5,7,9).sum();
        System.out.println(sum);

        //데이터수집 - collect
        /*
            collect() : 스트림의 최종연산, 매개변수로 Collector를 필요로 한다.
            Collector : 인터페이스, collect의 파라미터는 이 인터페이스를 구현해야한다.
            Collectors : 클래스, static메소드로 미리 작성된 컬렉터를 제공한다.
         */
        //Object collect(Collector collector); => collect의 파라미터로 Collector의 구현체가 와야 한다.
        List<Product> productList = Arrays.asList(
                new Product(23,"potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

        //Collectors.toList() : stream에서 작업한 결과를 List로 반환받을 수 있음
        List<String> nameList = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);

        //Collectors.joining() : stream에서 작업한 결과를 1개의 String으로 이어붙임
        String listToString1 = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining());

        System.out.println(listToString1);

        String listToString2 = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(" "));

        System.out.println(listToString2);

        String listToString3 = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ","<",">"));

        System.out.println(listToString3);

        // Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
        Double averageAmount = productList.stream()
                .collect(Collectors.averagingInt(Product::getAmount));

        System.out.println(averageAmount);

        Integer summingAmount1 = productList.stream()
                .collect(Collectors.summingInt(Product::getAmount));

        System.out.println(summingAmount1);

        Integer summingAmount2 = productList.stream()
                .mapToInt(Product::getAmount)
                .sum();

        System.out.println(summingAmount2);

        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getAmount));

        System.out.println(statistics);

        //Collectors.groupingBy()
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getAmount));

        /*
        {23=[Product{amount=23, name='potatoes'}, Product{amount=23, name='bread'}],
         13=[Product{amount=13, name='lemon'}, Product{amount=13, name='sugar'}],
         14=[Product{amount=14, name='orange'}]}
         */

        //Collectors.partitioningBy()
        Map<Boolean, List<Product>> mapPartitioned = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getAmount() > 15));
        /*
        {false=[Product{amount=14, name='orange'}, Product{amount=13, name='lemon'}, Product{amount=13, name='sugar'}],
        true=[Product{amount=23, name='potatoes'}, Product{amount=23, name='bread'}]}
        */

        //Match : 조건검사
        /*
            - anyMatch : 1개의 요소라도 해당 조건을 만족하는가
            - allMatch : 모든 요소가 해당 조건을 만족하는가
            - nonMatch : 모든 요소가 해당 조건을 만족하지 않는가
         */

        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        boolean antMatch = names.stream()
                .anyMatch(name -> name.contains("a"));

        boolean allMatch = names.stream()
                .allMatch(name -> name.length() > 3);

        boolean nonMatch = names.stream()
                .noneMatch(name -> name.endsWith("s"));

        //forEach : 특정 연산 수행
        names.stream()
                .forEach(System.out::println);

    }


}

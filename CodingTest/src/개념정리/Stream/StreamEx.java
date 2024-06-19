package 개념정리.Stream;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

    //Collection 의 Stream 생성
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> listStream = list.stream();

    //배열의 Stream 생성
    Stream<String> stream1 = Stream.of("a", "b", "c");
    Stream<String> stream2 = Stream.of(new String[] {"a", "b", "c"});
    Stream<String> stream3 = Arrays.stream(new String[] {"a", "b", "c"});
    Stream<String> stream4 = Arrays.stream(new String[] {"a", "b", "c"},0,3); //end 범위 포함X

    //원시 Stream 생성
    IntStream stream5 = IntStream.range(4,10);

    public void Filter(){
        // a가 들어간 문자열만을 포함하도록 필터링
        Stream<String> stream = list.stream()
                .filter(name -> name.contains("a"));
    }

    public void Map(){
        Stream<String> stream = stream1.map(s -> s.toUpperCase());

        Stream<File> fileStream = Stream.of(new File("Test1.java"), new File("Test2.java"), new File("Test3.java"));
        //Stream<File> --> Stream<String> 변환
        Stream<String> fileNameStream = fileStream.map(File::getName);
    }

    public void Sort(){
        List<String> list = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        Stream<String> stream = list.stream().sorted();  // [Go, Groovy, Java, Python, Scala, Swift]
        Stream<String> stream1 = list.stream().sorted(Comparator.reverseOrder()); // [Swift, Scala, Python, Java, Groovy, Go]
    }

    public void Distinct(){
        List<String> list = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift", "Java");
        Stream<String> stream = list.stream().distinct(); // [Java, Scala, Groovy, Python, Go, Swift]
    }

    //작성한 Employee 클래스를 Stream 으로 사용할 경우 hashCode 와 equals를 오버라이드 해야함
    public static class Employee{
        private String name;

        public Employee(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("minji");
        Employee e2 = new Employee("minji");
        List<Employee> list = new ArrayList<>();
        list.add(e1); list.add(e2);

        int size = list.stream().distinct().collect(Collectors.toList()).size();
        System.out.println(size);

        //peek
        int sum = IntStream.of(1,3,5,7,9).peek(System.out::println).sum();
        System.out.println(sum);
    }

    //원시 Stream <-> Stream
    public void StreamTo(){
        // IntStream -> Stream<String>
        IntStream.range(1,4).mapToObj(i -> "a"+i);

        //Stream<Double> -> IntStream -> Stream<String>
        Stream.of(1.0,2.0,3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i);
    }

}

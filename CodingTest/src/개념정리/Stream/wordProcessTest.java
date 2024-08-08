//package 개념정리.Stream;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class wordProcessTest {
//
//    private final List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");
//
//    /*
//    1. 단어의 크기가 2 이상인 경우를 필터링한다.
//    2. 모든 단어를 대문자로 변환한다.
//    3. 모든 단어를 앞글자만 잘라내어 변환한다.
//    4. 모든 단어를 스페이스로 구분한 하나의 문자열로 합친다.
//     */
//
//    @DisplayName("stream 테스트")
//    @Test
//    void wordProcessTest(){
//        String result = words.stream()
//                .filter(w -> w.length() > 1)
//                .map(String::toUpperCase)
//                .map(w -> w.substring(0,1))
//                .collect(Collectors.joining(" "));
//        assertThat(result).isEqualTo("T H A N K");
//    }
//
//    @Test
//    void customFunction(){
//        Function<String, String> function = word -> word.toUpperCase();
//        assertThat(function.apply("text")).isEqualTo("TEXT");
//    }
//
//
//}

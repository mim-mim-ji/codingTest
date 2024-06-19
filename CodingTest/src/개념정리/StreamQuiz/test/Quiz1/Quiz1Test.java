package 개념정리.StreamQuiz.test.Quiz1;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import 개념정리.StreamQuiz.Quiz1.Answer1;
import 개념정리.StreamQuiz.Quiz1.Quiz1;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz1Test {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();

    @Test
    void quiz1() throws IOException, CsvException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() throws IOException, CsvException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

    @Test
    void quiz3() throws IOException, CsvException {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
    }

}
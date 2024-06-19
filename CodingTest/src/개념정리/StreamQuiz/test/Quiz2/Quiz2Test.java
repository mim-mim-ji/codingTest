package 개념정리.StreamQuiz.test.Quiz2;

import org.junit.jupiter.api.Test;
import 개념정리.StreamQuiz.Quiz2.Answer2;
import 개념정리.StreamQuiz.Quiz2.Quiz2;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz2Test {

    private final Answer2 answer = new Answer2();
    private final Quiz2 quiz = new Quiz2();

    @Test
    void quiz1() {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

}
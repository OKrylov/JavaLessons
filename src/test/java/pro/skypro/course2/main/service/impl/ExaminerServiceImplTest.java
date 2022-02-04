package pro.skypro.course2.main.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.skypro.course2.main.exception.InvalidExamGenerateException;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    private ExaminerServiceImpl out;
    private QuestionService mock1;
    private QuestionService mock2;

    @BeforeEach
    public void setUp() {
        mock1 = mock(QuestionService.class);
        mock2 = mock(QuestionService.class);

        this.out = new ExaminerServiceImpl(List.of(mock1, mock2));
    }

    @Test
    public void test_amount_is_less_than_one() {
        Assertions.assertThrows(InvalidExamGenerateException.class, () -> out.getQuestions(-1));
        Assertions.assertThrows(InvalidExamGenerateException.class, () -> out.getQuestions(0));
    }

    @Test
    public void test_random_questions() {
        when(mock1.getRandomQuestion()).thenReturn(
          new Question("mock1_question1", "mock1_answer1"),
          new Question("mock1_question2", "mock1_answer2")
        );
        when(mock2.getRandomQuestion()).thenReturn(
          new Question("mock2_question1", "mock2_answer1"),
          new Question("mock2_question2", "mock2_answer2"),
          new Question("mock2_question2", "mock2_answer3")
        );

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0, 1, 1, 0, 1);
        out.setRandom(mockRandom);


        Collection<Question> actual = out.getQuestions(5);
        List<Question> expected = List.of(
                new Question("mock1_question1", "mock1_answer1"),
                new Question("mock2_question1", "mock2_answer1"),
                new Question("mock2_question2", "mock2_answer2"),
                new Question("mock1_question2", "mock1_answer2"),
                new Question("mock2_question2", "mock2_answer3")
        );

        Assertions.assertIterableEquals(expected, actual);

    }

}
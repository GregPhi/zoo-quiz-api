package quiz_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import platine.zoo.quiz_api.bo.Question;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.repository.QuizRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class QuizRepositoryTest {
    @Autowired
    private QuizRepository quizRepository;

    @Test
    void testSave(){
        var quiz = new Quiz();
        quiz.setId(1);

        quizRepository.save(quiz);

        var saved = quizRepository.findById(String.valueOf(quiz.getId())).orElse(null);

        assertEquals(1, saved.getId());
    }

    @Test
    void testSaveWithQuestion(){
        var quiz = new Quiz();
        quiz.setId(1);
        var question = new Question();
        question.setQuestion("Is the tiger a feline ?");
        quiz.addQuestion(question);

        quizRepository.save(quiz);

        var saved = quizRepository.findById(String.valueOf(quiz.getId())).orElse(null);

        assertEquals(1, saved.getId());
        assertNotNull(saved.getQuestions());
        assertEquals(1, saved.getQuestions().size());
    }

    @Test
    void testDelete(){
        var quiz = new Quiz();
        quiz.setId(1);

        quizRepository.save(quiz);
        quizRepository.delete(quiz);

        var saved = quizRepository.findById(String.valueOf(quiz.getId())).orElse(null);

        assertNull(saved);
    }
}

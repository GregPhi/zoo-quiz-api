package quiz_api.service;

import org.junit.jupiter.api.Test;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.repository.QuizRepository;
import platine.zoo.quiz_api.service.QuizServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuizServiceImplTest {
    @Test
    void findAll_shouldCallTheRepository() {
        var quizRepo = mock(QuizRepository.class);
        var quizService = new QuizServiceImpl(quizRepo);

        quizService.findAll();

        verify(quizRepo).findAll();
    }

    @Test
    void findQuizById_shouldCallTheRepository() {
        var quizRepo = mock(QuizRepository.class);
        var quizService = new QuizServiceImpl(quizRepo);

        quizService.findQuizById(1);

        verify(quizRepo).findQuizById(1);
    }

    @Test
    void newAnimal_shouldCallTheRepository() {
        var quizRepo = mock(QuizRepository.class);
        var quizService = new QuizServiceImpl(quizRepo);

        var quiz = new Quiz();
        quizService.save(quiz);

        verify(quizRepo).save(quiz);
    }

    @Test
    void updateAnimal_shouldCallTheRepository() {
        var quizRepo = mock(QuizRepository.class);
        var quizService = new QuizServiceImpl(quizRepo);

        var quiz = new Quiz();
        quizService.save(quiz);

        var test = new Quiz();
        quizService.updateQuiz(test);

        verify(quizRepo).save(test);
    }

    @Test
    void deleteAnimal_shouldCallTheRepository() {
        var quizRepo = mock(QuizRepository.class);
        var quizService = new QuizServiceImpl(quizRepo);

        var quiz = new Quiz();
        quizService.save(quiz);

        quizService.delete(quiz);

        verify(quizRepo).delete(quiz);
    }
}

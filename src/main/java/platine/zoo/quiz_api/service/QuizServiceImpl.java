package platine.zoo.quiz_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{
    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Iterable<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findQuizById(int id) {
        return quizRepository.findQuizById(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void delete(Quiz quiz) {
        quizRepository.delete(quiz);
    }
}

package platine.zoo.quiz_api.service;

import platine.zoo.quiz_api.bo.Quiz;

import java.util.List;

public interface QuizService {
    Iterable<Quiz> findAll();

    Quiz findQuizById(int id);

    Quiz save(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    void delete(Quiz quiz);
}

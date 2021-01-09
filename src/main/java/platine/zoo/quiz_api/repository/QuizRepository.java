package platine.zoo.quiz_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platine.zoo.quiz_api.bo.Question;
import platine.zoo.quiz_api.bo.Quiz;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, String> {
    List<Quiz> findAll();

    Quiz findQuizById(int id);

    Quiz save(Quiz quiz);

    void delete(Quiz quiz);
}

package quiz_api.bo;

import org.junit.jupiter.api.Test;
import platine.zoo.quiz_api.bo.Question;

import javax.persistence.Embeddable;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuestionTest {
    @Test
    void description_shouldBeAnEmbeddable(){
        assertNotNull(Question.class.getAnnotation(Embeddable.class));
    }
}

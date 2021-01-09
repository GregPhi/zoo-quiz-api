package quiz_api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.*;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.controller.QuizController;
import platine.zoo.quiz_api.exception.QuizNotFoundException;
import platine.zoo.quiz_api.service.QuizService;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class QuizControllerTest {
    @Mock
    private QuizService quizService;

    @InjectMocks
    private QuizController quizController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllQuizzes_shouldCallTheService() {
        quizController.getAllQuizzes();

        verify(quizService).findAll();
    }

    @Test
    void getQuiz_shouldCallTheService() {
        quizController.getQuizById(1);

        verify(quizService).findQuizById(1);
    }

    @Test
    void newQuiz_shouldCallTheService(){
        Quiz test = new Quiz();

        quizController.newQuiz(test);

        verify(quizService).save(test);
    }

    @Test
    void updateQuiz_ThrowQuizNotFoundException() {
        Quiz test = new Quiz();
        test.setId(1);
        try {
            quizController.updateQuiz(1,test);
            fail();
        } catch (QuizNotFoundException e) {
            assertEquals("The quiz : 1 is not found !",e.getMessage());
        }
    }

    @Test
    void deleteQuiz_shouldCallTheService(){
        quizController.deleteQuiz(1);

        verify(quizService).findQuizById(1);
    }

    @Test
    void quizController_shouldBeAnnotated(){
        var controllerAnnotation =
                QuizController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        var requestMappingAnnotation =
                QuizController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/quizzes"}, requestMappingAnnotation.value());
    }

    @Test
    void getAllQuizzes_shouldBeAnnotated() throws NoSuchMethodException {
        var getAllQuizzes =
                QuizController.class.getDeclaredMethod("getAllQuizzes");
        var getMapping = getAllQuizzes.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    void getQuizById_shouldBeAnnotated() throws NoSuchMethodException {
        var getQuizById =
                QuizController.class.getDeclaredMethod("getQuizById", int.class);
        var getMapping = getQuizById.getAnnotation(GetMapping.class);

        var pathVariableAnnotation = getQuizById.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{id}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }

    @Test
    void newQuiz_shouldBeAnnotated() throws NoSuchMethodException {
        var newQuiz =
                QuizController.class.getDeclaredMethod("newQuiz", Quiz.class);
        var postMapping = newQuiz.getAnnotation(PostMapping.class);

        var requestBodyAnnotation = newQuiz.getParameters()[0].getAnnotation(RequestBody.class);

        assertNotNull(postMapping);
        assertArrayEquals(new String[]{"/"}, postMapping.value());

        assertNotNull(requestBodyAnnotation);
    }

    @Test
    void updateQuiz_shouldBeAnnotated() throws NoSuchMethodException {
        var updateQuiz =
                QuizController.class.getDeclaredMethod("updateQuiz", int.class, Quiz.class);
        var putMapping = updateQuiz.getAnnotation(PutMapping.class);

        var requestBodyAnnotation = updateQuiz.getParameters()[0].getAnnotation(PathVariable.class);
        var pathVariableAnnotation = updateQuiz.getParameters()[1].getAnnotation(RequestBody.class);

        assertNotNull(putMapping);
        assertArrayEquals(new String[]{"/{id}"}, putMapping.value());

        assertNotNull(requestBodyAnnotation);
        assertNotNull(pathVariableAnnotation);
    }

    @Test
    void deleteQuiz_shouldBeAnnotated() throws NoSuchMethodException {
        var deleteQuiz =
                QuizController.class.getDeclaredMethod("deleteQuiz", int.class);
        var deleteMapping = deleteQuiz.getAnnotation(DeleteMapping.class);

        var pathVariableAnnotation = deleteQuiz.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(deleteMapping);
        assertArrayEquals(new String[]{"/{id}"}, deleteMapping.value());

        assertNotNull(pathVariableAnnotation);
    }
}

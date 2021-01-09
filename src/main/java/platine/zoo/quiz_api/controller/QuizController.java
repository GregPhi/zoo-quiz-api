package platine.zoo.quiz_api.controller;

import org.springframework.web.bind.annotation.*;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.exception.QuizNotFoundException;
import platine.zoo.quiz_api.service.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    Iterable<Quiz> getAllQuizzes(){
        return this.quizService.findAll();
    }

    @GetMapping("/{id}")
    Quiz getQuizById(@PathVariable int id){
        return this.quizService.findQuizById(id);
    }

    @PostMapping("/")
    Quiz newQuiz(@RequestBody Quiz quiz){
        return this.quizService.save(quiz);
    }

    @PutMapping("/{id}")
    Quiz updateQuiz(@PathVariable int id, @RequestBody Quiz newQuiz) throws QuizNotFoundException {
        Quiz oldQuiz = this.quizService.findQuizById(id);
        if(oldQuiz == null){
            throw new QuizNotFoundException(id);
        }
        this.quizService.delete(oldQuiz);
        return this.quizService.save(newQuiz);
    }

    @DeleteMapping("/{id}")
    void deleteQuiz(@PathVariable int id){
        Quiz quiz = this.quizService.findQuizById(id);
        if(quiz != null){
            this.quizService.delete(quiz);
        }
    }
}

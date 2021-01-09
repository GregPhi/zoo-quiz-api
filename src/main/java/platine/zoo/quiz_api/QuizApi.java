package platine.zoo.quiz_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import platine.zoo.quiz_api.bo.Question;
import platine.zoo.quiz_api.bo.Quiz;
import platine.zoo.quiz_api.repository.QuizRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class QuizApi {

    public static void main(String... args){
        SpringApplication.run(QuizApi.class,args);
        System.out.println("=================================================");
        System.out.println("        -> http://localhost:8082/quizzes/");
        System.out.println("=================================================");
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(QuizRepository repository) {
        return (args) -> {
            var quiz = new Quiz();
            var question = new Question();
            quiz.setQuestions(List.of(question));

            repository.save(quiz);};
    }

}

package platine.zoo.quiz_api.exception;

public class QuizNotFoundException extends Exception{
    public QuizNotFoundException(){
        super("The quiz is not found !");
    }

    public QuizNotFoundException(int id){
        super("The quiz : "+id+" is not found !");
    }
}

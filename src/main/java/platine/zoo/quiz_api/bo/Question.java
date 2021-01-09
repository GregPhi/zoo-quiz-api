package platine.zoo.quiz_api.bo;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Question {
    @GeneratedValue
    private int id;
    private String question;
    private String url_extra;
    @ElementCollection
    private List<String> choice_responses;
    private String good_answer;
    private boolean right_answer;

    public Question() {
        this.choice_responses = new ArrayList<>();
        this.right_answer = false;
    }

    public Question(int id, String question, String url_extra, List<String> choice_responses, String good_answer, boolean right_answer) {
        this.id = id;
        this.question = question;
        this.url_extra = url_extra;
        this.choice_responses = choice_responses;
        this.good_answer = good_answer;
        this.right_answer = right_answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUrl_extra() {
        return url_extra;
    }

    public void setUrl_extra(String url_extra) {
        this.url_extra = url_extra;
    }

    public List<String> getChoice_responses() {
        return choice_responses;
    }

    public void setChoice_responses(List<String> choice_responses) {
        this.choice_responses = choice_responses;
    }

    public String getGood_answer() {
        return good_answer;
    }

    public void setGood_answer(String good_answer) {
        this.good_answer = good_answer;
    }

    public boolean isRight_answer() {
        return right_answer;
    }

    public void setRight_answer(boolean right_answer) {
        this.right_answer = right_answer;
    }

    public void setRight_answer(){
        this.right_answer = true;
    }
}

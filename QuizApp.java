import java.util.ArrayList;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        // Sample quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", List.of("London", "Paris", "Berlin", "Rome"), 2));
        questions.add(new QuizQuestion("What is the largest planet in our solar system?", List.of("Earth", "Jupiter", "Mars", "Saturn"), 2));
        questions.add(new QuizQuestion("Who wrote 'Romeo and Juliet'?", List.of("William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"), 1));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
2
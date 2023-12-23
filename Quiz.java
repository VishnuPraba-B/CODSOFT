import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private boolean answered;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
        this.answered = false;
    }

    public void start() {
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question: " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            startTimer();
            waitForAnswer(currentQuestion);
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        timer.cancel();
        timer.purge();
    
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("Time's up! Moving to the next question.");
                    stopTimer();
                    currentQuestionIndex++;
                    displayNextQuestion();
                }
            }
        }, 10000); // Timer set for 10 seconds
    }
    

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private void waitForAnswer(QuizQuestion currentQuestion) {
        Scanner scanner = new Scanner(System.in);
        
        int userAnswer;
        while (true) {
            System.out.print("Enter your answer (1-" + currentQuestion.getOptions().size() + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
                if (userAnswer >= 1 && userAnswer <= currentQuestion.getOptions().size()) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + currentQuestion.getOptions().size());
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    
        stopTimer();
        checkAnswer(currentQuestion, userAnswer);
    }
    

    private void checkAnswer(QuizQuestion currentQuestion, int userAnswer) {
        answered = true;
        if (userAnswer == currentQuestion.getCorrectOption()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was option " + currentQuestion.getCorrectOption());
        }

        currentQuestionIndex++;
        displayNextQuestion();
    }

    private void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your final score: " + score);
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}

package pl.apka.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;

    ArrayList<Integer> answers = new ArrayList<Integer>();

    int locationOfCorrectAnswer;

    TextView resultTextView;

    int score = 0;
    int numberOfQuestions = 0;

    TextView scoreTextView;

    Button button0;
    Button button1;
    Button button2;
    Button button3;

    TextView sumTextView;

    public void chooseAnswer (View view){
       if ( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
           resultTextView.setText("Correct!");
            score++;

       } else {
           resultTextView.setText("Incorrect!");
       }

        numberOfQuestions++;
        scoreTextView.setText(score+" / " + numberOfQuestions);
        newQuestion();

    }

    public void start (View view) {

        goButton.setVisibility(view.INVISIBLE);
    }

    public void newQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+ " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i =0; i<4; i++) {
            if (i == locationOfCorrectAnswer){
                answers.add(a+b); } else {
                int wrongAnswer= rand.nextInt(41);

                while (wrongAnswer==a+b) {
                    wrongAnswer= rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        resultTextView = findViewById(R.id.resultTextView);

        goButton = findViewById(R.id.goButton);

        scoreTextView = findViewById(R.id.pointsTextView);


    }
}

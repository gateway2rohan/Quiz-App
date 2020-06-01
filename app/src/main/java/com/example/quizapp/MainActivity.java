package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton1997;
    RadioButton radioButton1998;
    RadioButton radioButton1999;
    CheckBox questionTwoGooglePixel;
    CheckBox questionTwoGoogleHome;
    CheckBox questionTwoIPhone;
    EditText userInputQuestionThree;
    RadioButton radioButtonAlwaysFirst;
    RadioButton radioButtonDontBeEvil;
    RadioButton radioButtonTurningThePages;
    RadioButton radioButtonSteveJobs;
    RadioButton radioButtonSergeyBrin;
    RadioButton radioButtonBillGates;
    Button submit;
    Button reset;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton1997 = (RadioButton) findViewById(R.id.radio_1997);
        radioButton1998 = (RadioButton) findViewById(R.id.radio_1998);
        radioButton1999 = (RadioButton) findViewById(R.id.radio_1999);
        questionTwoGooglePixel = (CheckBox) findViewById(R.id.checkboxQuest2AnswerGooglePixel);
        questionTwoGoogleHome = (CheckBox) findViewById(R.id.checkboxQuest2AnswerGoogleHome);
        questionTwoIPhone = (CheckBox) findViewById(R.id.checkboxQuest2AnswerIPhone);
        userInputQuestionThree = (EditText) findViewById(R.id.answerGoogle);
        radioButtonAlwaysFirst = (RadioButton) findViewById(R.id.radio_alwaysFirst);
        radioButtonDontBeEvil = (RadioButton) findViewById(R.id.radio_DontBeEvil);
        radioButtonTurningThePages = (RadioButton) findViewById(R.id.radio_TurningThePage);
        radioButtonSteveJobs = (RadioButton) findViewById(R.id.radio_Steve_Jobs);
        radioButtonSergeyBrin = (RadioButton) findViewById(R.id.radio_SergeyBrin);
        radioButtonBillGates = (RadioButton) findViewById(R.id.radio_BillGates);
        submit = (Button)findViewById(R.id.submitButton);
        reset = (Button)findViewById(R.id.resetButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAllQuestions();
                Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });
    }

    private void checkQuestionOneAnswers(){
        boolean isQuestionTwo1997Checked = radioButton1997.isChecked();
        if (isQuestionTwo1997Checked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        boolean isQuestionTwoGooglePixelChecked = questionTwoGooglePixel.isChecked();
        boolean isQuestionTwoGoogleHomeChecked = questionTwoGoogleHome.isChecked();
        boolean isQuestionTwoIPhoneChecked = questionTwoIPhone.isChecked();

        if (isQuestionTwoGooglePixelChecked && isQuestionTwoGoogleHomeChecked && !isQuestionTwoIPhoneChecked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        String name = userInputQuestionThree.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("googol")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        boolean isQuestionFourChecked = radioButtonDontBeEvil.isChecked();
        if (isQuestionFourChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        boolean isQuestionFiveChecked = radioButtonSergeyBrin.isChecked();
        if (isQuestionFiveChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers()   {
        correctAnswers = 0;
    }

    private void resetQuiz(){
        if (radioButton1997.isChecked()) radioButton1997.setChecked(false);
        if (radioButton1998.isChecked()) radioButton1998.setChecked(false);
        if (radioButton1999.isChecked()) radioButton1999.setChecked(false);
        if (questionTwoGooglePixel.isChecked()) questionTwoGooglePixel.setChecked(false);
        if (questionTwoGoogleHome.isChecked()) questionTwoGoogleHome.setChecked(false);
        if (questionTwoIPhone.isChecked()) questionTwoIPhone.setChecked(false);
        userInputQuestionThree.getText().clear();
        if (radioButtonAlwaysFirst.isChecked()) radioButtonAlwaysFirst.setChecked(false);
        if (radioButtonDontBeEvil.isChecked()) radioButtonDontBeEvil.setChecked(false);
        if (radioButtonTurningThePages.isChecked()) radioButtonTurningThePages.setChecked(false);
        if (radioButtonSteveJobs.isChecked()) radioButtonSteveJobs.setChecked(false);
        if (radioButtonSergeyBrin.isChecked()) radioButtonSergeyBrin.setChecked(false);
        if (radioButtonBillGates.isChecked()) radioButtonBillGates.setChecked(false);
        resetCounterCorrectAnswers();
    }
}

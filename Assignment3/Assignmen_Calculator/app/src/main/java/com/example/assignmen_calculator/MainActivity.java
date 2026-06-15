package com.example.assignmen_calculator;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtExpression,txtAnswer;

    Button btnPlus, btnSub, btnMultiplication, btnDivision, btnModulus,btnAnswer;
    Button btnClear, btnBack;
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnZero, btnZeroZero,btnDot;
    double num1, num2, answer;
    String operator;
    Boolean startNewNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         startNewNumber = false;
         txtAnswer = findViewById(R.id.txtAnswer);
         txtExpression = findViewById(R.id.txtExpression);
         btnClear = findViewById(R.id.btnClear);
         btnBack = findViewById(R.id.btnBack);
         btnPlus = findViewById(R.id.btnPlus);
         btnSub = findViewById(R.id.btnSub);
         btnMultiplication = findViewById(R.id.btnMultiplication);
         btnDivision = findViewById(R.id.btnDivision);
         btnModulus = findViewById(R.id.btnModulus);
         btnOne = findViewById(R.id.btnOne);
         btnTwo = findViewById(R.id.btnTwo);
         btnThree = findViewById(R.id.btnThree);
         btnFour = findViewById(R.id.btnFour);
         btnFive = findViewById(R.id.btnFive);
         btnSix = findViewById(R.id.btnSix);
         btnSeven = findViewById(R.id.btnSeven);
         btnEight = findViewById(R.id.btnEight);
         btnNine = findViewById(R.id.btnNine);
         btnZeroZero = findViewById(R.id.btnZeroZero);
         btnZero = findViewById(R.id.btnZero);
         btnDot = findViewById(R.id.btnDot);
         btnAnswer = findViewById(R.id.btnAnswer);

         btnClear.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 txtExpression.setText("");
                 txtAnswer.setText("");
             }
         });

         btnBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String exp = txtExpression.getText().toString();
                 if(!exp.isEmpty()){
                     exp = exp.substring(0, exp.length() - 1);
                     txtExpression.setText(exp);
                 }
             }
         });
         btnPlus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operator = "+";
                 firstNumberFetching();
                 startNewNumber = true;
             }
         });
         btnSub.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operator = "-";
                 firstNumberFetching();
                 startNewNumber = true;
             }
         });
         btnMultiplication.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operator = "*";
                 firstNumberFetching();
                 startNewNumber = true;
             }
         });
         btnDivision.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operator = "/";
                 firstNumberFetching();
                 startNewNumber = true;
             }
         });
         btnOne.setOnClickListener(v -> secondNumberAppend("1"));
         btnTwo.setOnClickListener(v -> secondNumberAppend("2"));
         btnThree.setOnClickListener(v -> secondNumberAppend("3"));
         btnFour.setOnClickListener(v -> secondNumberAppend("4"));
         btnFive.setOnClickListener(v -> secondNumberAppend("5"));
         btnSix.setOnClickListener(v -> secondNumberAppend("6"));
         btnSeven.setOnClickListener(v -> secondNumberAppend("7"));
         btnEight.setOnClickListener(v -> secondNumberAppend("8"));
         btnNine.setOnClickListener(v -> secondNumberAppend("9"));
         btnZeroZero.setOnClickListener(v -> secondNumberAppend("00"));
         btnZero.setOnClickListener(v -> secondNumberAppend("0"));
         btnDot.setOnClickListener(v -> secondNumberAppend("."));
         btnAnswer.setOnClickListener(v -> expressionEvaluation());

    }


        public void firstNumberFetching(){
            num1 = Double.parseDouble(txtExpression.getText().toString());
            startNewNumber = true;
        }

        public void secondNumberAppend(String digit){
            if(startNewNumber){
                txtExpression.setText(digit);
                startNewNumber = false;
            }else {
                txtExpression.append(digit);
            }
        }

        public void expressionEvaluation(){
            num2 = Double.parseDouble(txtExpression.getText().toString());
            switch (operator){
                case "+":
                    answer = num1 + num2;
                    txtAnswer.setText(String.valueOf(answer));
                    break;
                case "-":
                    answer = num1 - num2;
                    txtAnswer.setText(String.valueOf(answer));
                    break;
                case "*":
                    answer = num1 * num2;txtAnswer.setText(String.valueOf(answer));
                    break;
                case "/":
                    answer = num1 / num2;txtAnswer.setText(String.valueOf(answer));
                    break;
            }
        }

}
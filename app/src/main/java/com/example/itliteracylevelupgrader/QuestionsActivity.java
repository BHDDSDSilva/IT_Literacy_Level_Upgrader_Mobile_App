package com.example.itliteracylevelupgrader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "01). Select one of the true statement for the compiler",
            "02). The language processor translates the program into object code as a whole",
            "03). Finding and solving errors in the source code is",
            "04). ___________language is not an object oriented programming language",
            "05). Communication between user and the computer is______________",
            "06). Translates the source code into machine language",
            "07). Computer programs are consisted of code and ________________",
            "08). Right syntax of control statement IF is___________________",
            "09). System.out.println(num); will display_____________________",
            "10). System.out.print(“Good Luck” + ); This statement missed. Which of the following is suitable?",
            "11). What is a Web Crawler?",
            "12). Which of the following is also called First order Logic?",
            "13). The Personal Consultant is based on which of the following?",
            "14). The general concept and process of forming definitions from examples of concepts to be learned",
            "15). To build a data mining model data used for."
    };
    String answers[] = {"All of above","Compiler","Debugging","c++","Programming language",
                        "Language processor","Data","if (condition) statement ;","Value of variable num","Variable after +",
                        "Heuristic search","All of these","All of above","Induction","Training data"};
    String opt[] = {
            "The input of the compiler is source program","It translates the source code into object code as a whole"," The output of the compiler is object code","All of above",
            "linker","Debugger","Compiler","interpreter",
            "Desk checking","Debugging","Decoding","Testing",
            "Visual basic","C","Java","C++",
            "Programming language","Software","Syntax ","English language",
            "Language processor ","Programming language","Operating system","All of these",
            "Loops","Numbers","Data","Information",
            "if (condition) statement ;","IF (CONDITION) THEN STATEMENT ;","if(condition) then statement;","if(CONDITION) statement",
            "Type of variable","Any number","Value of variable num","Name of the variable",
            "Single quotes","ln in print command","Variable after +","Comma",
            "Simple search","Online search","Heuristic search","None of these",
            "Lower Order Calculus","First Order Predicate Calculus","Quantification Theory","All of these",
            "EMYCIN","OPS5+","XCON","All of above",
            "Induction","Abduction","Deduction","Conjunction",
            "Validation data","Hidden data","Test data","Training data"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_screen);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Congrats!!! Your answer is correct.", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Oops!!! Your answer is incorrect.", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }


}

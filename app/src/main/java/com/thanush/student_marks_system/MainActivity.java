package com.thanush.student_marks_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText student_name, marks1, marks2, marks3, marks_Total, marks_avg, marks_grade;
    Button add, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_name = findViewById(R.id.student_name);
        marks1 = findViewById(R.id.marks1);
        marks2 = findViewById(R.id.marks2);
        marks3 = findViewById(R.id.marks3);
        marks_Total = findViewById(R.id.total);
        marks_avg = findViewById(R.id.avg);
        marks_grade = findViewById(R.id.grade);

        add = findViewById(R.id.btnAdd);
        clear = findViewById(R.id.btnClear);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    markCalculate();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    clear();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });


    }

    public void markCalculate() {
        int mark1, mark2, mark3, total;
        double avg;
        String grade;

        mark1 = Integer.parseInt(marks1.getText().toString());
        mark2 = Integer.parseInt(marks2.getText().toString());
        mark3 = Integer.parseInt(marks3.getText().toString());

        total = mark1 + mark2 + mark3;

        marks_Total.setText(String.valueOf(total));

        avg = total / 3;

        marks_avg.setText(String.valueOf(avg));


        if (avg > 75) {
            marks_grade.setText("A");
        } else if (avg > 65) {
            marks_grade.setText("B");
        } else if (avg > 55) {
            marks_grade.setText("C");
        } else if (avg > 45) {
            marks_grade.setText("S");
        } else {
            marks_grade.setText("Fail");

        }


    }

    public void clear() {
        student_name.setText("");
        marks1.setText("");
        marks2.setText("");
        marks3.setText("");
        marks_Total.setText("");
        marks_avg.setText("");
        marks_grade.setText("");
        student_name.requestFocus();
    }
}
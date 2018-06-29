package com.example.android.quizsamurai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*Computes the total points earned from the questions
    *The trim() removes white trailing and leading spaces to help curb issues with autocorect features
    *of most keyboards
    */
    int point = 0;
    public void computeScore(View view){
        /*for question 1*/
        EditText question_1 = (EditText) findViewById(R.id.question_1_answer);
        String question_1_answer = question_1.getText().toString().toLowerCase().trim();
        //check if nothing is inputed
        if (question_1_answer.equals("")){
            return;
        }else{
            editTextType(1,question_1_answer);
        }

        //for question 2
        CheckBox austria_check = (CheckBox) findViewById(R.id.question_2_check_a);
        CheckBox australia_check = (CheckBox) findViewById(R.id.question_2_check_b);
        CheckBox gibralter_check = (CheckBox) findViewById(R.id.question_2_check_c);
        CheckBox san_marino_check = (CheckBox) findViewById(R.id.question_2_check_d);
        Boolean hasAustria_check = austria_check.isChecked();
        Boolean hasAustralia_check = australia_check.isChecked();
        Boolean hasGibralter_check = gibralter_check.isChecked();
        Boolean hasSanMarino_check = san_marino_check.isChecked();
        checkBoxType(2, hasAustria_check,hasAustralia_check,hasGibralter_check,hasSanMarino_check);

        //for question 3
        RadioGroup question_3_radio_group = (RadioGroup) findViewById(R.id.question_3_radiogroup);
        int selected_id_3 = question_3_radio_group.getCheckedRadioButtonId();
        RadioButton question_3 = (RadioButton) findViewById(selected_id_3);
        //check if no RadioButton is selected
        if (question_3_radio_group.getCheckedRadioButtonId() == -1){
            return;
        }else{
            String question_3_answer = question_3.getText().toString().toLowerCase();
            radioButtonType(3,question_3_answer);
        }

        //for question 4
        EditText question_4 = (EditText) findViewById(R.id.question_4_answer);
        String question_4_answer = question_4.getText().toString().toLowerCase().trim();
        if (question_4_answer.equals("")){
            return;
        }else{
            editTextType(4,question_4_answer);
        }

        //for question 5
        RadioGroup question_5_radio_group = (RadioGroup) findViewById(R.id.question_5_radiogroup);
        int selected_id_5 = question_5_radio_group.getCheckedRadioButtonId();
        RadioButton question_5 = (RadioButton) findViewById(selected_id_5);
        if (question_5_radio_group.getCheckedRadioButtonId() == -1){
            return;
        }else{
            String question_5_answer = question_5.getText().toString().toLowerCase();
            radioButtonType(5,question_5_answer);
        }

        //for question 6
        EditText question_6 = (EditText) findViewById(R.id.question_6_answer);
        String question_6_answer = question_6.getText().toString().toLowerCase().trim();
        if (question_6_answer.equals("")){
            return;
        }else{
            editTextType(6,question_6_answer);
        }

        //for question 7
        CheckBox messi_check = (CheckBox) findViewById(R.id.question_7_check_a);
        CheckBox ronaldinho_check = (CheckBox) findViewById(R.id.question_7_check_b);
        CheckBox sallah_check = (CheckBox) findViewById(R.id.question_7_check_c);
        CheckBox ronaldo_check = (CheckBox) findViewById(R.id.question_7_check_d);
        Boolean hasMessi_check = messi_check.isChecked();
        Boolean hasRonaldinho_check = ronaldinho_check.isChecked();
        Boolean hasSallah_check = sallah_check.isChecked();
        Boolean hasRonaldo_check = ronaldo_check.isChecked();
        checkBoxType(7, hasMessi_check,hasRonaldinho_check,hasSallah_check,hasRonaldo_check);

        //for question 8
        RadioGroup question_8_radio_group = (RadioGroup) findViewById(R.id.question_8_radiogroup);
        int selected_id_8 = question_8_radio_group.getCheckedRadioButtonId();
        RadioButton question_8 = (RadioButton) findViewById(selected_id_8);
        if (question_8_radio_group.getCheckedRadioButtonId() == -1){
            return;
        }else{
            String question_8_answer = question_8.getText().toString().toLowerCase();
            radioButtonType(8,question_8_answer);
        }

        /*The second parameter of a toast must be a character or string so i converted the Int to string*/
        if (point > 6){
            Toast.makeText(this, "Good Job! You got "+String.valueOf(point)+ " correct out of 8 questions", Toast.LENGTH_SHORT).show();
            point = 0;
        }else{
            Toast.makeText(this, "Nice Try! You got "+String.valueOf(point)+ " correct out of 8 questions", Toast.LENGTH_SHORT).show();
            point = 0;
        }

    }
    /*award points to questions of type EditText*/
    private int editTextType(int question_number, String user_answer){
        if (question_number == 1){
            if (user_answer.equals("drought")){
                point = point + 1;
            }
        }
        if (question_number == 4){
            if (user_answer.equals("lightning")){
                point = point + 1;
            }
        }
        if (question_number == 6){
            if (user_answer.equals("seismology")){
                point = point + 1;
            }
        }
        return point;
    }
    /*award points to questions of type CheckBox*/
    private int checkBoxType(int question_number, boolean a_check, boolean b_check, boolean c_check, boolean d_check){
        if (question_number == 2) {
            if (a_check == true && b_check == false && c_check == true && d_check == true){
                point = point + 1;
            }
        }
        if (question_number == 7){
            if (a_check == true && b_check == false && c_check == true && d_check == true){
                point = point + 1;
            }
        }
        return point;
    }
    /*award points to question of type RadioButton*/
    private int radioButtonType(int question_number, String radio_button_text){
        if (question_number == 3){
            if (radio_button_text.equals("false")){
                point = point + 1;
            }
        }
        if (question_number == 5){
            if (radio_button_text.equals("true")){
                point = point + 1;
            }
        }
        if (question_number == 8){
            if (radio_button_text.equals("true")){
                point = point + 1;
            }

        }
        return point;
    }
}

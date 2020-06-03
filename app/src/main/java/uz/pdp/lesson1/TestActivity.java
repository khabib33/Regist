package uz.pdp.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private List<TestModel> testModelList;
    int count = 0;
    private TextView question;
    private RadioGroup radioGroup;
    private Button button;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private String answer = "";
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        loadData();
        question = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radio);
        button = findViewById(R.id.button);
        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);
        radioButton3 = findViewById(R.id.radio3);
        radioButton4 = findViewById(R.id.radio4);
        setTextViews(count);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if (radioButton !=null) {
                    answer = radioButton.getText().toString();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTest();
            }
        });
    }

    private void checkTest() {
        if (answer.equals(testModelList.get(count).getRealAnswer())){
            score++;
            Toast.makeText(this, score+"", Toast.LENGTH_SHORT).show();
        }
        count++;
        radioGroup.clearCheck();
        setTextViews(count);
    }

    private void setTextViews(int count) {
        question.setText(testModelList.get(count).getQuestion());
        radioButton1.setText(testModelList.get(count).getAnswer1());
        radioButton2.setText(testModelList.get(count).getAnswer2());
        radioButton3.setText(testModelList.get(count).getAnswer3());
        radioButton4.setText(testModelList.get(count).getAnswer4());
        answer = "";
    }

    private void loadData() {
        testModelList = new ArrayList<>();
        testModelList.add(new TestModel("Alisher Navoiy kim?","Shoir","Qo'shiqchi","Dasturchi","Hech kim","Shoir"));
        testModelList.add(new TestModel("Anvar Sanayev kim?","Shoir","Qo'shiqchi","Dasturchi","Hech kim","Qo'shiqchi"));
        testModelList.add(new TestModel("Stiv Jobs kim?","Shoir","Qo'shiqchi","Dasturchi","Hech kim","Dasturchi"));
    }
}

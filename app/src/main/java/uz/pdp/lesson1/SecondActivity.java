package uz.pdp.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView1 = findViewById(R.id.key1);
        TextView textView2 = findViewById(R.id.key2);

        String emailText = getIntent().getStringExtra("key1");
        String passwordText = getIntent().getStringExtra("key2");

        textView1.setText(emailText);
        textView2.setText(passwordText);
    }
}

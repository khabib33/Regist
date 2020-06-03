package uz.pdp.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.enter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                if (!emailText.isEmpty()){
                    if (!passwordText.isEmpty()){
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("key1",emailText);
                        intent.putExtra("key2",passwordText);
                        startActivity(intent);
                    }else {
                        password.setError("Password maydon to'ldirilmagan");
                    }
                }else {
                    email.setError("Email maydon to'ldirilmagan");
                }


            }
        });

    }
}

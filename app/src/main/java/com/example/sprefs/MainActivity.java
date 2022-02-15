package com.example.sprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_ID = "messages_prefs";
    private EditText enterMessage;
    private TextView showMessage;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.button);
        enterMessage = findViewById(R.id.editText);
        showMessage = findViewById(R.id.textView);

        saveButton.setOnClickListener(view -> {
            String message = enterMessage.getText().toString().trim();
            SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("message", message);
            editor.apply(); // saving to disk
            //editor.commit();

        });

        //Get data back from SP
        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getShareData.getString("message", "Nothing yet");

        showMessage.setText(value);
    }
}
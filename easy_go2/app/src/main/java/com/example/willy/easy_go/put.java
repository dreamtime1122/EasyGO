package com.example.willy.easy_go;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class put extends AppCompatActivity {
    int index = 0;//which button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);

        Button put_button = findViewById(R.id.put_button);
        put_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "請說～");
                try {
                    index = 1;
                    startActivityForResult(intent, 200);
                }
                catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Intent problem", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btn_sent = findViewById(R.id.btn_sent);
        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "請說～");
                try {
                    index = 2;
                    startActivityForResult(intent, 200);
                }
                catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Intent problem", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                if(index == 1)
                {
                    //result.get(0) 語音輸入的字串
                    Toast.makeText(put.this,result.get(0),
                            Toast.LENGTH_SHORT).show();
                    index = 0;
                }
                else if(index == 2)
                {
                    //result.get(0) 語音輸入的字串
                    Toast.makeText(put.this,"位於" + result.get(0),
                            Toast.LENGTH_SHORT).show();
                    index = 0;
                }
            }
        }
    }
}

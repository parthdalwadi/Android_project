package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        info = findViewById(R.id.details);

        Intent i = getIntent();
        String summary = i.getStringExtra("allInfo");
        info.setText(summary);

    }
}

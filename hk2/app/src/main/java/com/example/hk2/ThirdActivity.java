package com.example.hk2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView pathText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        pathText = findViewById(R.id.path_text);

        String incomingPath = getIntent().getStringExtra("path");
        final String path;
        if (incomingPath == null) path = "3";
        else path = incomingPath + "->3";
        pathText.setText("目前路徑: " + path);

        findViewById(R.id.btn_to_first).setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            intent.putExtra("path", path);
            startActivity(intent);
        });

        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());

        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());
    }
}

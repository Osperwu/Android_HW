package com.example.hk2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView pathText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        pathText = findViewById(R.id.path_text);

        String incomingPath = getIntent().getStringExtra("path");
        final String path;
        if (incomingPath == null) path = "2";
        else path = incomingPath + "->2";
        pathText.setText("目前路徑: " + path);

        findViewById(R.id.btn_to_third).setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("path", path);
            startActivity(intent);
        });

        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());

        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());
    }
}

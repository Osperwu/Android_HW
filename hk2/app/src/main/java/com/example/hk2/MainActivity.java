package com.example.hk2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private RadioGroup colorRadioGroup;
    private Button checkoutButton;
    private TextView resultTextView;

    private CheckBox dish1CheckBox;
    private CheckBox dish2CheckBox;
    private CheckBox dish3CheckBox;
    private CheckBox dish4CheckBox;
    private CheckBox dish5CheckBox;

    TextView pathText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        20250522作業
        //path
        pathText = findViewById(R.id.path_text);

        // 接收路徑資料
        String incomingPath = getIntent().getStringExtra("path");
        final String path;
        if (incomingPath == null) path = "1";
        else path = incomingPath + "->1";
        pathText.setText("目前路徑: " + path);

        findViewById(R.id.btn_to_second).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("path", path);
            startActivity(intent);
        });

        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());

        /// /////////////////////////

        // 取得 UI 元件的參考
        mainLayout = findViewById(R.id.mainLayout);
        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        checkoutButton = findViewById(R.id.checkoutButton);
        resultTextView = findViewById(R.id.resultTextView);

        dish1CheckBox = findViewById(R.id.dish1CheckBox);
        dish2CheckBox = findViewById(R.id.dish2CheckBox);
        dish3CheckBox = findViewById(R.id.dish3CheckBox);
        dish4CheckBox = findViewById(R.id.dish4CheckBox);
        dish5CheckBox = findViewById(R.id.dish5CheckBox);

        // 設定背景顏色選擇的監聽器
        colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.redRadioButton) {
                    mainLayout.setBackgroundColor(Color.RED);
                } else if (checkedId == R.id.greenRadioButton) {
                    mainLayout.setBackgroundColor(Color.GREEN);
                } else if (checkedId == R.id.blueRadioButton) {
                    mainLayout.setBackgroundColor(Color.BLUE);
                } else if (checkedId == R.id.yellowRadioButton) {
                    mainLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        // 設定結帳按鈕的監聽器
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedDishesCount = getSelectedDishesCount();
                if (selectedDishesCount == 3) {
                    resultTextView.setText("總金額：50 元");
                } else if (selectedDishesCount == 4) {
                    resultTextView.setText("總金額：60 元");
                } else {
                    resultTextView.setText("請選擇 3 樣或 4 樣菜！");
                }
            }
        });


    }

    // 計算選取的菜色數量
    private int getSelectedDishesCount() {
        int count = 0;
        if (dish1CheckBox.isChecked()) count++;
        if (dish2CheckBox.isChecked()) count++;
        if (dish3CheckBox.isChecked()) count++;
        if (dish4CheckBox.isChecked()) count++;
        if (dish5CheckBox.isChecked()) count++;
        return count;
    }
}
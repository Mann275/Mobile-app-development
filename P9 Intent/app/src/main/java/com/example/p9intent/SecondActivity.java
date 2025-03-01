package com.example.p9intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity; // Import AppCompatActivity

public class SecondActivity extends AppCompatActivity {
    private TextView tvReceivedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvReceivedData = findViewById(R.id.tvReceivedData);

        String name = getIntent().getStringExtra("user_name");

        if (name != null && !name.isEmpty()) {
            tvReceivedData.setText("Welcome, " + name + "!");
        } else {
            tvReceivedData.setText("Welcome, Guest!");
        }
    }
}

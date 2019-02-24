package com.example.task01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String TEXT_VIEW_KEY = "SecondActivity.Key";

    private TextView mTextView;
    private Button mButton;
    private static final String GOOGLE_SEARCH_ENGINE = "https://www.google.com/search?q=";
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        query = bundle.getString(TEXT_VIEW_KEY);
        mTextView.setText(query);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(GOOGLE_SEARCH_ENGINE + query);
                Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(gSearchIntent);
            }
        });
    }
}
package com.example.task01;

/**
 * Часть 1.
 * Создать проект с пустой активити.
 * В разметку добавить EditText и Button.
 * Вводим текст и по нажатию на Button отображаем Toast с введенным текстом. Если в EditText нет
 * текста, то по нажатию на Button ничего не происходит.
 *
 * Часть 2.
 * Создать второй экран с TextView и Button
 * Второй экран теперь открывается при нажатии на кнопку на первом экране, если в EditText есть
 * текст. (Тост все так же отображается).
 * В TextView передаем текст из EditText первого экрана.
 *
 * Часть 3.
 * Добавить любой градиент в качестве фона обоим экранам.
 * По нажатию на Button второго экрана открывается браузер со страницей google.com с вбитым в поиск
 * словом, которое отображается в TextView.
 *
 * @created 18.02.2019
 * @author Andrey Dudin <programmer1973@mail.ru>
 * @version 0.1.0.2019.02.18
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_text_view);
        mButton = findViewById(R.id.button_view);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = mEditText.getText().toString();

                if(!isTextFieldEmpty(enteredText)) {
                    showText(enteredText);
                    Intent intentToSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                    intentToSecondActivity.putExtra(SecondActivity.TEXT_VIEW_KEY, enteredText);
                    startActivity(intentToSecondActivity);
                }
            }
        });
    }

    private boolean isTextFieldEmpty(String string) {
        return TextUtils.isEmpty(string);
    }

    private void showText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
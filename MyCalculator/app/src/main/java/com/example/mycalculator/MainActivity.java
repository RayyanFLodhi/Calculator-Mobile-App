package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, button_16, btn_dot, btn_clear, btn_plus, btn_equal;
    TextView text_display;
    Evaluate e;

    // This is to evaluate the math expression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = (Button) findViewById(R.id.btn0); // 0
        btn1 = (Button) findViewById(R.id.btn1); // 1
        btn2 = (Button) findViewById(R.id.btn2); // 2
        btn3 = (Button) findViewById(R.id.btn3); // 3
        button_5 = (Button) findViewById(R.id.button5); // 4
        button_6 = (Button) findViewById(R.id.button6); // 5
        button_7 = (Button) findViewById(R.id.button7); // 6
        button_8 = (Button) findViewById(R.id.button8); // -
        button_9 = (Button) findViewById(R.id.button9); // 7
        button_10 = (Button) findViewById(R.id.button10); // 8
        button_11 = (Button) findViewById(R.id.button11); // 9
        button_12 = (Button) findViewById(R.id.button12); // X (multiplies)
        button_16 = (Button) findViewById(R.id.button16); // divides
        btn_dot = (Button) findViewById(R.id.btn_dot); // 6
        btn_plus = (Button) findViewById(R.id.btn_plus); // +
        btn_equal = (Button) findViewById(R.id.btn_equal); // =
        btn_clear = (Button) findViewById(R.id.btn_clear); // C
        text_display = (TextView) findViewById(R.id.textview_input_display); // display


        setClickListeners();
    }

    private void setClickListeners() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_10.setOnClickListener(this);
        button_11.setOnClickListener(this);
        button_12.setOnClickListener(this);
        button_16.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                addNumber("0");
                break;
            case R.id.btn1:
                addNumber("1");
                break;
            case R.id.btn2:
                addNumber("2");
                break;
            case R.id.btn3:
                addNumber("3");
                break;
            case R.id.button5:
                addNumber("4");
                break;
            case R.id.button6:
                addNumber("5");
                break;
            case R.id.button7:
                addNumber("6");
                break;
            case R.id.button9:
                addNumber("7");
                break;
            case R.id.button10:
                addNumber("8");
                break;
            case R.id.button11:
                addNumber("9");
                break;
            case R.id.btn_dot:
                addNumber(".");
                break;
            case R.id.button8:
                addNumber("-");
                break;
            case R.id.button12:
                addNumber("*");
                break;
            case R.id.button16:
                addNumber("/");
                break;
            case R.id.btn_plus:
                addNumber("+");
                break;
            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (Exception e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
        }
    }


    private String evaluate(String expression) throws Exception {
//        Expression e = new ExpressionBuilder(expression).build();
//        double result = e.evaluate();
//
//        // Check if the result is a whole number and the original expression was integer-based
//        if (result == (long) result && !expression.contains(".")) {
//            return String.format("%d", (long) result);
//        } else {
//            BigDecimal decimal = new BigDecimal(result);
//            return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
//        }

        BigDecimal decimal = e.evaluate(expression);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    private void addNumber(String number) {
        if (text_display.getText().toString().equals("Error")) {
            clear_display();
        }
        text_display.setText(text_display.getText() + number);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
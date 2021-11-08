package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    EditText h;
    EditText w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText) findViewById(R.id.ed);                           // 取得身高物件
        w = (EditText) findViewById(R.id.ed0);                           // 取得體重物件
        Button submit = (Button) findViewById(R.id.button1);


    }


    public void sA(View arg0) {
        //判斷條件 身高 跟 體重 都有輸入值才執行
        if (!("".equals(h.getText().toString())
                || "".equals(w.getText().toString()))) {
            float fh = Float.parseFloat(h.getEditableText().toString());      // 取得 身高輸入值
            float fw = Float.parseFloat(w.getEditableText().toString());     // 取得 體重輸入值
            float fresult;                                     // BMI值 計算結果
            TextView result = (TextView) findViewById(R.id.tv4);// 取得 顯示結果 物件
            TextView r0= (TextView) findViewById(R.id.tv5);
            fh = fh / 100; // 計算BMI
            fh = fh * fh;  // 計算BMI

            NumberFormat nf = NumberFormat.getInstance();   // 數字格式
            nf.setMaximumFractionDigits(2);                 // 限制小數第二位
            fresult = fw / fh;                                // 計算BMI
            result.setText(nf.format(fw / fh) + "");           // 顯示BMI計算結果

            if( 18.5 <= fw/fh  ){
                if (  fw/fh < 24  ) {
                    r0.setText("檢測結果為正常");
                }
                else {
                    r0.setText("檢測結果為異常");
                }
            }
            else {
                r0.setText("檢測結果為異常");
            }







        }
    }
}


package com.example.zhengshujuan.unknow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity  {
    private Button btn_login;
    private EditText mEditText1;
    private EditText mEditText2;
    private SharedHelper sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mEditText1= (EditText) findViewById(R.id.et_1);
        mEditText2= (EditText) findViewById(R.id.et_2);
     //   mBtnVisible= (Button) findViewById(R.id.btn_visible);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paswd1=mEditText1.getText().toString()
                        .trim();
                String paswd2=mEditText2.getText().toString()
                        .trim();
                if (paswd1==null||paswd2==null){
                    Toast.makeText(DemoActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!paswd1.equals(paswd2)){
                    Toast.makeText(DemoActivity.this, "两次密码输入不相符,请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                sh.save(paswd1,paswd2);

                Intent intent=new Intent(DemoActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
}

//    @Override
//    public void onClick(View v) {
//
//
//    }
}

package com.example.zhengshujuan.unknow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    public static final String FRIST = "frist";
    public static final String IS_FRIST = "isFrist";
    private Button mBtnOn;
    boolean isFrist = false;
    private Button btn_login;
    private EditText mEditText1;
    private EditText mEditText2;
    private Context context;
    private SharedHelper sh;
    private String passwd1;
    private String passwd2;
    private boolean flag=false;
    private Button mBtnVisible;
    private EditText ETrepeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =getApplicationContext();
        sh =new SharedHelper(context);

        mBtnVisible= (Button) findViewById(R.id.btn_visible);
        btn_login= (Button) findViewById(R.id.btn_login);
        mBtnOn = (Button) findViewById(R.id.btn_on);
        mBtnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFrist) {//第一次运行
                    SetPswdDialog();
                    isFrist = true;
                } else {
                    SetPswdDialogS();
                }


            }
        });



        //    btn_login.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
//                if (flag==true){
//                    mEditText1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                flag=false;
//                    mBtnVisible.setText("密码不可见");
//                }else {
//                    mEditText1.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    flag=true;
//                    mBtnVisible.setText("密码可见");
//                }
  }
//    private static SharedPreferences getPreferences(Context context){
//
//
//    }
private void getPaswd(){
    SharedHelper.read(context,"mysp");
}

    private void SetPswdDialogS() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(getApplicationContext(), R.layout.login_second, null);
        builder.setView(view)
                .show();
        ETrepeat= (EditText) view.findViewById(R.id.et_repeat);
        ETrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pawd=ETrepeat.getText().toString()
                        .trim();
                if (TextUtils.isEmpty(pawd)){
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pawd.equals(getPaswd().)){

                }
            }
        });


    }

    private void SetPswdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(getApplicationContext(), R.layout.activity_demo, null);
        builder.setView(view)
                .show();
//        final AlertDialog dialog=builder.show();
        btn_login= (Button) view.findViewById(R.id.btn_login);
        mEditText1= (EditText)view. findViewById(R.id.et_1);
        mEditText2= (EditText) view.findViewById(R.id.et_2);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paswd1=mEditText1.getText().toString()
                        .trim();
                String paswd2=mEditText2.getText().toString()
                        .trim();
                if (TextUtils.isEmpty(paswd1)||TextUtils.isEmpty(paswd2)){
                    Toast.makeText(MainActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!paswd1.equals(paswd2)){
                    Toast.makeText(MainActivity.this, "两次密码输入不相符,请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                sh.save(paswd1,paswd2);

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
      //  dialog.dismiss();
    }
    private void savePreferences() {
        SharedPreferences preferences = getSharedPreferences(FRIST, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FRIST, false);
        editor.apply();
    }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_on:
//                if (!isFrist) {//第一次运行
//                    SetPswdDialog();
//                    isFrist = true;
//                } else {
//                    SetPswdDialogS();
//                }
//                break;
//            case R.id.btn_login:
//
//                if (mEditText1.getText().equals(mEditText2.getText())){
//                    Intent intent=new Intent(this,DemoActivity.class);
//                    startActivity(intent);
//                }else {
//                    Toast.makeText(MainActivity.this, "两次密码输入不符,请重新输入", Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
//
//
//    }


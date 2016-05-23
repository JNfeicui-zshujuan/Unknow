package com.example.zhengshujuan.unknow;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengshujuan on 2016/5/16.
 */
public class SharedHelper  {
    private static Context mContext;

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }

    public SharedHelper(){

    }
    public void save(String passwd1, String passwd2){
        SharedPreferences sp=mContext.getSharedPreferences("mysp",mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("passwd1",passwd1);
      //  editor.putString("passwd2",passwd2);
        editor.commit();
        Toast.makeText(mContext, "信息已保存", Toast.LENGTH_SHORT).show();
        Log.d("tag","已保存密码："+passwd1);
    }
    public static Map<String ,String> read(){
        Map<String,String> data=new HashMap<String,String>();
        SharedPreferences sp=mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        data.put("mysp",sp.getString("passwd1",""));
        return data;
    }

    public static String read(Context context, String key) {
        return read(context,key,null);


    }

    private static String read(Context context, String key, Object defValue) {
        SharedPreferences sp=mContext.getSharedPreferences("mysp",mContext.MODE_PRIVATE);
        return read(context,key,defValue);
    }

//    public static String getString(Context mContext,String key) {
//        return getString(mContext,key,null);
//    }
//
//    private static String getString(Context mContext, String key, Object defValue) {
//        SharedPreferences sp= ;
//        return sp.getString(mContext,key,defValue);
//    }
}

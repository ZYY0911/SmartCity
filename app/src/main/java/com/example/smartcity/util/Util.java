package com.example.smartcity.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @LogIn Name com.example.smartcity.util
 * @Create by 张瀛煜 on 2020/11/11 at 7:37 AM
 */
public class Util {
    public static void showDialog(String msg , Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("确定",null);
        builder.show();
    }

    private static Toast toast;
    public static void showToast(String msg,Context context){
        if (toast==null){
            toast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }
        toast.setText(msg);
        toast.show();
    }


    public static String simpleDate(String type,Date date){
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }
}

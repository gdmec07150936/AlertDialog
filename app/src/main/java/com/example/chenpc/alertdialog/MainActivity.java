package com.example.chenpc.alertdialog;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog ad;
    private AlertDialog.Builder builder;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView1);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener(){
            public void onClick ( View v){
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }

    private void dialog1() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确定要退出吗");
        ad.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis1 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    ad.dismiss();
                    MainActivity.this.finish();
                }else if (which == DialogInterface.BUTTON_NEUTRAL){
                    ad.dismiss();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",lis1);
        ad.show();
    }
    private void dialog2() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你平时忙吗");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener lis2 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时不忙";
                        break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"忙",lis2);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",lis2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",lis2);
        ad.show();
    }
    private void dialog3() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("请输入");
        ad.setMessage("你平时忙吗");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        final EditText et = new EditText(this);
        ad.setView(et);
        DialogInterface.OnClickListener lis3 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+et.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis3);
        ad.show();
    }
    private void dialog4() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlis4 = new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bselect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bselect,mlis4);
        ad = builder.create();
        ad.setTitle("复选框");
        DialogInterface.OnClickListener lis4 =new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了";
                for(int i = 0;i < bselect.length;i++){
                    if(bselect[i]){
                        str = str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis4);
        ad.show();
    }
    private void dialog5() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnClickListener slis5 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i = 0;i < bselect.length;i++){
                    if(i!=which){
                        bselect[i] = false;
                    }else{
                        bselect[i]=true;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,slis5);
        ad = builder.create();
        ad.setTitle("单选框");
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了";
                for(int i = 0;i < bselect.length;i++){
                    if(bselect[i]){
                        str = str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis5);
        ad.show();
    }
    private void dialog6() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bselcet[] = new boolean[item.length];
        DialogInterface.OnClickListener slis6= new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了"+item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,slis6);
        ad = builder.create();
        ad.setTitle("列表框");
        DialogInterface.OnClickListener lis6 = new DatePickerDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis6);
        ad.show();
    }
    private void dialog7() {
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.layout,null);
        final EditText et1 =(EditText) layout.findViewById(R.id.editText1);

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener lis7 = new DatePickerDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+et1.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis7);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis7);
        ad.show();
    }
}

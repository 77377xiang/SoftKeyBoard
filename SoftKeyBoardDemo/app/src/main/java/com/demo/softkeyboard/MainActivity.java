package com.demo.softkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xiang.util.softkeyboard.SoftKeyBoardListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  ,SoftKeyBoardListener.OnSoftKeyBoardChangeListener {

    private  static  String TAG="MainActivity";
    private    boolean isKeyBoard=false;//  键盘表示别

    Button close_btn ;
    TextView  show_tv ;
    EditText edit_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_et = findViewById(R.id .edit_et);
        show_tv = findViewById(R.id .show_tv);
        close_btn = findViewById(R.id .close_btn);
        close_btn.setOnClickListener(this);
        SoftKeyBoardListener. setOnSoftKeyBoardChangeListener(MainActivity.this,this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
              case R.id .close_btn :
                  if (isKeyBoard){
                      SoftKeyBoardListener.KeyBoardCancle(this);
                      Log.d(TAG,"强制关闭键盘");
                  }
                  break;
        }

    }



    @Override
    public void keyBoardShow(int height) {
        isKeyBoard=true;
        Log.d(TAG," 显示——键盘高度"+height);
    }


    @Override
    public void keyBoardHide(int height) {
        isKeyBoard=false;
        Log.d(TAG,"隐藏——键盘高度"+height);
    }




}

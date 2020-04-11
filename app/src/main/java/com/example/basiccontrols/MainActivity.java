package com.example.basiccontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText name;
    private EditText password;
    private EditText phone;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.et_name);
        password=findViewById(R.id.et_password);
        phone=findViewById(R.id.et_phone);
        spinner=findViewById(R.id.spinner_simple);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        radioGroup=findViewById(R.id.radiogroup);
        checkBox1=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isImpty()){
                    Toast.makeText(MainActivity.this,"请输入完整信息！",Toast.LENGTH_SHORT).show();
                }else {
                    String data=getData();
                    Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("content",data);
                    startActivity(intent);
                }
            }
        });
    }
    //获取性别
    private String getSex(){
        String str="";
        for (int i = 0; i <radioGroup.getChildCount(); i++) {   //radioGroup.getChildCount()获取子容器数量
            RadioButton radioButton= (RadioButton) radioGroup.getChildAt(i);

            //判断按钮是否被选中
            if(radioButton.isChecked()){
                str=radioButton.getText().toString();
                break;
            }
        }
        return str;
    }
    //获取爱好
    private String getFavorite(){
        //将变量放入数组中便于取用
        CheckBox[] cbox={checkBox1,checkBox2,checkBox3,checkBox4};
        String str="";
        //遍历数组，判断各个复选框的选中情况
        for (int i = 0; i <cbox.length ; i++) {
            if(cbox[i].isChecked()){
                str=str+cbox[i].getText().toString();
            }
        }
        return str;
    }
    //判断是否为空
    private boolean isImpty(){
        if(name.getText().toString().isEmpty()||password.getText().toString().isEmpty()||phone.getText().toString().isEmpty()||department.isEmpty()|| getFavorite()==""||getSex()==""){
            return true;
        }
        return false;
    }
    //获取全部信息
    private String getData(){
        String str=name.getText().toString()+";"+password.getText().toString()+";"+getSex()+";"+phone.getText().toString()+";"+department+getFavorite()+";";
        return str;
    }

}

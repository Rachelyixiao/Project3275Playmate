package com.example.project3275playmate.RegisterLogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.ContactUs;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.Homepage.CustomerMainPage;
import com.example.project3275playmate.Homepage.ExpertMainPage;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class LoginPage extends AppCompatActivity {
    EditText nameLogin;
    EditText pwLogin;
    TextView resetPw, Contact;
    Button btnLoginSubmit;
    //SharedPreferences和editor用来保存login以后的user name
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        nameLogin = findViewById(R.id.nameLogin);
        pwLogin = findViewById(R.id.pwLogin);
        resetPw = findViewById(R.id.resetPw);

        btnLoginSubmit = findViewById(R.id.btnLoginSubmit);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE); //Save data to the next pages
        editor = sp.edit();
    }

    public void login(View view) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);//建DAO对象
        String name = nameLogin.getText().toString().trim();//获取用户名
        String password = pwLogin.getText().toString().trim();//获取密码
        try {
            toast = dao.login(name, password);//login方法，检测用户名密码是否正确
            editor.putString("name", name);//保存数据进SharedPreferences
            editor.commit();
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();//显示dao.login方法中对应的消息
            if (!toast.contains("Login successful!")){
                return;//如果消息中没有login successful则退出方法
            }
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();//try方法出错的话提取报错信息
            return;
        }
        if (!(dao.searchCus(name)==null)){
            //检测name是否是customer。是的话跳转customer界面
            startActivity(new Intent(LoginPage.this, CustomerMainPage.class));
        }
        else if (!(dao.searchExpert(name)==null)){
            //同理，检测expert
            startActivity(new Intent(LoginPage.this, ExpertMainPage.class));
        }
    }

    public void reset(View view){
        //重置输入值
        nameLogin.setText("");
        pwLogin.setText("");
    }
}
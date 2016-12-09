package nursedemo.com.nursedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private EditText accout;

    private EditText password;

    private Button login;

    private CheckBox remember_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        accout=(EditText)findViewById(R.id.account);
        password=(EditText)findViewById(R.id.password);
        remember_pass=(CheckBox)findViewById(R.id.remember_pass);
        login=(Button)findViewById(R.id.login);
        boolean isRemember=pref.getBoolean("remember_password",false);
        if (isRemember){
            //将账号与密码都设置在文本框中
            String accountText=pref.getString("account","");
            String passwordText=pref.getString("password","");
            accout.setText(accountText);
            password.setText(passwordText);
            remember_pass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountText=accout.getText().toString();
                String passwordText=password.getText().toString();
                //如果账号是admin且密码是123456
                if (accountText.equals("admin")&&passwordText.equals("123456")){
                    editor=pref.edit();
                    if (remember_pass.isChecked()){//检查复选框是否被选中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",accountText);
                        editor.putString("password",passwordText);

                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"账号或密码无效",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

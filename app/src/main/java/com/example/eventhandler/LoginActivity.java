package com.example.eventhandler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText _txtEmailAddrss, _txtPassword;
    Button _btLogin, _btRegis;
    String _tempEmail="";
    String _tempPassword="";
//    String _tempNama="";
    int reqCode = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        _txtEmailAddrss = findViewById(R.id.txEmailAddress);
        _txtPassword = findViewById(R.id.txPassword);
        _btLogin = findViewById(R.id.btLogin);
        _btRegis = findViewById(R.id.btRegister);

        _btRegis.setOnClickListener(this);
        _btLogin.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check which request we're responding to
        if (requestCode == reqCode){
            // make sure the request was successful
            if (resultCode == RESULT_OK){
                _tempEmail = data.getStringExtra("email");
                _tempPassword = data.getStringExtra("password");
                _txtEmailAddrss.setText(_tempEmail);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == _btLogin.getId()) {
            if (_tempEmail.equals(_txtEmailAddrss.getText().toString())
                    && _tempPassword.equals(_txtPassword.getText().toString()))
            {
                Intent intent = new Intent(this,RecyclerViewActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        }

        else if (view.getId()==_btRegis.getId()){
            Intent intentB = new Intent(this, RegisterActivity.class);
            //put some data

            intentB.putExtra("asal", 99);
            this.startActivityForResult(intentB, reqCode);
        }
    }
}
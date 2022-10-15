package com.example.eventhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText _txEmail, _txName2, _txPassword2;
    Button _btClear, _btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        _txName2 = findViewById(R.id.txName);
        _txEmail = findViewById(R.id.txEmail2);
        _txPassword2 = findViewById(R.id.txPassword2);
        _btClear = findViewById(R.id.btClear);
        _btSave = findViewById(R.id.btSave);

        _btClear.setOnClickListener(this);
        _btSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== _btSave.getId()){
            //create result data as intent
            Intent resultIntent = new Intent();
            resultIntent.putExtra("email", _txEmail.getText().toString());
            resultIntent.putExtra("nama", _txName2.getText().toString());
            resultIntent.putExtra("password", _txPassword2.getText().toString());

            //set result status
            setResult(RESULT_OK, resultIntent);
            //end current activity
            //and return to calling activity
            finish();
        } else if(view.getId()==_btClear.getId()){
            _txName2.setText(null);
            _txEmail.setText(null);
            _txPassword2.setText(null);
        }
    }
}
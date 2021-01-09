package com.example.registration;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView t1, t2, t3, t4, t5;
    private EditText etText1, etText2;
    private Button button;
    private String userName = "Admin";
    private String Password = "qwerty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        t1 = findViewById(R.id.text);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.UserName);
        t4 = findViewById(R.id.queston);
        t5 = findViewById(R.id.password);
        etText1 = findViewById(R.id.etText);
        etText2 = findViewById(R.id.etText2);
        button = findViewById(R.id.button);
    }


    public void setClick1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        if (etText1.getText().toString().equals(userName)) {
            if (!(etText2.getText().toString().equals(""))){
                if (etText2.getText().toString().equals(Password)){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }else{
                    builder.setMessage("password isn't correct. Enter again?")
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    etText2.setText(null);
                                }
                            });
                    builder.create();
                    builder.show();
                }
            }else{
                Toast.makeText(MainActivity.this,"Enter a password",Toast.LENGTH_SHORT).show();

            }


        } else {

            builder.setMessage("no such account!create new account?")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, Registration.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancel", null);
            builder.create();
            builder.show();
        }
    }

    public void setClick(View view) {
        Intent intent = new Intent(MainActivity.this, Registration.class);
        startActivity(intent);
    }
}

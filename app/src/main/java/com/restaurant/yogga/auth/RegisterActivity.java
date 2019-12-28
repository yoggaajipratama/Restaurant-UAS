package com.restaurant.yogga.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.restaurant.yogga.R;
import com.restaurant.yogga.model.RegisterResponse;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.restaurant.yogga.utils.DialogUtils;

import static com.restaurant.yogga.data.Constants.REGISTER;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    TextView txtLogin;
    EditText email;
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initBinding();
        initButton();
    }

    private void initBinding() {
        btnRegister = findViewById(R.id.btn_reg_sign_up);
        txtLogin = findViewById(R.id.txt_reg_link_login);
        email = findViewById(R.id.et_reg_input_email);
        userName = findViewById(R.id.et_reg_input_name);
        password = findViewById(R.id.et_reg_input_password);
    }

    private void initButton() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Email Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Password Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (userName.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Nama harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    register();
                }
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,
                        LoginActivity.class));
            }
        });
    }

    public void register() {
        DialogUtils.openDialog(this);
        AndroidNetworking.post(REGISTER)
                .addBodyParameter("userid", email.getText().toString())
                .addBodyParameter("password", password.getText().toString())
                .addBodyParameter("nama",
                        userName.getText().toString())
                .build()
                .getAsObject(RegisterResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        if (response instanceof RegisterResponse) {
                            RegisterResponse res = (RegisterResponse)
                                    response;
                            if (res.getStatus().equals("success")) {
                                Toast.makeText(RegisterActivity.this,
                                        "Register Berhasil, silakan login kembali",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this,
                                        "Username sudah digunakan", Toast.LENGTH_SHORT).show();
                            }
                            DialogUtils.closeDialog();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(RegisterActivity.this,
                                "Terjadi kesalahan API", Toast.LENGTH_SHORT).show();
                        DialogUtils.closeDialog();
                    }
                });
    }
}
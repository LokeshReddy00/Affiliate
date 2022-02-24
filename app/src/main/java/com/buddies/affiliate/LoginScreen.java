package com.buddies.affiliate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.window.SplashScreen;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class LoginScreen extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword;
    private CircularProgressButton cirLoginButton;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sign In..... ");


        mAuth = FirebaseAuth.getInstance();


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        cirLoginButton = findViewById(R.id.cirLoginButton);

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please waite LodgingIn... ");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);

                if(TextUtils.isEmpty(editTextEmail.getText().toString()) && TextUtils.isEmpty(editTextPassword.getText().toString())){
                    Toast.makeText(LoginScreen.this, "Please Fill the Login Details", Toast.LENGTH_SHORT).show();
                }else {


                    mAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginScreen.this, SpalshScreen.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(LoginScreen.this, "We Didn't find any Records!!", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
            }
        });

    }

    public void onLoginClick(View view) {

        startActivity(new Intent(LoginScreen.this,RegisterScreen.class));

    }
}
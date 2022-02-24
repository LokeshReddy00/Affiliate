package com.buddies.affiliate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class RegisterScreen extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword,editTextName;
    private CircularProgressButton cirLoginButton;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sign In..... ");


        mAuth = FirebaseAuth.getInstance();


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        cirLoginButton = findViewById(R.id.cirLoginButton);



        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editTextName.getText().toString()) && TextUtils.isEmpty(editTextEmail.getText().toString()) && TextUtils.isEmpty(editTextPassword.getText().toString())){
                    Toast.makeText(RegisterScreen.this, "Please Fill the Details", Toast.LENGTH_SHORT).show();

                }else{


                    progressDialog.setMessage("Please waite Registration... ");
                    progressDialog.show();
                    progressDialog.setCanceledOnTouchOutside(false);

                    mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();

                                Calendar cdate = Calendar.getInstance();

                                SimpleDateFormat currentdates = new SimpleDateFormat("dd-MMMM-yyyy");

                                final String savedate = currentdates.format(cdate.getTime());

                                Calendar ctime = Calendar.getInstance();
                                SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");

                                final String savetime = currenttime.format(ctime.getTime());

                                String time = savedate + ":" + savetime;


                                Map<String, String> hashMap = new HashMap<String, String>();
                                hashMap.put("uid", mAuth.getCurrentUser().getUid());
                                hashMap.put("name", editTextName.getText().toString());
                                hashMap.put("time", time);
                                hashMap.put("email", editTextEmail.getText().toString());

                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                                reference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(hashMap);

                                Intent intent = new Intent(RegisterScreen.this, SpalshScreen.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);


                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterScreen.this, "Email Already Exists!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }

    public void onLoginClick(View view) {
        startActivity(new Intent(RegisterScreen.this,RegisterScreen.class));



    }
}
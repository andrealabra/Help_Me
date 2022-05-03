package com.example.project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://helpme-19a66-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        /**
         * Full name of the user
         */
        final EditText fullname = findViewById(R.id.fullname);
        /**
         * The user e-mail address
         */
        final EditText email = findViewById(R.id.email);
        /**
         * The user phone number
         */
        final EditText phone = findViewById(R.id.phone);
        /**
         * The password edit text field
         */
        final EditText password = findViewById(R.id.pasword);
        final EditText conPassword = findViewById(R.id.conPasword);
        /**
         * The register button to register the user
         */
        final Button registerBtn = findViewById(R.id.registerBtn);
        /**
         * The login button to log the user in the app
         */
        final TextView loginNowBtn = findViewById(R.id.loginNow);

        /**
         * 
         */
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //turn data into string val
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                //make sure all spaces are fielded
                if(fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty()
                || passwordTxt.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Fill in all fields to continue", Toast.LENGTH_SHORT).show();
                }

                //This is to see if all passwords match
                else if(!passwordTxt.equals(conPasswordTxt))
                {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }

                else{
                    //store to SharedPreferences the phone number which serves as the ID for the user
                    // will be used by other activities to access Firestore
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("phone", phoneTxt);
                    editor.apply();
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //see if the number is registered

                            if(snapshot.hasChild(phoneTxt)){
                                Toast.makeText(RegisterActivity.this, "This phone number is already associated with an account", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //send data to firebase & making phone number the unique id, everything wil be under phone number
                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(RegisterActivity.this, "Registration done sucessfully", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
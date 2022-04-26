package com.example.project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class PostingActivity extends AppCompatActivity {
   //connecting firebase database to posting screen
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://helpme-19a66-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
    }

    final EditText phone = findViewById(R.id.phone);
   final EditText question  = findViewById(R.id.postQs);

   final Button postitBtn = findViewById(R.id.postitBtn);

  /*
   postitBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //turn data into string val
            final String question = postQs.getText().toString();

                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //send data to firebase & making phone number the unique id, everything wil be under phone number
                            databaseReference.child("users").child(phoneTxt).child("question").setValue(question);
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

   */

}

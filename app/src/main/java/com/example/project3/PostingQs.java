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

public class PostingQs extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://helpme-19a66-default-rtdb.firebaseio.com/");
    //phone number of user used for accessing related Firestore content
    String phone = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_qs);

        //read in the users phone number thatg serves as ID into the firestore
        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        phone = sharedPref.getString("phone", "stupid");

        final EditText postIt = findViewById(R.id.postQs);
      //  final EditText phone = findViewById(R.id.phone);

        final Button sendoffBtn = findViewById(R.id.btnPostit);
        final Button postFromMain = findViewById(R.id.postitBtn);

        String phoneId = getIntent().getStringExtra("phoneId");

        sendoffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //final String phoneTxt = phone.getText().toString();
                final String postItTxt = postIt.getText().toString();

                Toast.makeText(PostingQs.this, "OnClick Action", Toast.LENGTH_SHORT).show();

                if (postItTxt.isEmpty()) {
                    Toast.makeText(PostingQs.this, "Please type in a question", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            Toast.makeText(PostingQs.this, "OnDataChange", Toast.LENGTH_SHORT).show();

                            if (snapshot.hasChild(postItTxt)) {
                                Toast.makeText(PostingQs.this, "Post already made", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(PostingQs.this, "Else clause", Toast.LENGTH_SHORT).show();

                                databaseReference.child("users").child(phoneId).child("question").setValue(postItTxt);

                                Toast.makeText(PostingQs.this, "Question posted successfully", Toast.LENGTH_SHORT).show();
                               // finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });


//        sendoffBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

    }
}

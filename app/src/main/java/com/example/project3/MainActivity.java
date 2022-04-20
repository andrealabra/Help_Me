package com.example.project3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
   // DatabaseReference mUserRef;
    String usernameV;
    TextView usernameHeader;



    DatabaseReference mUserRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://helpme-19a66-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Help me");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        mUserRef = FirebaseDatabase.getInstance().getReference().child("users");

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navView);

        View view=navigationView.inflateHeaderView(R.layout.drawer_header);
        usernameHeader=view.findViewById(R.id.username_header);


        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mUser==null)
        {
          //  SendUserToLoginActivity();
        }
        else
        {
            mUserRef.child(mUser.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists())
                    {
                    usernameV=snapshot.child("fullname").getValue().toString();
                    usernameHeader.setText(usernameV);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Sorry, Something went wrong.", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

//    private void SendUserToLoginActivity() {
//        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//        startActivity(intent);
//        finish();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
        switch (menuitem.getItemId()){
            case R.id.logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                break;



        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return true;
    }
}
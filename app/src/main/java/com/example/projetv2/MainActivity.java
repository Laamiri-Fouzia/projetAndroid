package com.example.projetv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
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

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://projetv2-20332-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_association = (TextView) findViewById(R.id.tv_association);
        TextView tv_benev_donna = (TextView) findViewById(R.id.tv_benv_don);
        EditText et_username = (EditText) findViewById(R.id.username);
        EditText et_password = (EditText) findViewById(R.id.password);
        Button btn_login = (Button) findViewById(R.id.buttonLogin);
        tv_association.setPaintFlags(tv_association.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        tv_benev_donna.setPaintFlags(tv_association.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this,"svp entrez votre nom d'utilisateur ou votre mot de passe ",
                            Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(username)){
                                String right_passw=dataSnapshot.child(username).child("password").getValue(String.class);
                                if(right_passw.equals(password))
                                    Toast.makeText(MainActivity.this,"successfully loged in !",Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(MainActivity.this,"wrong password !",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this,"ce nom d'utilisateur n'exsite pas !",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }

        });

    }
}
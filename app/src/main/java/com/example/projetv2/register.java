package com.example.projetv2;

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

public class register extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://projetv2-20332-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText et_username = (EditText) findViewById(R.id.rg_username);
        EditText et_phone = (EditText) findViewById(R.id.rg_phone);
        EditText et_adress = (EditText) findViewById(R.id.rg_adress);
        EditText et_password = (EditText) findViewById(R.id.rg_password);
        Button btn_register = (Button) findViewById(R.id.btnRegister);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String phone = et_phone.getText().toString();
                String adress = et_adress.getText().toString();

                if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || adress.isEmpty()){
                    Toast.makeText(register.this,"Veuillez saisir tous les champs !",
                            Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(username)){
                                Toast.makeText(register.this,"ce nom d'utilisateur est deja existe ",Toast.LENGTH_SHORT).show();
                            }else {
                                databaseReference.child("users").child(username).child("password").setValue(password);
                                databaseReference.child("users").child(username).child("phone").setValue(phone);
                                databaseReference.child("users").child(username).child("adress").setValue(adress);
                                Toast.makeText(register.this,"utilisateur est bien ajouté ",Toast.LENGTH_SHORT).show();

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
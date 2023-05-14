package com.example.miniappcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addcontact extends AppCompatActivity {
    EditText editname,editnum;
    Button btnadd,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        editname=(EditText)findViewById(R.id.editTextTextName);
        editnum=(EditText)findViewById(R.id.editTextTextNum);
        btnadd=(Button)findViewById(R.id.buttonaddd);
        btnback=(Button)findViewById(R.id.buttoncomeback);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(editname.getText().toString().equals("")){
                    editname.setError("Invalid!");
                    editname.requestFocus();
                    return;
                }
                if(editnum.getText().toString().equals("")){
                    editnum.setError("Invalid!");
                    editnum.requestFocus();
                    return;
                }
                ContactBDD db=new ContactBDD(Addcontact.this);
                Contact c=new Contact(editname.getText().toString(),editnum.getText().toString());
                long r=db.addContact(c);
                if(r!=-1){
                    Toast.makeText(Addcontact.this, "Ajout avec succés", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Addcontact.this, "Probléme dans l'ajout", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent;
                intent=new Intent(Addcontact.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.miniappcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class allcontact extends AppCompatActivity {
    RecyclerView recycerview;
    RecyclerView.LayoutManager layoutManager;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcontact);

        recycerview = findViewById(R.id.recycerview);
        layoutManager = new LinearLayoutManager(this);
        recycerview.setLayoutManager(layoutManager);
        ContactBDD db=new ContactBDD(this);

      //  System.out.println(listcontact);
        contactAdapter = new ContactAdapter(this,db.getAllContact());
        recycerview.setAdapter(contactAdapter);
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycerview.addItemDecoration(dividerItemDecoration);
        Toast.makeText(this, "test ", Toast.LENGTH_SHORT).show();
    }
}
package com.example.miniappcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.buttonadd)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonall)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.buttonadd:
                intent=new Intent(MainActivity.this,Addcontact.class);
                startActivity(intent);
                break;
            case R.id.buttonall:
                intent=new Intent(MainActivity.this,allcontact.class);
                startActivity(intent);
                break;
            default:break;
    }
}
}
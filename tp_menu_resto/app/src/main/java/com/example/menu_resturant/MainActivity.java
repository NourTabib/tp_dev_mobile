package com.example.menu_resturant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox chkPizza,chkHamb,chkSan;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkPizza=(CheckBox)findViewById(R.id.checkbox_Pizza);
        chkHamb=(CheckBox)findViewById(R.id.checkbox_Hamburger);
        chkSan=(CheckBox)findViewById(R.id.checkbox_sandwitch);
        buttonOrder=(Button)findViewById(R.id.button);
        buttonOrder.setOnClickListener(
                (new View.OnClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onClick(View view) {

                         String text="";
                         Integer Totalamount =0;
                         if(chkPizza.isChecked()){
                            Totalamount+=8000;
                            text+="Pizza - 8000\n";
                         }
                         if(chkHamb.isChecked()) {
                            Totalamount+=6000;
                             text+="Hamburger - 6000\n";
                         }
                         if(chkSan.isChecked()) {
                            Totalamount+=5000;
                             text+="Sandiwtch - 5000\n";
                         }
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("Tickets");
                        alertDialog.setMessage(text + "\n Total amount : "+Totalamount+"\n");
                        alertDialog.show();
                    }
                    }
                )
        );
    }
}
package com.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.demoapp.model.User;

public class AddItem extends AppCompatActivity {

    EditText userEmail_et, userName_et, userMobile_et;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userEmail_et = findViewById(R.id.userEmail_et);
        userName_et = findViewById(R.id.userName_et);
        userMobile_et = findViewById(R.id.userMobile_et);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userEmail_et.getText().toString().length()==0){

                }
                else if(userEmail_et.getText().toString().length()==0){

                }else if(userMobile_et.getText().toString().length()==0){

                }else{
                    AppUtil.userList.add(new User(userName_et.getText().toString(),
                            userMobile_et.getText().toString(),
                            userEmail_et.getText().toString()));
                    Toast.makeText(AddItem.this, "Item Added", Toast.LENGTH_LONG).show();
                    finish();

                    /*Intent i = new Intent(AddItem.this, MainActivity.class);
                    i.putExtra("ItemAdded", "true");
                    startActivityForResult(i);*/
                }
            }
        });




    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}

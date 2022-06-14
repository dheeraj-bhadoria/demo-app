package com.demoapp;

import android.content.Intent;
import android.os.Bundle;

import com.demoapp.adapter.UserRvAdapter;
import com.demoapp.model.User;
import com.demoapp.user_interface.UserRepository;
import com.demoapp.user_repository.repository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demoapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserRepository {

    RecyclerView userRv;
    FloatingActionButton addItem;
    UserRvAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("User list");

        userRv = findViewById(R.id.rv);
        addItem = findViewById(R.id.addItem);
        AppUtil.userList = new ArrayList<>();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        userRv.setLayoutManager(layoutManager);
       init();
       loadRecyclerViewData();

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddItem.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter!=null){
            adapter.notifyDataSetChanged();
        }
    }

    private void addItem(){

    }

    private void loadRecyclerViewData() {
        adapter = new UserRvAdapter(AppUtil.userList, this);
        userRv.setAdapter(adapter);
    }


    public void init(){
        AppUtil.userList.add(new User("Dheeraj", "6565656565", "hello@gmail.com"));
        AppUtil.userList.add(new User("Dheeraj", "6565656565", "hello@gmail.com"));
        AppUtil.userList.add(new User("Dheeraj", "6565656565", "hello@gmail.com"));
        AppUtil.userList.add(new User("Dheeraj", "6565656565", "hello@gmail.com"));

    }


    @Override
    public void addUser() {

    }

    @Override
    public void deleteUser(int postition ) {
        AppUtil.userList.remove(postition);
        adapter.notifyDataSetChanged();
    }
}
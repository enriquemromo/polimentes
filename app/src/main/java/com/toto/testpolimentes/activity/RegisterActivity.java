package com.toto.testpolimentes.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.db.dao.UserDAO;
import com.toto.testpolimentes.db.model.User;
import com.toto.testpolimentes.fragments.Form1Fragment;

public class RegisterActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    private User user;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.formFragment, new Form1Fragment());
        fragmentTransaction.commit();

        user = new User();
        userDAO = new UserDAO();

    }


    public void remplaceCurentFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.formFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void saveUser(){
        userDAO.create(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

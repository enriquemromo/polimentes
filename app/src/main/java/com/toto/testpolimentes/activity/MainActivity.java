package com.toto.testpolimentes.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.db.dao.UserDAO;
import com.toto.testpolimentes.db.model.User;
import com.toto.testpolimentes.util.Utility;

public class MainActivity extends AppCompatActivity {


    private EditText inputEmail;
    private EditText inputPassword;
    private Button buttonSignup;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        buttonSignup = findViewById(R.id.btn_signup);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailPassword();
            }
        });





    }


    private void validateEmailPassword(){


        email = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();



        if(email.isEmpty() || password.isEmpty()) {

            if (email.isEmpty()) {
                inputEmail.setError(getString(R.string.err_msg_email_empty));
            }
            if (password.isEmpty()) {
                inputPassword.setError(getString(R.string.err_msg_password_empty));
            }

        } else {

            if(IsEmailValid(email) & IsPasswordValid(password)){
               Intent activityIntent = null;
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUser();
                if(user == null){
                    activityIntent  = new Intent(this,RegisterActivity.class);
               } else {
                    activityIntent  = new Intent(this,HomeActivity.class);
                }

               startActivity(activityIntent);
            }


        }

    }

    private boolean IsEmailValid(String email){

        if(!Utility.validateLongitudeEmail(email)){
            inputEmail.setError(getString(R.string.err_msg_email_short));
            return  false;
        }
        if(!Utility.valiateDomain(email)){
            inputEmail.setError(getString(R.string.err_msg_email_domain));
            return false;
        }

        if(!Utility.validateEmailPattern(email)){
            inputEmail.setError(getString(R.string.err_msg_email));
            return false;
        }


        return true;
    }

    private boolean IsPasswordValid(String password){

        if(!Utility.containsUppercaseLetter(password)){
            inputPassword.setError(getString(R.string.err_msg_password_uppercase_letter));
            return  false;
        }
        if(!Utility.containsDigit(password)){
            inputPassword.setError(getString(R.string.err_msg_password_digit));
            return  false;
        }if(!Utility.containsSpecialCharacters(password)){
            inputPassword.setError(getString(R.string.err_msg_password_special_characters));
            return  false;
        }

        return true;

    }

}

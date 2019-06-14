package com.toto.testpolimentes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.activity.RegisterActivity;
import com.toto.testpolimentes.util.Utility;

/**
 * A simple {@link Fragment} subclass.
 */
public class Form2Fragment extends Fragment {


    private RegisterActivity registerActivity;

    private EditText inputEmail;
    private EditText inputConfirmEmail;
    private EditText inputPassword;
    private EditText inputConfirmPassword;
    private Button btnContinue;
    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;


    public Form2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form2, container, false);
        init(view);
        return view;
    }

    private  void init(View view){

        registerActivity = (RegisterActivity) getActivity();

        inputEmail = view.findViewById(R.id.input_email);
        inputConfirmEmail = view.findViewById(R.id.input_confirm_email);
        inputPassword = view.findViewById(R.id.input_password);
        inputConfirmPassword = view.findViewById(R.id.confirm_password);


        inputEmail.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(validateFields()) {
                    btnContinue.setEnabled(true);
                }else {
                    btnContinue.setEnabled(false);
                }
            }
        });

        inputConfirmEmail.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(validateFields()) {
                    btnContinue.setEnabled(true);
                }else {
                    btnContinue.setEnabled(false);
                }
            }
        });

        inputPassword.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(validateFields()) {
                    btnContinue.setEnabled(true);
                }else {
                    btnContinue.setEnabled(false);
                }
            }
        });
        inputConfirmPassword.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(validateFields()) {
                    btnContinue.setEnabled(true);
                }else {
                    btnContinue.setEnabled(false);
                }
            }
        });

        btnContinue = view.findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueNextFrame();
            }
        });

    }

    private void continueNextFrame(){
        String email = inputEmail.getText().toString().trim();
        String confirmEmail = inputConfirmEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String confirmPassword = inputConfirmPassword.getText().toString().trim();



        if(checkEmail(email, confirmEmail) & checkPassword(password,confirmPassword)){
            registerActivity.getUser().setEmail(email);
            registerActivity.getUser().setPassword(password);
            registerActivity.remplaceCurentFragment(new Form3Fragment());
        }
    }

    private boolean validateFields() {
        boolean validateFields = true;
        email = inputEmail.getText().toString().trim();
        confirmEmail = inputConfirmEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        confirmPassword = inputConfirmPassword.toString().trim();

        if (email.isEmpty()) {
            inputEmail.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }

        if (confirmEmail.isEmpty()) {
            inputConfirmEmail.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }

        if (password.isEmpty()) {
            inputPassword.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }

        if (confirmPassword.isEmpty()) {
            inputPassword.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }

        return  validateFields;
    }


    private boolean checkEmail(String email, String confirmEmail){
        boolean validateFields = true;
        if (!IsEmailValid(email)) {
            validateFields = false;
        } else if (!email.equals(confirmEmail)) {
            Toast.makeText(registerActivity,getString(R.string.err_msg_confirm_email),Toast.LENGTH_LONG).show();

            validateFields = false;
        }


        return  validateFields;
    }


    private boolean checkPassword(String password, String confirmPassword){

        boolean validateFields = true;

        if (!IsPasswordValid(password)) {
            validateFields = false;
        } else if  (!password.equals(confirmPassword)) {
            Toast.makeText(registerActivity,getString(R.string.err_msg_confirm_password),Toast.LENGTH_LONG).show();

            validateFields = false;
        }

        return validateFields;
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

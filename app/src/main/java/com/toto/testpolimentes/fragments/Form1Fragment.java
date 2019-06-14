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

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.activity.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Form1Fragment extends Fragment {


    private RegisterActivity registerActivity;
    private EditText inputName;
    private EditText inputLastname;
    private EditText inputCellphone;
    private Button btnContinue;
    private String name;
    private String lastName;
    private String cellphone;


    public Form1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form1, container, false);
        init(view);
        return view;
    }


    private void init(View view){

        registerActivity =(RegisterActivity)getActivity();
        inputName = view.findViewById(R.id.input_name);
        inputName.addTextChangedListener(new TextWatcher() {

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
        inputLastname = view.findViewById(R.id.input_lastname);
        inputLastname.addTextChangedListener(new TextWatcher() {

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
        inputCellphone = view.findViewById(R.id.input_cellphone);
        btnContinue = view.findViewById(R.id.btn_continue);

        inputCellphone.addTextChangedListener(new TextWatcher() {

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

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueNextFrame();
            }
        });

    }

    private void continueNextFrame(){
        registerActivity.getUser().setName(name);
        registerActivity.getUser().setLastName(lastName);
        registerActivity.getUser().setCellPhoneNumber(cellphone);
        registerActivity.remplaceCurentFragment(new Form2Fragment());
    }

    private boolean validateFields(){

        boolean validateFields = true;

        name = inputName.getText().toString().trim();
        lastName = inputLastname.getText().toString().trim();
        cellphone = inputCellphone.getText().toString().trim();

        if(name.isEmpty()){
            inputName.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }


        if(lastName.isEmpty()){
            inputLastname.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }

        if(cellphone.isEmpty()){
            inputCellphone.setError(getString(R.string.err_msg_field_empty));
            validateFields = false;
        }
        return  validateFields;
    }


}

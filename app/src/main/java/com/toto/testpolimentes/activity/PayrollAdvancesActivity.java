package com.toto.testpolimentes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.db.dao.UserDAO;
import com.toto.testpolimentes.db.model.User;

public class PayrollAdvancesActivity extends AppCompatActivity {


    private Button btnRequest;
    private EditText inpuTotalPerceptions;
    private EditText inputTotalDeductions;
    private EditText inputAmountRequest;
    private TextView labelLiquidityOf;
    private TextView labelMaxAmountRequest;
    private LinearLayout container;
    double maxRequestAmount = 0.0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll_advances);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        inpuTotalPerceptions = findViewById(R.id.input_total_perceptions);
        inpuTotalPerceptions.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                checkInputFileds();
            }
        });



        inputTotalDeductions = findViewById(R.id.input_total_deductions);
        inputTotalDeductions.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                checkInputFileds();
            }
        });


        inputAmountRequest = findViewById(R.id.input_amount_request);
        container = findViewById(R.id.container);

        labelLiquidityOf = findViewById(R.id.label_liquidity_of);
        labelMaxAmountRequest = findViewById(R.id.label_max_amount_request);
        btnRequest = findViewById(R.id.btn_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void request(){

        String amountRequest = inputAmountRequest.getText().toString().trim();
        double amountRequestValue = Double.parseDouble(amountRequest);
        if(!amountRequest.isEmpty()&&amountRequestValue < maxRequestAmount){
            send();
        } else {
            Toast.makeText(getBaseContext(),getString(R.string.err_msg_amount_request),Toast.LENGTH_LONG).show();
        }

    }

    private void send(){

    }


    private void checkInputFileds(){
        String totalPerceptions = inpuTotalPerceptions.getText().toString().trim();
        String totalDeductions = inputTotalDeductions.getText().toString().trim();

        if(!totalPerceptions.isEmpty()&&!totalDeductions.isEmpty()){
            enableFilds();
        } else {
            disableFields();
        }


    }

    private void enableFilds(){

        String totalPerceptions = inpuTotalPerceptions.getText().toString().trim();
        String totalDeductions = inputTotalDeductions.getText().toString().trim();

        double totalPerceptionsValue = Double.parseDouble(totalPerceptions);
        double totalDeductionsValue = Double.parseDouble(totalDeductions);
        double result = 0.0d;
        double resulLiquidity = 0.0d;

        if(totalDeductionsValue > totalPerceptionsValue){

            inputTotalDeductions.setError(getString(R.string.err_deductions));

        } else {
            labelMaxAmountRequest.setVisibility(View.VISIBLE);
            inputAmountRequest.setVisibility(View.VISIBLE);
            inputTotalDeductions.setError(null);
            result = totalPerceptionsValue- totalDeductionsValue;
            labelLiquidityOf.setVisibility(View.VISIBLE);
            labelLiquidityOf.setText(getString(R.string.label_liquidity_of)+" "+result);
            resulLiquidity= result * 0.3;
            maxRequestAmount = totalPerceptionsValue - resulLiquidity;
            labelMaxAmountRequest.setVisibility(View.VISIBLE);
            labelMaxAmountRequest.setText(getString(R.string.label_porcent_request)+" "+maxRequestAmount);

        }





    }
    private void disableFields(){

        labelMaxAmountRequest.setText("");
        labelLiquidityOf.setText("");

        labelMaxAmountRequest.setVisibility(View.INVISIBLE);
        labelLiquidityOf.setVisibility(View.INVISIBLE);
        inputAmountRequest.setVisibility(View.INVISIBLE);
    }


}

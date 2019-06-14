package com.toto.testpolimentes.fragments.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.activity.PayrollAdvancesActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditProductsFragment extends Fragment {

    private Button btnPayrollAdvances;


    public CreditProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_credit_products, container, false);
        init(view);
        return view;
    }

    private  void init(View view){
        btnPayrollAdvances = view.findViewById(R.id.btn_payroll_advance);
        btnPayrollAdvances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PayrollAdvancesActivity.class);
                startActivity(intent);
            }
        });


    }

}

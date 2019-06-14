package com.toto.testpolimentes.fragments.tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toto.testpolimentes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditRequestsFragment extends Fragment {


    public CreditRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credit_requests, container, false);
    }

}

package com.toto.testpolimentes.fragments.tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toto.testpolimentes.R;
import com.toto.testpolimentes.db.dao.UserDAO;
import com.toto.testpolimentes.db.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfilFragment extends Fragment {

    private TextView labelEmail;

    private TextView labelName;
    private TextView labelLastNamel;


    public UserProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profil, container, false);
            init(view);
        return view;
    }


    private void init(View view){
        labelEmail = view.findViewById(R.id.email);
        labelLastNamel = view.findViewById(R.id.last_name);
        labelName = view.findViewById(R.id.name);

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser();
        if(user != null){
            labelName.setText(user.getName());
            labelLastNamel.setText(user.getLastName());
            labelEmail.setText(user.getPassword());
        }
    }

}

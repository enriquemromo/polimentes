package com.toto.testpolimentes.fragments;


import android.app.NotificationManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.toto.testpolimentes.activity.HomeActivity;
import com.toto.testpolimentes.R;
import com.toto.testpolimentes.activity.RegisterActivity;
import com.toto.testpolimentes.db.dao.UserDAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class Form3Fragment extends Fragment {


    private static final String ACTIVATION_CODE = "54321";
    private RegisterActivity registerActivity;
    private EditText inputActivationCode;
    private Button btnRegister;
    private String activationCode;



    public Form3Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form3, container, false);
        init(view);
        return view;
    }


    private void init(View view){

        registerActivity = (RegisterActivity) getActivity();
        inputActivationCode = view.findViewById(R.id.input_activation_code);
        inputActivationCode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(checkCode()) {
                    btnRegister.setEnabled(true);
                }else {
                    btnRegister.setEnabled(false);
                }
            }
        });
        btnRegister = view.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              register();

            }
        });

        new NotificationTask().execute();

    }

    private void register(){
        activationCode = inputActivationCode.getText().toString().trim();
        if(ACTIVATION_CODE.equals(activationCode)){

            registerActivity.saveUser();

            Intent homeIntent = new Intent(getContext(), HomeActivity.class);
            startActivity(homeIntent);
        } else {
            Toast.makeText(getContext(),getString(R.string.invalid_activation_code),Toast.LENGTH_LONG).show();
        }

    }

    private boolean checkCode(){

        activationCode = inputActivationCode.getText().toString().trim();

        if(activationCode.isEmpty()){
            inputActivationCode.setError(getString(R.string.err_msg_field_empty));
            return false;
        }

        return true;
    }



    class NotificationTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try
            {
                Thread.sleep( 2 * 1000 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            sendNotification();
        }
    }

    private void sendNotification() {


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle(getString(R.string.title_activation_code))
                        .setContentText(ACTIVATION_CODE)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI);




        NotificationManager mNotificationManager =

                (NotificationManager) registerActivity.getSystemService(registerActivity.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());
    }

}

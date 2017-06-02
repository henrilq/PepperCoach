package com.softbankrobotics.myapplication.retrofit;

import com.softbankrobotics.myapplication.model.Sleep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by henri.lequintrec on 02/06/17.
 */

public class FitBitServiceImpl implements FitBitService{

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final String ROOT = "https://api.fitbit.com";

    private static final String DATE_REQUEST = "https://api.fitbit.com/1.2/user/-/sleep/date/%s.json";

    @Override
    public Sleep getSleeps(Date date) {
        String res = String.format(DATE_REQUEST, DATE_FORMAT.format(date));
        return null;
    }

    private void getRetrofit(){

    }

}

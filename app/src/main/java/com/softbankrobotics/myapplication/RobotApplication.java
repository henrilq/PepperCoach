package com.softbankrobotics.myapplication;

import android.app.Application;

import com.softbankrobotics.myapplication.retrofit.FitBitService;
import com.softbankrobotics.myapplication.retrofit.FitBitServiceImpl;

import java.util.Date;

/**
 * Created by hlq on 02/06/2017.
 */

public class RobotApplication extends Application{

    private String fitBitToken;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getFitBitToken() {
        return fitBitToken;
    }

    public void setFitBitToken(String fitBitToken) {
        this.fitBitToken = fitBitToken;
        FitBitService s = new FitBitServiceImpl();
        s.getSleeps(new Date());
    }
}

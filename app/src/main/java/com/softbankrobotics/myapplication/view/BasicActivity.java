package com.softbankrobotics.myapplication.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.softbankrobotics.myapplication.RobotApplication;

/**
 * Created by henri.lequintrec on 02/06/17.
 */

public abstract class BasicActivity extends AppCompatActivity {
    public RobotApplication getRobotApp(){
        Context app = getApplicationContext();
        return (RobotApplication)app;
    }
}

package com.softbankrobotics.myapplication.retrofit;

import com.softbankrobotics.myapplication.model.Sleep;

import java.util.Date;

/**
 * Created by henri.lequintrec on 02/06/17.
 */

public interface FitBitService {
    Sleep getSleeps(Date date);
}

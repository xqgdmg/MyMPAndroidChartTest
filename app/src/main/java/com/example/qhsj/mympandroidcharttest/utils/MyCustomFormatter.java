package com.example.qhsj.mympandroidcharttest.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by Chris on 2017/7/5.
 */
public class MyCustomFormatter implements IAxisValueFormatter{
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return String.format("%s", mFormat.format(value));
    }

    protected DecimalFormat mFormat;

    public MyCustomFormatter() {
        mFormat = new DecimalFormat("0.######");
    }

}

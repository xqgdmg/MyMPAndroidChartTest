package com.example.qhsj.mympandroidcharttest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qhsj.mympandroidcharttest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvLineChart;
    private TextView tvBarChart;
    private TextView tvPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        tvLineChart.setOnClickListener(this);
    }

    private void initView() {
        tvLineChart = (TextView) findViewById(R.id.tvLineChart);
        tvBarChart = (TextView) findViewById(R.id.tvBarChart);
        tvPieChart = (TextView) findViewById(R.id.tvPieChart);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvLineChart:
                startActivity(new Intent(MainActivity.this,LineChartActivity.class));
                break;
            case R.id.tvBarChart:
                startActivity(new Intent(MainActivity.this,LineChartActivity.class));
                break;
            case R.id.tvPieChart:
                startActivity(new Intent(MainActivity.this,LineChartActivity.class));
                break;
        }
    }


}
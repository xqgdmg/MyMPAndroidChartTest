package com.example.qhsj.mympandroidcharttest.activity;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.example.qhsj.mympandroidcharttest.R;
import com.example.qhsj.mympandroidcharttest.utils.MyCustomFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * Created by Chris on 2017/7/4.
 * 线状图
 */
public class LineChartActivity extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        initView();
        initChart();
        initChartListener();
    }

    private void initChartListener() {
        // 手势
        mChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });

        // 选中图表上的点
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    private void initChart() {
         // 背景网格
        mChart.setDrawGridBackground(false);
         // 描述
        mChart.getDescription().setEnabled(false);
         // 触摸手势
        mChart.setTouchEnabled(true);
         // 拖拽
        mChart.setDragEnabled(true);
         // 缩放
        mChart.setScaleEnabled(true);
         // 如果 false ，可以在x和y轴上分别进行缩放。
        mChart.setPinchZoom(true);
         // marker 和地图的意思一样，手势禁用了，这个会失效
//        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
//        mv.setChartView(mChart);
//        mChart.setMarker(mv);
        // x 轴的限制线
        /*LimitLine llXAxis = new LimitLine(10f, "limit line label");
        llXAxis.setLineWidth(4f);
        llXAxis.enableDashedLine(10f, 10f, 0f);
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);*/
         // x 轴的设置
        XAxis xAxis = mChart.getXAxis();
//        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // x 轴显示在底部
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.RED);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        // set a custom value formatter
        xAxis.setValueFormatter(new MyCustomFormatter()); // 6 位格式

         /*// Typeface 字体相关
//        Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
         // y 轴的上限制线
        LimitLine limitLine01 = new LimitLine(150f, "Upper Limit");
        limitLine01.setLineWidth(4f);
        limitLine01.enableDashedLine(10f, 10f, 0f);
        limitLine01.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        limitLine01.setTextSize(10f);
//        limitLine01.setTypeface(tf);
        // y 轴的下限制线
        LimitLine limitLine02 = new LimitLine(-30f, "Lower Limit");
        limitLine02.setLineWidth(4f);
        limitLine02.enableDashedLine(10f, 10f, 0f);
        limitLine02.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        limitLine02.setTextSize(10f);
//        limitLine02.setTypeface(tf);*/

         // 设置左边的 y 轴
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
//        leftAxis.addLimitLine(limitLine01);
//        leftAxis.addLimitLine(limitLine02);
        leftAxis.setAxisMaximum(160f); // 左边 y 坐标的最大值
        leftAxis.setAxisMinimum(-10f); // 左边 y 坐标的最小值
        //leftAxis.setYOffset(20f);
//        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false); //

        // 限制线不覆盖数据
        leftAxis.setDrawLimitLinesBehindData(true);

         // 不显示右边的 y 轴坐标，即单 y轴的模式
        mChart.getAxisRight().setEnabled(false);

        //mChart.getViewPortHandler().setMaximumScaleY(2f);
        //mChart.getViewPortHandler().setMaximumScaleX(2f);

        // add data
        setData(145, 100);

//        mChart.setVisibleXRange(20);
//        mChart.setVisibleYRange(20f, YAxis.AxisDependency.LEFT);
//        mChart.centerViewTo(20, 50, YAxis.AxisDependency.LEFT);

        mChart.animateX(2500);
        //mChart.invalidate();

        // 传奇，图例
        Legend l = mChart.getLegend();

        l.setForm(Legend.LegendForm.LINE);

        mChart.setVisibleXRange(0,60); // 显示部分数据.实现显示部分数据
        mChart.centerViewTo(20, 50, YAxis.AxisDependency.LEFT);

        // 表格的所有设置重新配置之后，都要调用这个方法
        // mChart.invalidate();

    }

    private void initView() {
        mChart = (LineChart) findViewById(R.id.LineChart);
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val, getResources().getDrawable(R.drawable.star)));
        }

        LineDataSet lineDataSet;
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
             // 之前有数据，获取第一组数据
            lineDataSet = (LineDataSet)mChart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // 创建新的数据
            lineDataSet = new LineDataSet(values, "DataSet01");

            lineDataSet.setDrawIcons(false); // 数据点不设置设置成图片，用默认圆心点

            // 把点的连接线绘制成 "- - - - - -"
            lineDataSet.enableDashedLine(10f, 5f, 0f);
            lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);

            lineDataSet.setColor(Color.BLUE);
            lineDataSet.setCircleColor(Color.RED);
            lineDataSet.setLineWidth(1f);
            lineDataSet.setCircleRadius(3f);
            lineDataSet.setDrawCircleHole(true); // 空心点
            lineDataSet.setValueTextSize(9f);
            lineDataSet.setDrawFilled(false); //
            lineDataSet.setFormLineWidth(1f);
            lineDataSet.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            lineDataSet.setFormSize(15.f);

             // 填充颜色
            /*if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                lineDataSet.setFillDrawable(drawable);
            }
            else {
                lineDataSet.setFillColor(Color.BLACK);
            }*/

             // 填充数据
            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(lineDataSet);

            LineData data = new LineData(dataSets);

            mChart.setData(data);
        }
    }


}

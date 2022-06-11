package group7.com.quanlytiensan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DrawBarChartSumMoney extends AppCompatActivity {

    TextView txt;
    Intent intent=getIntent();
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_bar_chart_sum_money);
        txt=findViewById(R.id.display);
        barChart=findViewById(R.id.barChart);
        txt.setText("Biểu đồ tổng tiền từng tháng");

        ArrayList<BarEntry> arlBarEntry=new ArrayList<>();
/*
        for(String s:MainActivity.sumMoneyForMonths.keySet()){
            float p= Float.parseFloat( MainActivity.sumMoneyForMonths.get(s));
            int i= Integer.parseInt(s);
            BarEntry barEntry=new BarEntry(i,p);

            arlBarEntry.add(barEntry);
        }
 */
        for(String s:MainActivity.arlMonth.keySet()){
            float p= Float.parseFloat( MainActivity.arlMonth.get(s));
            int i= Integer.parseInt(s);
            BarEntry barEntry=new BarEntry(i,p);

            arlBarEntry.add(barEntry);
        }

        BarDataSet Moneys=new BarDataSet(arlBarEntry,"Tháng");



        Moneys.setColors(ColorTemplate.MATERIAL_COLORS);
        Moneys.setValueTextColor(Color.BLACK);
        Moneys.setValueTextSize(14f);

        BarData barData=new BarData(Moneys);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Moneys Per Month");
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleXEnabled(true);
        barChart.animateY(2000);


    }
}
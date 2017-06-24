package quanlychitieu.com.quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import database.ChiTieu;
import database.DatabaseHandler;

/**
 * Created by Mouse on 5/13/2016.
 */
public class ShowThongKeActivity extends AppCompatActivity{
    private DatabaseHandler dbHandler;
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongke_moniter);
        dbHandler = new DatabaseHandler(ShowThongKeActivity.this);
        lineChart = (LineChart) findViewById(R.id.chart);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!= null){
            if(bundle.getInt("loai") == 1){
                addChart(1);
            }
            if(bundle.getInt("loai") == 2){
                addChart(2);
            }
            if(bundle.getInt("loai") == 3){
                addChart(3);
            }
            if(bundle.getInt("loai") == 4){
                addChart(4);
            }
        }

    }

    private void addChart(int loai){
        if(loai == 1){
            Calendar calendar = Calendar.getInstance();
            int currYear = calendar.get(Calendar.YEAR);
            Long startTime = new Date("1/1/" + currYear).getTime();
            Long endTime = new Date("1/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu1 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("2/1/" + currYear).getTime();
            endTime = new Date("2/28" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu2 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("3/1/" + currYear).getTime();
            endTime = new Date("3/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu3 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            int chiThang1 = 0,chiThang2 = 0,chiThang3 = 0;
            for(int i = 0 ; i < chiTieu1.size() ; i ++){
                if(chiTieu1.get(i).get_THU() == 0){
                    chiThang1 = chiThang1 + Integer.parseInt(chiTieu1.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu2.size() ; i ++){
                if(chiTieu2.get(i).get_THU() == 0){
                    chiThang2 = chiThang2 + Integer.parseInt(chiTieu2.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu3.size() ; i ++){
                if(chiTieu3.get(i).get_THU() == 0){
                    chiThang3 = chiThang3 + Integer.parseInt(chiTieu3.get(i).get_MONEY());
                }
            }

            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(chiThang1, 0));
            entries.add(new Entry(chiThang2, 1));
            entries.add(new Entry(chiThang3, 2));

            LineDataSet dataset = new LineDataSet(entries, "VND");

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Thang 1");
            labels.add("Thang 2");
            labels.add("Thang 3");

            LineData data = new LineData(labels, dataset);
            lineChart.setData(data); // set the data and list of lables into chart

            lineChart.setDescription("Tien Chi");  // set the description
        }
        else if(loai == 2){
            Calendar calendar = Calendar.getInstance();
            int currYear = calendar.get(Calendar.YEAR);
            Long startTime = new Date("4/1/" + currYear).getTime();
            Long endTime = new Date("4/30" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu4 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("5/1/" + currYear).getTime();
            endTime = new Date("5/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu5 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("6/1/" + currYear).getTime();
            endTime = new Date("6/30" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu6 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            int chiThang4= 0,chiThang5 = 0,chiThang6 = 0;
            for(int i = 0 ; i < chiTieu4.size() ; i ++){
                if(chiTieu4.get(i).get_THU() == 0){
                    chiThang4 = chiThang4 + Integer.parseInt(chiTieu4.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu5.size() ; i ++){
                if(chiTieu5.get(i).get_THU() == 0){
                    chiThang5 = chiThang5 + Integer.parseInt(chiTieu5.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu6.size() ; i ++){
                if(chiTieu6.get(i).get_THU() == 0){
                    chiThang6 = chiThang6 + Integer.parseInt(chiTieu6.get(i).get_MONEY());
                }
            }

            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(chiThang4, 0));
            entries.add(new Entry(chiThang5, 1));
            entries.add(new Entry(chiThang6, 2));

            LineDataSet dataset = new LineDataSet(entries, "VND");

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Thang 4");
            labels.add("Thang 5");
            labels.add("Thang 6");

            LineData data = new LineData(labels, dataset);
            lineChart.setData(data); // set the data and list of lables into chart

            lineChart.setDescription("Tien Chi");  // set the description
        }
        else if(loai == 3){
            Calendar calendar = Calendar.getInstance();
            int currYear = calendar.get(Calendar.YEAR);
            Long startTime = new Date("7/1/" + currYear).getTime();
            Long endTime = new Date("7/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu7 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("8/1/" + currYear).getTime();
            endTime = new Date("8/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu8 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("9/1/" + currYear).getTime();
            endTime = new Date("9/30" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu9 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            int chiThang7 = 0,chiThang8 = 0,chiThang9 = 0;
            for(int i = 0 ; i < chiTieu7.size() ; i ++){
                if(chiTieu7.get(i).get_THU() == 0){
                    chiThang7 = chiThang7 + Integer.parseInt(chiTieu7.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu8.size() ; i ++){
                if(chiTieu8.get(i).get_THU() == 0){
                    chiThang8 = chiThang8 + Integer.parseInt(chiTieu8.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu9.size() ; i ++){
                if(chiTieu9.get(i).get_THU() == 0){
                    chiThang9 = chiThang9 + Integer.parseInt(chiTieu9.get(i).get_MONEY());
                }
            }

            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(chiThang7, 0));
            entries.add(new Entry(chiThang8, 1));
            entries.add(new Entry(chiThang9, 2));

            LineDataSet dataset = new LineDataSet(entries, "VND");

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Thang 7");
            labels.add("Thang 8");
            labels.add("Thang 9");

            LineData data = new LineData(labels, dataset);
            lineChart.setData(data); // set the data and list of lables into chart

            lineChart.setDescription("Tien Chi");  // set the description
        }
        else if(loai == 4){
            Calendar calendar = Calendar.getInstance();
            int currYear = calendar.get(Calendar.YEAR);
            Long startTime = new Date("10/1/" + currYear).getTime();
            Long endTime = new Date("10/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu10 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("11/1/" + currYear).getTime();
            endTime = new Date("11/30" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu11 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            startTime = new Date("12/1/" + currYear).getTime();
            endTime = new Date("12/31" +"/" + currYear).getTime();
            List<ChiTieu> chiTieu12 = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
            int chiThang10 = 0,chiThang11 = 0,chiThang12 = 0;
            for(int i = 0 ; i < chiTieu10.size() ; i ++){
                if(chiTieu10.get(i).get_THU() == 0){
                    chiThang10 = chiThang10 + Integer.parseInt(chiTieu10.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu11.size() ; i ++){
                if(chiTieu11.get(i).get_THU() == 0){
                    chiThang11 = chiThang11 + Integer.parseInt(chiTieu11.get(i).get_MONEY());
                }
            }
            for(int i = 0 ; i < chiTieu12.size() ; i ++){
                if(chiTieu12.get(i).get_THU() == 0){
                    chiThang12 = chiThang12 + Integer.parseInt(chiTieu12.get(i).get_MONEY());
                }
            }

            ArrayList<Entry> entries = new ArrayList<>();
            entries.add(new Entry(chiThang10, 0));
            entries.add(new Entry(chiThang11, 1));
            entries.add(new Entry(chiThang12, 2));

            LineDataSet dataset = new LineDataSet(entries, "VND");

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Thang 10");
            labels.add("Thang 11");
            labels.add("Thang 12");

            LineData data = new LineData(labels, dataset);
            lineChart.setData(data); // set the data and list of lables into chart

            lineChart.setDescription("Tien Chi");  // set the description
        }


    }
}

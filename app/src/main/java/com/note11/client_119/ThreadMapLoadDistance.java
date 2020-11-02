package com.note11.client_119;

import android.graphics.Color;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

public class ThreadMapLoadDistance extends Thread{
    AppCompatActivity aThreadMapLoadDistance;
    Handler handler;
    TMapPoint tMapPointStart;
    TMapPoint tMapPointEnd;
    TMapView tMapView;

    public ThreadMapLoadDistance(AppCompatActivity appCompatActivity){
        aThreadMapLoadDistance = appCompatActivity;
        tMapView = new TMapView(aThreadMapLoadDistance);
        tMapView.setSKTMapApiKey( "l7xxaede1cbc3d2e43569b3e4d9abfb76430" );
        tMapPointStart = new TMapPoint(37.5178656,126.857308);
        tMapPointEnd = new TMapPoint(37.551135, 126.988205);
        handler = new Handler();
    }

    @Override
    public void run() {
        super.run();
                try {
                    System.out.println("들어옴");
                    TMapPolyLine tMapPolyLine = new TMapData().findPathData(tMapPointStart, tMapPointEnd);
                    tMapPolyLine.setLineColor(Color.BLUE);
                    tMapPolyLine.setLineWidth(2);
                    double Distance = tMapPolyLine.getDistance();
                    System.out.println("result : " + Math.round(Distance));

                }catch(Exception e) {
                    e.printStackTrace();
                }
    }
}

package com.note11.client_119.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.note11.client_119.R;
import com.note11.client_119.ThreadMapLoadDistance;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

public class TestActivity extends AppCompatActivity {

    ThreadMapLoadDistance cThreadMapLoadDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);
        linearLayoutTmap.addView( tMapView );

        tMapView.setSKTMapApiKey( "l7xxaede1cbc3d2e43569b3e4d9abfb76430" );

        cThreadMapLoadDistance = new ThreadMapLoadDistance(this);
        cThreadMapLoadDistance.start();

//        TMapData tmapdata = new TMapData();
//
//        TMapPoint startpoint = new TMapPoint(37.570841, 126.985302);
//        TMapPoint endpoint = new TMapPoint(37.523860, 126.862690);
//
//        TMapPoint tMapPointStart = new TMapPoint(37.570841, 126.985302); // SKT타워(출발지)
//        TMapPoint tMapPointEnd = new TMapPoint(37.551135, 126.988205); // N서울타워(목적지)

//        double Distance = 0;
//        try {
//            TMapPolyLine tMapPolyLine = tmapdata.findPathData(startpoint, startpoint);
//            tMapPolyLine.setLineColor(Color.BLUE);
//            tMapPolyLine.setLineWidth(2);
////            tMapView.addTMapPolyLine("Line1", tMapPolyLine);
//            Distance = tMapPolyLine.getDistance();
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("result : " + Distance);

        //!< tmap 직선 거리 구하기
        /*TMapPolyLine tpolyline = new TMapPolyLine();
        tpolyline.setLineColor(Color.BLUE); //Color.parseColor("#00ff0000")
        tpolyline.setLineWidth(2);
        tpolyline.addLinePoint(startpoint);
        tpolyline.addLinePoint(endpoint);

        tMapView.addTMapPolyLine("TestID", tpolyline);

        double Distance = tpolyline.getDistance();

        System.out.println("distance : " + Distance);*/

//        tmapdata.findPathDataAll(startpoint, endpoint, doc -> {
//            //doc가 Document타입의 xml 문서임.
//            //거기서 distance값
//            //TODO doc에서 총 거리 가져오기
//        });

        //!< tmap findpathdata
//        tmapdata.findPathDataAllType(TMapData.TMapPathType.PEDESTRIAN_PATH ,startpoint, endpoint, new TMapData.FindPathDataAllListenerCallback() {
//            @Override
//            public void onFindPathDataAll(Document document) {
//                Element root = document.getDocumentElement();
//                NodeList nodeListPlacemark = root.getElementsByTagName("Placemark");
//                for( int i=0; i<nodeListPlacemark.getLength(); i++ ) {
//                    NodeList nodeListPlacemarkItem = nodeListPlacemark.item(i).getChildNodes();
//                    for( int j=0; j<nodeListPlacemarkItem.getLength(); j++ ) {
//                        if( nodeListPlacemarkItem.item(j).getNodeName().equals("description") ) {
//                            Log.d("debug", nodeListPlacemarkItem.item(j).getTextContent().trim() );
//                        }
//                    }
//                }
//            }
//        });

        //!< jsoup 파싱
//        private class Description extends AsyncTask<Void, Void, Void> {
//
//            //진행바표시
//            private ProgressDialog progressDialog;
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//
//                //진행다일로그 시작
//                progressDialog = new ProgressDialog(TestActivity.this);
//                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                progressDialog.setMessage("잠시 기다려 주세요.");
//                progressDialog.show();
//
//            }
//
//            @Override
//            protected Void doInBackground(Void... params) {
//                try {
//
//                    Document doc = Jsoup.connect("").get();
////                Elements mElementDataSize = doc.select("div[class=new-feature]").select("p");
////                int mElementSize = mElementDataSize.size();
////
////
////                for (Element element : mElementDataSize){
////
////                    String confirmed = element.select("p a").text();
////                    System.out.println("result : " + confirmed);
////                }
//
//                    Elements mElementDataSize = doc.select("item").select("sense").select("definition");
//                    Elements mElementDataSize2 = doc.select("item").select("word");
//                    int mElementSize = mElementDataSize.size();
//                    int i = 0;
//                    int j = 0;
//                    for (org.jsoup.nodes.Element element : mElementDataSize2){
//                        String confirmed = element.text();
//                        System.out.println("result word " +j + " : " + confirmed);
//
//                        j++;
//                    }
//                    for (Element element : mElementDataSize){
//                        String confirmed = element.text();
//                        System.out.println("result definition " +i + " : " + confirmed);
//
//                        i++;
//                    }
//
//                /*
//                Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
//                Elements mElementDataSize = doc.select("ul[class=lst_detail_t1]").select("li"); //필요한 놈만
//                int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다. 마구니가 가득하구나
//
//                for(Element elem : mElementDataSize){ //이렇게 요긴한 기능이
//
//                    String my_title = elem.select("li dt[class=tit] a").text();
//                    String my_link = elem.select("li div[class=thumb] a").attr("href");
//                    String my_imgUrl = elem.select("li div[class=thumb] a img").attr("src");
//                    list.add(new ItemObject(my_title, my_imgUrl, my_link, my_release, my_director));
//                }
//
//                */
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void result) {
////            MyAdapter myAdapter = new MyAdapter(list);
//                //           RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                //           recyclerView.setLayoutManager(layoutManager);
//                //         recyclerView.setAdapter(myAdapter);
//                progressDialog.dismiss();
//            }
//        }

    }
}
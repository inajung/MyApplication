package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    //InfoResult에서 올 변수들 미리 전역변수로 선언
    InfoResult setResult;
    ElasticResult infoER;
    String[] imageTitle;
    String storeName;
    Object service;
    Object taste;
    Object price;
    Object mood;
    String summary;
    Object reviewNum;
    String tagString;
    ArrayList<Object> commentReview;
    ArrayList<Object> tagArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);

        //Toolbar area
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button button_home = (Button) findViewById(R.id.button_home);

        button_home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Recycler area
        //인텐트에서 온 변수들 다 담아주기
        Intent intent = getIntent(); //Camera2Activity에서 보낸 데이터 수신
        setResult = (InfoResult) intent.getSerializableExtra("InfoResult");
        infoER = setResult.getInfoER();
        imageTitle = setResult.getImageTitle();
        storeName = infoER.get상호명();
        service = infoER.get서비스();
        taste = infoER.get맛();
        price = infoER.get가격();
        mood = infoER.get분위기();
        summary = infoER.get요약();
        reviewNum = infoER.get리뷰개수();
        tagArray = infoER.태그;
        commentReview = infoER.코멘트;

        //태그 한 문장으로 만들기
        for (Object obj : tagArray) {
            tagString += "#" + obj + " ";
        }

        //Object을 String으로 변환
        String sReviewNum = String.valueOf(reviewNum);
        String sService = String.valueOf(service);
        String sMood = String.valueOf(mood);
        String sTaste = String.valueOf(taste);
        String sPrice = String.valueOf(price);

        //리뷰 뽑아내기
        String comment = (String) commentReview.get(0);
        String comment1 = (String) commentReview.get(1);
        String comment2 = (String) commentReview.get(2);
        String comment3 = (String) commentReview.get(3);
        String comment4 = (String) commentReview.get(4);
        String comment5 = (String) commentReview.get(5);
        String comment6 = (String) commentReview.get(6);
        String comment7 = (String) commentReview.get(7);
        String comment8 = (String) commentReview.get(8);
        String comment9 = (String) commentReview.get(9);

        //ImageURL 확보
        String thumbNailImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/thumbnail/" + imageTitle[0];
        String menu1ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[1];
        String menu2ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[2];
        String menu3ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[3];
        String menu4ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[4];
        String menu5ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[5];
        String menu6ImgURL = "http://eb-cracker.w2x4ufppj2.ap-northeast-2.elasticbeanstalk.com/static/" + storeName + "/menu/" + imageTitle[6];

        //------- RecyclerView 순서지정 및 데이터 입력해 주는 코드
        ArrayList<MultiViewTypeModel> list = new ArrayList();
        list.add(new MultiViewTypeModel(MultiViewTypeModel.IMAGEANDTEXT_TYPE, storeName, "총 " + sReviewNum + "개의 리뷰요약", summary, thumbNailImgURL)); //상호명,리뷰수,요약,썸네일
        list.add(new MultiViewTypeModel(MultiViewTypeModel.TEXTVIEW_TYPE, tagString));
        list.add(new MultiViewTypeModel(MultiViewTypeModel.PICTOGRAMINLINE_TYPE, "- WHAT PEOPLE LIKE -", sTaste, sPrice, sMood, sService));
        list.add(new MultiViewTypeModel(MultiViewTypeModel.IMAGEINLINEWTITLE_TYPE, "- WHAT PEOPLE EAT -", menu1ImgURL, menu2ImgURL, menu3ImgURL, menu4ImgURL, menu5ImgURL, menu6ImgURL));
        list.add(new MultiViewTypeModel(MultiViewTypeModel.REVIEWINCARD_TYPE, "- WHAT PEOPLE SAY -", comment, comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8, comment9, "리뷰 더보기"));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_result);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
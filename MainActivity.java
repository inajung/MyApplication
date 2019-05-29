package com.example.myapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //resultCode int값 설정
    private final static int MY_PERMISSION_CAMERA = 1111;

    //변수 선언
    FloatingActionButton floatbtn;
    ArrayList<RecInRecTypeModel> allSampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //플로트버튼 뷰와 연결
        floatbtn = (FloatingActionButton) findViewById(R.id.floatButton);

        //data담기
        allSampleData = new ArrayList<RecInRecTypeModel>();
        createDataForCracker();
        createDataForExplore();
        createDataForMagazine();

        //리사이클러 뷰 셋팅
        RecyclerView main_recycler = (RecyclerView) findViewById(R.id.recycler_view_main);
        main_recycler.setHasFixedSize(true);

        VerticalRecyclerTypeAdapter adapter = new VerticalRecyclerTypeAdapter(this, allSampleData);
        main_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        main_recycler.setAdapter(adapter);

        ///////////////////사용자에게 권한 허락받기////////////////////
        checkPermission();

        ////////////////////다음 액티비티로 가기 ////////////////////
        floatbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Camera2Activity.class);
                startActivity(intent);
            }
        });

    }

    ////////////////////View에 보일 Data담기(시작)////////////////////
    private void createDataForCracker() {
        RecInRecTypeModel dm = new RecInRecTypeModel();

        dm.setHeaderTitle("WHAT IS CRACKER");

        ArrayList<SingleRecViewTypeModel> singleItem = new ArrayList<SingleRecViewTypeModel>();
        singleItem.add(new SingleRecViewTypeModel(R.drawable.takephoto1, "Take Photo, Get Result", "음식점 간판을 찍으면, 필요한 정보가 딱~!"));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.beexplorer, "Be an Explorer", "새로운 음식과 취향을 발견하고 나누세요."));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.work, "Let Us Work for YOU", "이미지 한국어인식, 자연어처리와 빅데이터"));

        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);
    }

    public void createDataForExplore() {

        RecInRecTypeModel dm = new RecInRecTypeModel();

        dm.setHeaderTitle("WHAT IS HOT");

        ArrayList<SingleRecViewTypeModel> singleItem = new ArrayList<SingleRecViewTypeModel>();
        singleItem.add(new SingleRecViewTypeModel(R.drawable.explore1, "블루보틀", "성수동"));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.explore2, "더백푸드트럭", "이태원"));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.explore3, "샐러드셀러", "한강"));

        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);

    }

    private void createDataForMagazine() {
        RecInRecTypeModel dm = new RecInRecTypeModel();

        dm.setHeaderTitle("FOOD MAGAZINE");

        ArrayList<SingleRecViewTypeModel> singleItem = new ArrayList<SingleRecViewTypeModel>();
        singleItem.add(new SingleRecViewTypeModel(R.drawable.magazine1, "CHEEEEESE~!", "치즈 A부터 Z까지"));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.magazine2, "CHEF,백종원", "믿고 먹는 그의 가게들"));
        singleItem.add(new SingleRecViewTypeModel(R.drawable.magazine3, "삼복더위보양백서", "미쉐린추천부터 동네맛집까지"));

        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);
    }
    ////////////////////View에 보일 Data담기(끝)////////////////////

    ////////////////////사용자 권한 허락 메소드 영역(시작)////////////////////
    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if ((ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) || (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))) {
                new AlertDialog.Builder(this)
                        .setTitle("알림")
                        .setMessage("저장소 권한이 거부되었습니다. 사용을 원하시면 설정에서 해당 권한을 직접 허용해주세요")
                        .setNeutralButton("설정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                intent.setData(Uri.parse("package:" + getPackageName()));
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_CAMERA);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_CAMERA:
                for (int i = 0; i < grantResults.length; i++) {
                    //grantResults[] : 허용된 권한은 0, 거부한 권한은 -1
                    if (grantResults[i] < 0) {
                        Toast.makeText(MainActivity.this, "해당권한을 활성화 하셔야 합니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                //허용했다면 이 부분에서..
                break;
        }
    }
    ////////////////////사용자 권한 허락 메소드 영역(끝)///////////////////////
}

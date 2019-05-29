
package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Camera2Activity extends AppCompatActivity implements View.OnTouchListener {

    private TextureView mCameraTextureView;
    private Preview mPreview;
    private ImageView iv;
    private TextView tv;
    Activity mainActivity = this;
    private static final String TAG = "MAINACTIVITY";
    static final int REQUEST_CAMERA = 1;

    //터치 이벤트의 좌표를 받아올 변수
    public static float x = -1, y = -1;

    //GPS좌표 담을 변수
    double longitude;
    double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera2);

        mCameraTextureView = (TextureView) findViewById(R.id.cameraTextureView);
        mPreview = new Preview(this, mCameraTextureView);
        iv = (ImageView) findViewById(R.id.iv_frame_loading);
        tv = (TextView) findViewById(R.id.tv_progress_message);

        //촬영방법설명
        Toast.makeText(getApplicationContext(), "검색하고자 하는 음식점의 간판을 터치해주세요", Toast.LENGTH_LONG).show();

        //카메라 텍스쳐뷰 터치 리스너 등록
        mCameraTextureView.setOnTouchListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];
                    if (permission.equals(Manifest.permission.CAMERA)) {
                        if (grantResult == PackageManager.PERMISSION_GRANTED) {
                            mCameraTextureView = (TextureView) findViewById(R.id.cameraTextureView);
                            mPreview = new Preview(mainActivity, mCameraTextureView);
                            Log.d(TAG, "mPreview set");
                        } else {
                            Toast.makeText(this, "Should have camera permission to run", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPreview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPreview.onPause();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "result " + event.toString());
        switch (event.getAction()) {

            //Down이 발생한 경우
            case MotionEvent.ACTION_DOWN:
                //상대좌표 얻기 (절대좌표는 getRawX
                float parentWid = ((ViewGroup) v.getParent()).getWidth();
                float parentHei = ((ViewGroup) v.getParent()).getHeight();
                //좌표 %환산
                x = (event.getRawX() / parentWid);
                y = (event.getRawY() / parentHei);

                //화면변환
                tv.setText("Searching...");
                iv.setImageResource(R.drawable.frame_loading_01);
                //preview thread의 takePicture메소드 시작
                mPreview.takePicture(x, y);

                //Up이 발생한 경우
            case MotionEvent.ACTION_UP:
                break;

        }
        //false를 반환하여 뷰 내에 재정의한 onTouchEvent 메소드로 이벤트를 전달한다
        return false;
    }
}


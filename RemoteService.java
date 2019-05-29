package com.example.myapplication;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RemoteService {

    //이미지보내는 코드(위치, 터치좌표 별도로 삽입)
    @Multipart
    @POST("tfserving/predict/")
    Call<InfoResult> setPhotowG(
            //@Part("location") RequestBody location,
            @Part("touchPoint") RequestBody touchPoint,
            @Part MultipartBody.Part file);
}


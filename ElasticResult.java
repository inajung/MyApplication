package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

class ElasticResult implements Serializable {

    @SerializedName("상호명")
    @Expose
    private String 상호명;
    @SerializedName("코멘트")
    @Expose
    ArrayList < Object > 코멘트 = new ArrayList < Object > ();
    @SerializedName("요약")
    @Expose
    private String 요약;
    @SerializedName("리뷰개수")
    @Expose
    private Object 리뷰개수;
    @SerializedName("서비스")
    @Expose
    private Object 서비스;
    @SerializedName("분위기")
    @Expose
    private Object 분위기;
    @SerializedName("가격")
    @Expose
    private Object 가격;
    @SerializedName("맛")
    @Expose
    private Object 맛;
    @SerializedName("태그")
    @Expose
    ArrayList < Object > 태그 = new ArrayList < Object > ();


    // Getter Methods

    public String get상호명() {
        return 상호명;
    }

    public String get요약() {
        return 요약;
    }

    public Object get리뷰개수() {
        return 리뷰개수;
    }

    public Object get서비스() {
        return 서비스;
    }

    public Object get분위기() {
        return 분위기;
    }

    public Object get가격() {
        return 가격;
    }

    public Object get맛() {
        return 맛;
    }

    // Setter Methods

    public void set상호명(String 상호명) {
        this.상호명 = 상호명;
    }

    public void set요약(String 요약) {
        this.요약 = 요약;
    }

    public void set리뷰개수(Object 리뷰개수) {
        this.리뷰개수 = 리뷰개수;
    }

    public void set서비스(Object 서비스) {
        this.서비스 = 서비스;
    }

    public void set분위기(Object 분위기) {
        this.분위기 = 분위기;
    }

    public void set가격(Object 가격) {
        this.가격 = 가격;
    }

    public void set맛(Object 맛) {
        this.맛 = 맛;
    }
}








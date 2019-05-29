package com.example.myapplication;

import java.util.ArrayList;

public class MultiViewTypeModel {

    public static final int TEXTCARDVIEW_TYPE = 0;
    public static final int IMAGEANDTEXT_TYPE = 1;
    public static final int TEXTVIEW_TYPE = 2;
    public static final int IMAGEINLINE_TYPE = 3;
    public static final int PICTOGRAMINLINE_TYPE = 4;
    public static final int SECTIONTITLE_TYPE = 5;
    public static final int IMAGEINLINEWTITLE_TYPE = 6;
    public static final int REVIEWINCARD_TYPE = 7;


    public int type;
    public String str;
    public String str1;
    public String str2;
    public String str3;
    public String str4;
    public String str5;
    public String str6;
    public String str7;
    public String str8;
    public String str9;
    public String str10;
    public String str11;
    public String[] strArray;
    public int pic;
    public int pic1;
    public int pic2;
    public int pic3;
    public int pic4;
    public int pic5;
    public ArrayList<SingleRecViewTypeModel> allItemsInSection;

    //Textview_type,Textcardview_type,Sectiontitle_type
    public MultiViewTypeModel(int type, String str) {
        this.type = type;
        this.str = str;
    }

    //Imageinline_type(URL이미지주소)
    public MultiViewTypeModel(int type, String str, String str1, String str2) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
    }

    //Imageinline_type(R.drawble)
    public MultiViewTypeModel(int type, int pic, int pic1, int pic2) {
        this.type = type;
        this.pic = pic;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    //Imageinlinewtitle_type(URL)
    public MultiViewTypeModel(int type, String str, String str1, String str2, String str3, String str4, String str5, String str6) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
    }

    //reviewcard_type
    public MultiViewTypeModel(int type, String str, String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
        this.str7 = str7;
        this.str8 = str8;
        this.str9 = str9;
        this.str10 = str10;
        this.str11 = str11;
    }

    //Imageandtext_type(상호명,요약,리뷰개수,URL이미지주소)
    public MultiViewTypeModel(int type, String str, String str1, String str2, String str3) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    //Pictograminline_type
    public MultiViewTypeModel(int type, String str, String str1, String str2, String str3, String str4) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
    }

    //Imageandtext_type(상호명,요약,리뷰개수,R.drawble이미지)
    public MultiViewTypeModel(int type, String str, String str1, String str2, int pic) {
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.str2 = str2;
        this.pic = pic;
    }
}

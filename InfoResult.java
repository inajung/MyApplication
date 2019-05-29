
package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable; //위 SerializedName과 겹침?


class InfoResult implements Serializable {

    @SerializedName("response_es")
    @Expose
    private ElasticResult infoER;
    @SerializedName("url_list")
    @Expose
    private String[] imageTitle; //이미지파일이름리스트

    // Getter Methods
    public ElasticResult getInfoER() {
        return infoER;
    }
    public String[] getImageTitle(){
        return imageTitle;
    }

    // Setter Methods
    public void setInfoER(ElasticResult infoER) {
        this.infoER = infoER;
    }
    public void setImageTitle(String[] imageTitle) { this.imageTitle = imageTitle;}

    public String toString(){
      return infoER.get상호명() + getImageTitle()[0];
    };
}



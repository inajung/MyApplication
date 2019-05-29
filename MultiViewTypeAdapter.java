package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    private ArrayList<MultiViewTypeModel> dataSet;
    Context mContext;
    int total_types;

    ///// Type별 Holder만들기(시작) /////
    public static class TextCardViewTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;

        public TextCardViewTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.textView4);
        }
    }

    public static class ImageAndTextTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        TextView txtType1;
        TextView txtType2;
        ImageView image;

        public ImageAndTextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.resulttext);//상호명
            this.txtType1 = (TextView) itemView.findViewById(R.id.resulttext2);//리뷰개수
            this.txtType2 = (TextView) itemView.findViewById(R.id.resultsummary);//요약
            this.image = (ImageView) itemView.findViewById(R.id.resultimg);//썸네일
        }
    }

    public static class TextViewTypeHolder extends RecyclerView.ViewHolder {
        TextView txtType;

        public TextViewTypeHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    public static class SectionTitleTypeHolder extends RecyclerView.ViewHolder {
        TextView txtType;

        public SectionTitleTypeHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.textView_sectiontitle);
        }
    }

    public static class ImageInLineTypeViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView image1;
        ImageView image2;

        public ImageInLineTypeViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.imageView2);
            this.image1 = (ImageView) itemView.findViewById(R.id.imageView3);
            this.image2 = (ImageView) itemView.findViewById(R.id.imageView4);
        }
    }

    public static class ImageInLinewTitleTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        ImageView image;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;

        public ImageInLinewTitleTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.textView_sectiontitle);//sectionTitle
            this.image = (ImageView) itemView.findViewById(R.id.imageView2);
            this.image1 = (ImageView) itemView.findViewById(R.id.imageView3);
            this.image2 = (ImageView) itemView.findViewById(R.id.imageView4);
            this.image3 = (ImageView) itemView.findViewById(R.id.imageView5);
            this.image4 = (ImageView) itemView.findViewById(R.id.imageView6);
            this.image5 = (ImageView) itemView.findViewById(R.id.imageView7);
        }
    }

    public static class PictogramInLineTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        TextView txtType1;
        TextView txtType2;
        TextView txtType3;
        TextView txtType4;

        public PictogramInLineTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.textView_sectiontitle);
            this.txtType1 = (TextView) itemView.findViewById(R.id.pictotext);
            this.txtType2 = (TextView) itemView.findViewById(R.id.pictotext1);
            this.txtType3 = (TextView) itemView.findViewById(R.id.pictotext2);
            this.txtType4 = (TextView) itemView.findViewById(R.id.pictotext3);
        }
    }

    public static class ReviewInCardTypeHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        TextView txtType1;
        TextView txtType2;
        TextView txtType3;
        TextView txtType4;
        TextView txtType5;
        TextView txtType6;
        TextView txtType7;
        TextView txtType8;
        TextView txtType9;
        TextView txtType10;
        TextView txtType11;

        public ReviewInCardTypeHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.textView_sectiontitle);
            this.txtType1 = (TextView) itemView.findViewById(R.id.reviewtext);
            this.txtType2 = (TextView) itemView.findViewById(R.id.reviewtext1);
            this.txtType3 = (TextView) itemView.findViewById(R.id.reviewtext2);
            this.txtType4 = (TextView) itemView.findViewById(R.id.reviewtext3);
            this.txtType5 = (TextView) itemView.findViewById(R.id.reviewtext4);
            this.txtType6 = (TextView) itemView.findViewById(R.id.reviewtext5);
            this.txtType7 = (TextView) itemView.findViewById(R.id.reviewtext6);
            this.txtType8 = (TextView) itemView.findViewById(R.id.reviewtext7);
            this.txtType9 = (TextView) itemView.findViewById(R.id.reviewtext8);
            this.txtType10 = (TextView) itemView.findViewById(R.id.reviewtext9);
            this.txtType11 = (TextView) itemView.findViewById(R.id.reviewtext10);
        }
    }
    ///// Type별 Holder만들기(끝) /////

    ///// 실제 SearchResultActivity에서 사용할 MultiViewTypeAdapter메소드 생성 /////
    public MultiViewTypeAdapter(ArrayList<MultiViewTypeModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    ///// Type별 사용할 Layout지정 /////
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case MultiViewTypeModel.TEXTCARDVIEW_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textcardview, parent, false);
                return new TextCardViewTypeViewHolder(view);
            case MultiViewTypeModel.IMAGEANDTEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageandtext_type, parent, false);
                return new ImageAndTextTypeViewHolder(view);
            case MultiViewTypeModel.TEXTVIEW_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_type, parent, false);
                return new TextViewTypeHolder(view);
            case MultiViewTypeModel.SECTIONTITLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sectiontitle, parent, false);
                return new SectionTitleTypeHolder(view);
            case MultiViewTypeModel.IMAGEINLINE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageinline_type, parent, false);
                return new ImageInLineTypeViewHolder(view);
            case MultiViewTypeModel.PICTOGRAMINLINE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pictograminline_type, parent, false);
                return new PictogramInLineTypeViewHolder(view);
            case MultiViewTypeModel.IMAGEINLINEWTITLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageinlinewtitle_type, parent, false);
                return new ImageInLinewTitleTypeViewHolder(view);
            case MultiViewTypeModel.REVIEWINCARD_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviewincard_type, parent, false);
                return new ReviewInCardTypeHolder(view);
        }
        return null;
    }

    public int getItemViewType(int position) {
        switch (dataSet.get(position).type) {
            case 0:
                return MultiViewTypeModel.TEXTCARDVIEW_TYPE;
            case 1:
                return MultiViewTypeModel.IMAGEANDTEXT_TYPE;
            case 2:
                return MultiViewTypeModel.TEXTVIEW_TYPE;
            case 3:
                return MultiViewTypeModel.IMAGEINLINE_TYPE;
            case 4:
                return MultiViewTypeModel.PICTOGRAMINLINE_TYPE;
            case 5:
                return MultiViewTypeModel.SECTIONTITLE_TYPE;
            case 6:
                return MultiViewTypeModel.IMAGEINLINEWTITLE_TYPE;
            case 7:
                return MultiViewTypeModel.REVIEWINCARD_TYPE;
            default:
                return -1;
        }
    }

    ///// onBindViewHolder /////
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        MultiViewTypeModel object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case MultiViewTypeModel.TEXTCARDVIEW_TYPE:
                    ((TextCardViewTypeViewHolder) holder).txtType.setText(object.str);
                    break;

                /////////////////////////////////////////레이아웃 조정끝나면 object의 pic(int)을 str로 바꿔야 서버에서부터 온 이미지가 뜬다.
                case MultiViewTypeModel.IMAGEANDTEXT_TYPE:
                    ((ImageAndTextTypeViewHolder) holder).txtType.setText(object.str); //상호명
                    ((ImageAndTextTypeViewHolder) holder).txtType1.setText(object.str1); //리뷰개수
                    ((ImageAndTextTypeViewHolder) holder).txtType2.setText(object.str2); //요약
                    Glide.with(holder.itemView.getContext())
                            .load(object.str3).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageAndTextTypeViewHolder) holder).image);
                    break;
                case MultiViewTypeModel.TEXTVIEW_TYPE:
                    ((TextViewTypeHolder) holder).txtType.setText(object.str);
                    break;
                case MultiViewTypeModel.SECTIONTITLE_TYPE:
                    ((SectionTitleTypeHolder) holder).txtType.setText(object.str);
                    break;
                //////////레이아웃 조정끝나면 object의 pic을 str로 바꿔야 서버에서부터 온 이미지가 뜬다.
                case MultiViewTypeModel.IMAGEINLINEWTITLE_TYPE:
                    ((ImageInLinewTitleTypeViewHolder) holder).txtType.setText(object.str);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str1).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str2).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image1);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str3).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image2);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str4).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image3);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str5).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image4);
                    Glide.with(holder.itemView.getContext())
                            .load(object.str6).addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(((ImageInLinewTitleTypeViewHolder) holder).image5);
                    break;
                case MultiViewTypeModel.PICTOGRAMINLINE_TYPE:
                    ((PictogramInLineTypeViewHolder) holder).txtType.setText(object.str);
                    ((PictogramInLineTypeViewHolder) holder).txtType1.setText(object.str1);
                    ((PictogramInLineTypeViewHolder) holder).txtType2.setText(object.str2);
                    ((PictogramInLineTypeViewHolder) holder).txtType3.setText(object.str3);
                    ((PictogramInLineTypeViewHolder) holder).txtType4.setText(object.str4);
                    break;
                case MultiViewTypeModel.REVIEWINCARD_TYPE:
                    ((ReviewInCardTypeHolder) holder).txtType.setText(object.str);
                    ((ReviewInCardTypeHolder) holder).txtType1.setText(object.str1);
                    ((ReviewInCardTypeHolder) holder).txtType2.setText(object.str2);
                    ((ReviewInCardTypeHolder) holder).txtType3.setText(object.str3);
                    ((ReviewInCardTypeHolder) holder).txtType4.setText(object.str4);
                    ((ReviewInCardTypeHolder) holder).txtType5.setText(object.str5);
                    ((ReviewInCardTypeHolder) holder).txtType6.setText(object.str6);
                    ((ReviewInCardTypeHolder) holder).txtType7.setText(object.str7);
                    ((ReviewInCardTypeHolder) holder).txtType8.setText(object.str8);
                    ((ReviewInCardTypeHolder) holder).txtType9.setText(object.str9);
                    ((ReviewInCardTypeHolder) holder).txtType10.setText(object.str10);
                    ((ReviewInCardTypeHolder) holder).txtType11.setText(object.str11);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

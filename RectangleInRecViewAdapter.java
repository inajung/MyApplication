package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RectangleInRecViewAdapter extends RecyclerView.Adapter<RectangleInRecViewAdapter.RectangleHolder> {
    private ArrayList<SingleRecViewTypeModel> itemsList;
    private Context mContext;

    public RectangleInRecViewAdapter(Context context, ArrayList<SingleRecViewTypeModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public RectangleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rectanglecard_type, null);
        RectangleHolder mh = new RectangleHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(RectangleInRecViewAdapter.RectangleHolder holder, int i) {

        SingleRecViewTypeModel singleItem = itemsList.get(i);

        holder.image.setImageResource(singleItem.getDrawable());
        holder.firstLine.setText(singleItem.getFirstLine());
        holder.secondLine.setText(singleItem.getSecondLine());
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class RectangleHolder extends RecyclerView.ViewHolder {

        protected TextView firstLine;
        protected TextView secondLine;
        protected ImageView image;

        public RectangleHolder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.explore);
            this.firstLine = (TextView) view.findViewById(R.id.storename);
            this.secondLine = (TextView) view.findViewById(R.id.storelocation);
        }
    }
}
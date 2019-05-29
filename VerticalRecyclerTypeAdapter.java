
package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class VerticalRecyclerTypeAdapter extends RecyclerView.Adapter<VerticalRecyclerTypeAdapter.MainInnerRowHolder> {

    private ArrayList<RecInRecTypeModel> dataList;
    private Context mContext;

    public VerticalRecyclerTypeAdapter(Context context, ArrayList<RecInRecTypeModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public MainInnerRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_inner_recycler, null);
        MainInnerRowHolder mh = new MainInnerRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(MainInnerRowHolder mainInnerRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        mainInnerRowHolder.itemTitle.setText(sectionName);

        RectangleInRecViewAdapter itemListDataAdapter = new RectangleInRecViewAdapter(mContext, singleSectionItems);

        mainInnerRowHolder.recycler_view_list.setHasFixedSize(true);
        mainInnerRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mainInnerRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class MainInnerRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;

        public MainInnerRowHolder(View view) {
            super(view);
            this.itemTitle = (TextView) view.findViewById(R.id.textView_title);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_h1);
        }

    }


}

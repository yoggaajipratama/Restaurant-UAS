package com.restaurant.yogga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.restaurant.yogga.R;
import com.restaurant.yogga.model.RestaurantItem;
import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {
    List<RestaurantItem> listItem;
    TextView tvRestaurantName;
    View view;
    ImageView ivRestaurantPhoto;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener
                                               mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public RestaurantAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_restaurant, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        RestaurantItem item = listItem.get(position);
        ivRestaurantPhoto = holder.itemView.findViewById(R.id.iv_restaurant);
        tvRestaurantName = holder.itemView.findViewById(R.id.tv_restaurant_name);
        Glide.with(ctx).load(item.getFoto()).into(ivRestaurantPhoto);
        tvRestaurantName.setText(item.getNamarm());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void add(RestaurantItem item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }

    public void addAll(List<RestaurantItem> listItem) {
        for (RestaurantItem item : listItem) {
            add(item);
        }
    }

    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }

    public void remove(int pos) {
        listItem.remove(pos);
        notifyDataSetChanged();
    }

    public void swap(List<RestaurantItem> datas) {
        if (datas == null || datas.size() == 0) listItem.clear();
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();
    }

    public RestaurantItem getItem(int pos) {
        return listItem.get(pos);
    }

    public void setFilter(List<RestaurantItem> list) {
        listItem = new ArrayList<>();
        listItem.addAll(list);
        notifyDataSetChanged();
    }

    public List<RestaurantItem> getListItem() {
        return listItem;
    }
}
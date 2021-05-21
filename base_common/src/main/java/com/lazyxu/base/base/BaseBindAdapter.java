package com.lazyxu.base.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBindAdapter<DB extends ViewDataBinding, T> extends RecyclerView.Adapter<BaseBindAdapter.BindViewHolder> {

    private List<T> list;
    private int resourceId;

    public BaseBindAdapter(List<T> list, int resourceId) {
        this.list = list;
        this.resourceId = resourceId;
        if (this.list == null) {
            this.list = new ArrayList<T>();
        }
    }

    @NonNull
    @Override
    public BaseBindAdapter.BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DB db = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), resourceId, parent, false);
        BindViewHolder holder = new BindViewHolder(db.getRoot());
        holder.bindView = db;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindAdapter.BindViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BindViewHolder extends RecyclerView.ViewHolder {

        public DB bindView;

        public BindViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

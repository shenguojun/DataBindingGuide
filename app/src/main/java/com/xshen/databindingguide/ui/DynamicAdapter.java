package com.xshen.databindingguide.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xshen.databindingguide.databinding.DynamicTextViewBinding;

/**
 * 说明：RecyclerView adapter
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-24 23:01
 */
public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder> {
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public DynamicTextViewBinding binding;

        public ViewHolder(DynamicTextViewBinding b) {
            super(b.getRoot());
            binding = b;
        }

        public DynamicTextViewBinding getBinding() {
            return binding;
        }
    }

    public DynamicAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DynamicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DynamicTextViewBinding binding = DynamicTextViewBinding.inflate(layoutInflater, parent, false);
        ViewHolder vh = new ViewHolder(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setText(mDataset[position]);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

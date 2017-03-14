package com.android.indie.school.mysimpledatabinding.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.indie.school.mysimpledatabinding.R;
import com.android.indie.school.mysimpledatabinding.databinding.ItemEmailBinding;
import com.android.indie.school.mysimpledatabinding.main.EmailViewModel;

import java.util.List;

/**
 * Created by herisulistiyanto on 3/12/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MainViewHolder> {

    private List<String> emails;

    public MyRecyclerViewAdapter(List<String> email) {
        this.emails = email;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEmailBinding itemEmailBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_email, parent, false);
        return new MainViewHolder(itemEmailBinding);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.itemEmailBinding.setViewModel(new EmailViewModel(emails.get(position)));
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private ItemEmailBinding itemEmailBinding;

        public MainViewHolder(ItemEmailBinding itemEmailBinding) {
            super(itemEmailBinding.getRoot());
            this.itemEmailBinding = itemEmailBinding;
        }
    }
}

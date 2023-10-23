package com.staygrateful.mbkmsample.ui.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.staygrateful.mbkmsample.data.model.MhsRoomModel;
import com.staygrateful.mbkmsample.databinding.ListItemMhsBinding;

public class MhsJavaListAdapter extends ListAdapter<MhsRoomModel, MhsJavaListAdapter.ViewHolder> {

    public MhsJavaListAdapter() {
        super(MhsRoomModel.getDiffUtil());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        ListItemMhsBinding binding = ListItemMhsBinding.inflate(li, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBindData(getCurrentList().get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ListItemMhsBinding binding;

        public ViewHolder(@NonNull ListItemMhsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBindData(MhsRoomModel mhsRoomModel) {
            binding.name.setText(mhsRoomModel.getMhsName());
            binding.univ.setText(mhsRoomModel.getMhsUniv());
        }
    }
}

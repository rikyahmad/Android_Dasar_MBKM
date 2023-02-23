package com.staygrateful.mbkmsample.ui.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.staygrateful.mbkmsample.data.model.MhsRoomModel;
import com.staygrateful.mbkmsample.databinding.ListItemMhsBinding;

public class SampleListAdapter extends ListAdapter<MhsRoomModel, SampleListAdapter.ViewHolder> {

    public SampleListAdapter() {
        super(MhsRoomModel.getDiffUtil());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        ListItemMhsBinding binding = ListItemMhsBinding.inflate(li, parent, false);
        return new ViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBindData(getCurrentList().get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ListItemMhsBinding binding;
        private SampleListAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull ListItemMhsBinding binding, SampleListAdapter adapter) {
            super(binding.getRoot());
            this.binding = binding;
            this.adapter = adapter;
        }

        public void onBindData(MhsRoomModel data) {
            if (data != null) {
                binding.name.setText(data.getMhsName());
                binding.univ.setText(data.getMhsUniv());
            }
        }
    }
}

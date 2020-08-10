package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.ItemAdapter;

import java.util.ArrayList;

public class SubjectNumberAdapter extends RecyclerView.Adapter<SubjectNumberAdapter.MyHolder> {

    private ArrayList<ItemAdapter> items;
    private OnItemClicked onItemClicked;

    public SubjectNumberAdapter(ArrayList<ItemAdapter> items, OnItemClicked onItemClicked) {
        this.items = items;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supject_number_alarm_fragment, parent, false);
        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ItemAdapter itemAdapter = items.get(position);
        holder.bind(position, onItemClicked);
        if (itemAdapter == null) {
            holder.tv_law.setText(null);
            return;
        }
        if (itemAdapter.getText() != null) {
            holder.tv_law.setEnabled(false);

        }
        holder.tv_law.setText(itemAdapter.getText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_law;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_law = itemView.findViewById(R.id.ed_article_number_alarm_form_fragment);
        }

        public void bind(int position, OnItemClicked onItemClicked) {
            itemView.setOnClickListener(view -> onItemClicked.itemClicked(position));
        }
    }

    public interface OnItemClicked {

        void itemClicked(int position);
    }
}

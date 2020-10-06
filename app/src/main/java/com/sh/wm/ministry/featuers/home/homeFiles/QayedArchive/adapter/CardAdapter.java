package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewArchiveItemBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveCard;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends   RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private List<ArchiveCard> cards = new ArrayList<ArchiveCard>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_archive_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String status = "مكتملة";
        ArchiveCard card = cards.get(position);
        holder.binding.requestDate.setText(card.getQayedDate());
        holder.binding.arcWorkDesc.setText(card.getWorkStatusDesc());
        holder.binding.arcWorkDescDesc.setText(card.getWorkStatusDescDesc());
        if (card.getStatus().equals(status)) {
            holder.binding.arcStatusCompleted.setVisibility(View.VISIBLE);
        }else {
            holder.binding.arcStatusInProgress.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public List<ArchiveCard> getCards() {
        return cards;
    }

    public void setCards(List<ArchiveCard> cards) {
        this.cards = cards;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewArchiveItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CardViewArchiveItemBinding.bind(itemView);
        }
    }
}

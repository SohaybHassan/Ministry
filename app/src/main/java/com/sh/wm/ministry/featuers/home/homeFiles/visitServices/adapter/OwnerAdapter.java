package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardOwnerBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.MyViewHolder> {
  private List<Owner> cards = new ArrayList<>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_archive_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       Owner card = cards.get(position);
       holder.binding.cardOwnerId.setText(card.getId());
       holder.binding.cardOwnerName.setText(card.getName());
       holder.binding.cardOwnerStart.setText(card.getStartDate());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public List<Owner> getCards() {
        return cards;
    }

    public void setCards(List<Owner> cards) {
        this.cards = cards;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder {
       private CardOwnerBinding binding ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
              binding = CardOwnerBinding.bind(itemView);

        }
    }
}

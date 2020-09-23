package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardSafeBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.SaftyQuestion;

import java.util.ArrayList;
import java.util.List;

public class SafeCardAdapter extends RecyclerView.Adapter<SafeCardAdapter.MyViewHolder>  {
private List<SaftyQuestion> cardList = new ArrayList<SaftyQuestion>();


    @NonNull
    @Override
    public SafeCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_safe, parent, false);
        return new SafeCardAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SaftyQuestion card = cardList.get(position);
        holder.binding.sfNum.setText(position+1 +"-");
        holder.binding.sfCode.setText(card.getPalLawArticalCode());
        holder.binding.sfDesc.setText(card.getPalLawArticalDesc());

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setCardList(List<SaftyQuestion> cardList) {
        this.cardList = new ArrayList<>();
        this.cardList = cardList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardSafeBinding binding ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardSafeBinding.bind(itemView);
        }
    }
}

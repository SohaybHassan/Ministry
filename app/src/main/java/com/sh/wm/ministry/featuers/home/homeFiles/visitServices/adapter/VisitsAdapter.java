package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewVisitItemBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;

import java.util.ArrayList;
import java.util.List;


public class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.MyViewHolder>  {
    List<Visit> cards = new ArrayList<Visit>();
    @NonNull
    @Override
    public VisitsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_visit_item, parent, false);
        return new MyViewHolder(itemView);
    }//end onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull VisitsAdapter.MyViewHolder holder, int position) {
             Visit card = cards.get(position);
             holder.binding.visitCmpName.setText(card.getCompanyName());
             holder.binding.visitArea.setText(card.getArea());
             holder.binding.visitStartDate.setText(card.getStartDate());
          switch (card.getStatus()){
              //enable the needed buttons depend on Status
          }//end switch
    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return cards.size();
    }//end getItemCount

    public void setCards(List<Visit> cards) {
        this.cards = cards;
    }//end setCards

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardViewVisitItemBinding binding ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardViewVisitItemBinding.bind(itemView);
            binding.visitStartBtn.setOnClickListener(this);
            binding.showResultsBtn.setOnClickListener(this);
            binding.extraServicesBtn.setOnClickListener(this);
            binding.revisitBtn.setOnClickListener(this);
            binding.visitResultBtn.setOnClickListener(this);
            binding.recommendationsBtn.setOnClickListener(this);

        }//end holder constructor

        @Override
        public void onClick(View view) {
            switch (view.getId()){
            }//end switch
        }//end onClick

    }//end ViewHolder Class

}//end VisitAdapter Class

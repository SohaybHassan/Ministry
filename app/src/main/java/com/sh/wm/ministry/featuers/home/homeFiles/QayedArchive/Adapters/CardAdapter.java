package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveCard;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
  private List<ArchiveCard> cards = new ArrayList<ArchiveCard>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_archive_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String status="مكتملة";
       ArchiveCard card = cards.get(position);
       holder.requestDate.setText(card.getQayedDate());
        holder.workStatusDesc.setText(card.getWorkStatusDesc());
        holder.workStatusDescDesc.setText(card.getWorkStatusDescDesc());
        if (card.getStatus().equals(status)) {
            holder.status.setImageResource(R.mipmap.completed_foreground);
        }else{
            holder.status.setImageResource(R.mipmap.in_progress_foreground);
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

    public class MyViewHolder  extends RecyclerView.ViewHolder {
        TextView requestDate, workStatusDesc, workStatusDescDesc ;
        ImageView status;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            requestDate = itemView.findViewById(R.id.request_date);
            workStatusDesc = itemView.findViewById(R.id.arc_work_desc);
            workStatusDescDesc = itemView.findViewById(R.id.arc_work_desc_desc);
            status = itemView.findViewById(R.id.arc_status);

        }
    }
}

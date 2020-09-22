package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.CardViewVisitItemBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.AllVisitsFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.InspectionResultsFragment;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;


public abstract class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.MyViewHolder> {
    List<Visit> cards = new ArrayList<Visit>();
    public static OnFragmentInteractionListener listener;

    public static final String TAG = VisitsAdapter.class.getCanonicalName();

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
//        //+++++++++++++++++ set enabled according to status +++++++++++++
//        holder.binding.visitStatus.setText(card.getStatus()+"..");
//        holder.binding.revisitBtn.setEnabled(false);
//        holder.binding.showResultsBtn.setEnabled(false);
//        holder.binding.recommendationsBtn.setEnabled(false);
//        holder.binding.visitResultBtn.setEnabled(false);
//        switch (card.getStatus()) {
//            //enable the needed buttons depend on Status
//            case 0:
//                holder.binding.visitStartBtn.setEnabled(true);
//                holder.binding.extraServicesBtn.setEnabled(false);
//                break;
//            case 1:
//                holder.binding.visitStartBtn.setEnabled(false);
//                holder.binding.extraServicesBtn.setEnabled(true);
//                break;
//            case 2:
//                holder.binding.visitStartBtn.setEnabled(false);
//                holder.binding.extraServicesBtn.setEnabled(false);
//                holder.binding.revisitBtn.setEnabled(true);
//                holder.binding.showResultsBtn.setEnabled(true);
//                holder.binding.recommendationsBtn.setEnabled(true);
//                holder.binding.visitResultBtn.setEnabled(true);
//                break;
//        }//end switch
    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return cards.size();
    }//end getItemCount


    public void addCard(Visit card) {
        if (cards.contains(card)) return;
        cards.add(card);

    }//end addCard

    public void setCards(List<Visit> cards) {
        this.cards = cards;
    }//end setCards

    public abstract void showDialog();

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardViewVisitItemBinding binding;
        private ShMyDialog dialog;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardViewVisitItemBinding.bind(itemView);
            binding.visitResultBtn.setOnClickListener(this);
            binding.visitStartBtn.setOnClickListener(this);
            binding.recommendationsBtn.setOnClickListener(this);
            binding.showResultsBtn.setOnClickListener(this);
            binding.revisitBtn.setOnClickListener(this);
            binding.extraServicesBtn.setOnClickListener(this);

        }//end holder constructor

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.visit_start_btn:
                    showDialog();
                    break;
                case R.id.show_results_btn:
                    listener.onFragmentInteraction(R.id.show_results_btn);
                    break;
                case R.id.extra_services_btn:
                    listener.onFragmentInteraction(R.id.extra_services_btn);
                    break;
                case R.id.revisit_btn:
                    listener.onFragmentInteraction(R.id.revisit_btn);
                    break;
                case R.id.visit_result_btn:
                    listener.onFragmentInteraction(R.id.visit_result_btn);
                    break;
                case R.id.recommendations_btn:
                    listener.onFragmentInteraction(R.id.recommendations_btn);
                    break;
            }//end switch
        }//end onClick



    }//end ViewHolder Class

}//end VisitAdapter Class

package com.sh.wm.ministry.featuers.userfile.userFiles.career.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.userFiles.career.model.UserCareer;

import java.util.List;

public class UserCareersAdapter extends RecyclerView.Adapter<UserCareersAdapter.MyViewHolder> {

    List<UserCareer> mData;

    public UserCareersAdapter( List<UserCareer> mData) {

        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.career_cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TvCareerName.setText(mData.get(position).getCAREERNAME());
        holder.TvCareerVacation.setText(mData.get(position).getCAREERLICENSED());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView TvCareerName;
        TextView TvCareerVacation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TvCareerName = itemView.findViewById(R.id.tv_experience_type);
            TvCareerVacation = itemView.findViewById(R.id.tv_education_stauts_eductionalstatus);

        }
    }
}

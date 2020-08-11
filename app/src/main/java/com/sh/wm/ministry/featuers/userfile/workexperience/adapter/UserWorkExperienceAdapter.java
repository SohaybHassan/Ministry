package com.sh.wm.ministry.featuers.userfile.workexperience.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperience;

import java.util.List;

public class UserWorkExperienceAdapter extends RecyclerView.Adapter<UserWorkExperienceAdapter.MyViewHolder> {

    private List<UserWorkExperience> mData;
    private OnEditClickListener mListener;

    public UserWorkExperienceAdapter(List<UserWorkExperience> mData, OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_experience_cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnEditClickListener {
        void onEditClick(UserWorkExperience workExperience);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView TvExperienceType;
        private TextView TvWorkPlace;
        private TextView TvJobTitle;
        private TextView TvCompanyName;
        private AppCompatImageButton editIv;
        private CircularImageView test;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvExperienceType = itemView.findViewById(R.id.tv_experience_type);
            TvWorkPlace = itemView.findViewById(R.id.tv_education_stauts_eductionalstatus);
            TvJobTitle = itemView.findViewById(R.id.tv_qulification_eductionalstatus);
            TvCompanyName = itemView.findViewById(R.id.tv_qulification_detail_eductionalstatus);
            editIv = itemView.findViewById(R.id.ib_edit_work_experience);

        }

        public void bind(int position) {
            UserWorkExperience workExperience = mData.get(position);
            TvExperienceType.setText(workExperience.getEXPTYPE());
            TvWorkPlace.setText(workExperience.getEXPTYPE());
            TvJobTitle.setText(workExperience.getJOBTITL());
            TvCompanyName.setText(workExperience.getEXPINSTIT());

            editIv.setOnClickListener(view -> {
                mListener.onEditClick(workExperience);
                Log.d("wasd", "bind: ");
            });
        }
    }
}

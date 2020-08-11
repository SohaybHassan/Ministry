package com.sh.wm.ministry.featuers.userfile.educationalstatus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.UserEducationalStatus;

import java.util.List;

public class EducationalStatusAdapter extends RecyclerView.Adapter<EducationalStatusAdapter.ViewHolder> {
    private List<UserEducationalStatus> userEducationalStatusList;

    public EducationalStatusAdapter(List<UserEducationalStatus> userEducationalStatusList) {
        this.userEducationalStatusList = userEducationalStatusList;
    }

    @NonNull
    @Override
    public EducationalStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EducationalStatusAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_eduction_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EducationalStatusAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return userEducationalStatusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView eduTypeTv;
        private MaterialTextView eduStatusTv;
        private MaterialTextView qulificationTv;
        private MaterialTextView qulificationDetailTv;
        private AppCompatImageButton expandIb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eduTypeTv = itemView.findViewById(R.id.tv_education_type_eductionalstatus);
            eduStatusTv = itemView.findViewById(R.id.tv_education_stauts_eductionalstatus);
            qulificationTv = itemView.findViewById(R.id.tv_qulification_eductionalstatus);
            qulificationDetailTv = itemView.findViewById(R.id.tv_qulification_detail_eductionalstatus);
            expandIb = itemView.findViewById(R.id.ib_expand_education_cardview);

        }

        public void bind(int position) {
            UserEducationalStatus educationalStatus = userEducationalStatusList.get(position);
            eduTypeTv.setText(educationalStatus.getEDUTYPE());
            eduStatusTv.setText(educationalStatus.getEDUSTATUS());
            qulificationTv.setText(educationalStatus.getQULNAME());
            qulificationDetailTv.setText(educationalStatus.getQULDETAILSNAME());

        }
    }
}


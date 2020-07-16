package com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.UserWorkStatus;

import java.util.List;

public class PracticalStatusAdapter extends RecyclerView.Adapter<PracticalStatusAdapter.MyViewHolder> {

    private List<UserWorkStatus> mData;
    private PracticalStatusAdapter.OnEditClickListener mListener;

    public PracticalStatusAdapter(List<UserWorkStatus> mData, OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_practical_status, parent, false);
        return new PracticalStatusAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_practical_status;
        private TextView tv_describe_practical_status;
        private AppCompatImageButton editIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_practical_status = itemView.findViewById(R.id.tv_practical_status);
            tv_describe_practical_status = itemView.findViewById(R.id.tv_describe_practical_status);
            editIv = itemView.findViewById(R.id.ib_edit_practical_status);

        }

        public void bind(int position) {
            UserWorkStatus workStatus=mData.get(position);
            tv_practical_status.setText(workStatus.getWORKSTATUS());
            tv_describe_practical_status.setText(workStatus.getWORKSTATUSDESC());

            editIv.setOnClickListener(view -> {
                mListener.onEditClick(workStatus);
            });
        }
    }

    public interface OnEditClickListener {
        void onEditClick(UserWorkStatus workStatus);
    }
}

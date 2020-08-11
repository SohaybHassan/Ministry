package com.sh.wm.ministry.featuers.userfile.languages.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;

import java.util.List;

public class UserLanguagesAdapter extends RecyclerView.Adapter<UserLanguagesAdapter.MyViewHolder> {

    private List<UserLanguage> mData;
    private OnEditClickListener mListener;

    public UserLanguagesAdapter(List<UserLanguage> mData, OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public UserLanguagesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_language_item, parent, false);
        return new UserLanguagesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserLanguagesAdapter.MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnEditClickListener {
        void onEditClick(UserLanguage userLanguage);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_language;
        private TextView tv_speaking_skill;
        private TextView tv_writing_skill;
        private TextView tv_reading_skill;
        private AppCompatImageButton editIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_language = itemView.findViewById(R.id.tv_language);
            tv_speaking_skill = itemView.findViewById(R.id.tv_speaking_skill);
            tv_writing_skill = itemView.findViewById(R.id.tv_writing_skill);
            tv_reading_skill = itemView.findViewById(R.id.tv_reading_skill);
            editIv = itemView.findViewById(R.id.ib_edit_user_language);

        }

        public void bind(int position) {
            UserLanguage userLanguage=mData.get(position);
            tv_language.setText(userLanguage.getLANGUAGENAME());
            tv_speaking_skill.setText(userLanguage.getUSERLANGCONVERSATIONPER());
            tv_writing_skill.setText(userLanguage.getUSERLANGWRITEPERCENTAGE());
            tv_reading_skill.setText(userLanguage.getUSERLANGREADPERCENTAGE());

            editIv.setOnClickListener(view -> {
                mListener.onEditClick(userLanguage);
            });
        }
    }
}

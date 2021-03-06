package com.sh.wm.ministry.custem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;

public class BottomSheetSearsh {

    private Context application;

    private BottomSheetDialog mDialog;
    private bottomSheetSearsh mListener;

    public BottomSheetSearsh(Context application, BottomSheetDialog dialog, bottomSheetSearsh listener) {
        this.application = application;
        this.mListener = listener;
        this.mDialog = dialog;


    }


    public void openDialog(String title, String text) {

        View view = LayoutInflater.from(application).inflate(R.layout.my_buttom_sheet, null);
        mDialog = new BottomSheetDialog(application);
        mDialog.setContentView(view);

        TextView bottomText = view.findViewById(R.id.tv_text);
        TextView topText = view.findViewById(R.id.view_title);
        bottomText.setText(text);
        topText.setText(title);

        EditText ed_searsh = view.findViewById(R.id.searsh_nu_facelity);
        ImageView img_searsh_sheet = view.findViewById(R.id.img_searsh_sheet);
        img_searsh_sheet.setOnClickListener(view1 -> {

            if (ed_searsh.getText().toString().isEmpty()) {
                Toast.makeText(application, "الرجاء إدخال رقم منشاة صحيح ", Toast.LENGTH_SHORT).show();
            } else {
                mListener.searshByNumber(ed_searsh.getText().toString());
            }


            mDialog.dismiss();

        });

        mDialog.show();

    }


    public interface bottomSheetSearsh {

        void searshByNumber(String num_facility);

    }



}

package com.sh.wm.ministry.custem;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.sh.wm.ministry.R;


public class ShMyDialog extends DialogFragment {

    private TextView btn_save, btn_edit;
    private Dilogclicked dilogclicked;
    private String title;

    public ShMyDialog(Dilogclicked dilogclicked, String title) {
        this.title = title;
        this.dilogclicked = dilogclicked;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Dialog builder = new Dialog(requireContext());

        builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        View root = requireActivity().getLayoutInflater().inflate(R.layout.sh_my_dialog, null);
        TextView tv_title = root.findViewById(R.id.tv_text);
        tv_title.setText(title);
        init(root);
        clicked();

        builder.setCanceledOnTouchOutside(false);
        builder.setContentView(root);
        return builder;
    }

    public void init(View root) {
        btn_save = root.findViewById(R.id.btn_save_dialog);
        btn_edit = root.findViewById(R.id.btn_Edit_dialog);
    }

    public void clicked() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogclicked.sase(view);


            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogclicked.edite(view);

            }
        });
    }

    public interface Dilogclicked {

        void sase(View view);

        void edite(View view);
    }
}

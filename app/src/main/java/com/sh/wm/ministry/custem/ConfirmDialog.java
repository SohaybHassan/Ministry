package com.sh.wm.ministry.custem;

import android.content.Context;

import androidx.annotation.NonNull;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.sh.wm.ministry.R;


public class ConfirmDialog {
    private MaterialDialog dialog;

    public ConfirmDialog(@NonNull Listener listener, Context context , String title) {
        dialog = new MaterialDialog.Builder(context)
                .title(title)
                .positiveText(R.string.save)
                .negativeText(R.string.edit)
                .onPositive((dialog, which) ->
                        listener.onOk()
                ).onNegative((dialog, which) ->
                        listener.onCancel()
                ).contentGravity(GravityEnum.CENTER)
                .buttonsGravity(GravityEnum.CENTER)
                .contentColor(context.getResources().getColor(R.color.mine_shaft))
                .negativeColor(context.getResources().getColor(R.color.mine_shaft))
                .positiveColor(context.getResources().getColor(R.color.jordy_blue))
                .dividerColor(context.getResources().getColor(R.color.mine_shaft))
                .build();
    }

    public void presentForList(String dialogContent) {
        dialog.setContent(dialogContent);
        dialog.show();
    }

    public interface Listener {
        void onOk();

        void onCancel();
    }
}
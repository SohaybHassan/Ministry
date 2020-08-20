package com.sh.wm.ministry.custem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import com.sh.wm.ministry.R;


public class ToastMsg {

    Context context;
    LayoutInflater inflater;

    public ToastMsg(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void toastIconError(String s) {

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        //inflate view
        View custom_view = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) custom_view.findViewById(R.id.message)).setText(s);
        ((ImageView) custom_view.findViewById(R.id.icon)).setImageResource(R.drawable.ic_close);
        ((CardView) custom_view.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.cinnabar));

        toast.setView(custom_view);
        toast.show();
    }

    public void toastIconSuccess(String s) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        //inflate view
        View custom_view = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) custom_view.findViewById(R.id.message)).setText(s);
        ((AppCompatImageView) custom_view.findViewById(R.id.icon)).setImageResource(R.drawable.ic_done);
        ((CardView) custom_view.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.fruit_salad));

        toast.setView(custom_view);
        toast.show();
    }


    public void toastIconErrorBlue(String s) {

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        //inflate view
        View custom_view = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) custom_view.findViewById(R.id.message)).setText(s);
        ((ImageView) custom_view.findViewById(R.id.icon)).setImageResource(R.drawable.ic_close);
        ((CardView) custom_view.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.jordy_blue));

        toast.setView(custom_view);
        toast.show();
    }



}
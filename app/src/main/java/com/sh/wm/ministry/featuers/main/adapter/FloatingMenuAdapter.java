package com.sh.wm.ministry.featuers.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.main.modelMain.NavigationModel;

import java.util.ArrayList;
import java.util.List;


public class FloatingMenuAdapter extends ArrayAdapter<NavigationModel> {

    private Context mContext;
    private List<NavigationModel> navigationModelList;

    public FloatingMenuAdapter(@NonNull Context context, ArrayList<NavigationModel> list) {
        super(context, 0, list);
        mContext = context;
        navigationModelList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.floating_list_item, parent, false);

        NavigationModel model = navigationModelList.get(position);
        TextView title = convertView.findViewById(R.id.tv_item_title);
        title.setText(model.getTitle());
        AppCompatImageView imageView = convertView.findViewById(R.id.iv_item_image);
        imageView.setImageResource(getImageId(mContext, model.getImg()));

        return convertView;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

}

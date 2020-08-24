package com.sh.wm.ministry.custem;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;

public class BottomSheetSearshList implements SearchView.OnQueryTextListener {

    private ConstraintLayout constraintLayout;
    private Context application;
    private BottomSheetDialog mDialog;
    private BottomSheetSearsh.bottomSheetSearsh mListener;

    public BottomSheetSearshList(android.content.Context application, BottomSheetDialog dialog, BottomSheetSearsh.bottomSheetSearsh listener) {
        this.application = application;
        this.mListener = listener;
        this.mDialog = dialog;


    }


    public void openDialog(String hint) {

        View view = LayoutInflater.from(application).inflate(R.layout.bottom_sheet_eaarch, null);
        mDialog = new BottomSheetDialog(application);

        constraintLayout=view.findViewById(R.id.my_root);
        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setQueryHint(hint);
        searchView.setOnQueryTextListener(this);
        mDialog.setContentView(view);



        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();

        int height = displayMetrics.heightPixels;


        int maxHeight =  (height*2);


        BottomSheetBehavior mBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBehavior.setPeekHeight(maxHeight);
        Toast.makeText(application, "height : "+ mBehavior.getPeekHeight() ,Toast.LENGTH_SHORT).show();
        mDialog.show();

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mListener.searshByNumber(s);

        return false;
    }


    public interface bottomSheetSearsh {

        void searshByNumber(String name_facility);

    }


}

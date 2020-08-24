package com.sh.wm.ministry.custem;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;

import java.util.ArrayList;

public class BottomSheetSearshList extends RecyclerView {

    private static ArrayList<Construct> mList;
    private static BottomSheetDialog bottomSheetDialog;
    private static ConstructByName constructByName;

    public BottomSheetSearshList(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mList = new ArrayList<>();
        constructByName = new ConstructByName();
        bottomSheetDialog = new BottomSheetDialog(context);
    }

    @Override
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layout) {
        super.setLayoutManager(layout);
    }

    public static BottomSheetDialog getBottomSheetDialog() {
        return bottomSheetDialog;
    }

    public void setBottomSheetDialog(BottomSheetDialog bottomSheetDialog) {
        BottomSheetSearshList.bottomSheetDialog = bottomSheetDialog;
    }

    public void setMyList(ArrayList<Construct> myList) {
        mList.addAll(myList);
    }

    public static ArrayList<Construct> getMyList() {
        return mList;
    }


    public static class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.MyHolder> {

        private MyClass myclass;

        public MyTestAdapter(MyClass myclass) {
            this.myclass = myclass;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottomsheet_search, parent, false);
            return new MyHolder(root);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            Construct constructByName = getMyList().get(position);

            holder.name.setText(constructByName.getCONSTRUCTNAMEUSING());
            holder.number.setText(constructByName.getCONSTRUCTNUM());
            holder.bind(constructByName, myclass);
        }

        @Override
        public int getItemCount() {
            return getMyList().size();
        }


        public class MyHolder extends RecyclerView.ViewHolder {

            TextView name, number;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.construction_name);
                number = itemView.findViewById(R.id.construction_number);

            }

            public void bind(final Construct constructByName, final MyClass myClass) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myclass.MyMethod(constructByName);
                        BottomSheetSearshList.getBottomSheetDialog().dismiss();

                    }
                });
            }


        }

        public interface MyClass {
            void MyMethod(Construct constructByName);
        }


    }
}

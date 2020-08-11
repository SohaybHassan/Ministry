package com.sh.wm.ministry.featuers.userfile.health.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.databinding.FragmentHealthStatusBinding;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatus;
import com.sh.wm.ministry.featuers.userfile.health.viewmodel.HealhViewModel;

public class HealhFragment extends Fragment {

    private HealhViewModel mViewModel;
    private FragmentHealthStatusBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHealthStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HealhViewModel.class);
        mViewModel.getUserWorkInfoLiveData().observe(getViewLifecycleOwner(), userHealthStatusModel -> {
            if (userHealthStatusModel.getStatus() == 0) {
                UserHealthStatus userHealthStatus = userHealthStatusModel.getUserHealthStatus().get(0);
                String userHealthDesc = userHealthStatus.getUSERHEALTHDESC();
                binding.etHealhStatusDetails.setText(userHealthDesc);
            } else binding.etHealhStatusDetails.setText("-");
            binding.etHealhStatus.setInputType(0);
            binding.etHealhStatus.setOnClickListener(view -> {
                BottomSheetDialog dialog = new BottomSheetDialog(getContext());
                dialog.setContentView(R.layout.bottom_sheet_view);

                BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
                MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
                titleTv.setText(R.string.kind_of_education);
                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bottomsheet_spinner_edu_type));
                listView.setAdapter(itemsAdapter);
                dialog.show();

            });
        });
    }
}
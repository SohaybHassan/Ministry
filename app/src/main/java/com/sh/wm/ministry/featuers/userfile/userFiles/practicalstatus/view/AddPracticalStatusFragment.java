package com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentAddPracticalStatusBinding;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.WorkStatus;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.viewmodel.AddPracticalStatusViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddPracticalStatusFragment extends Fragment {

    private AddPracticalStatusViewModel mViewModel;
    private FragmentAddPracticalStatusBinding binding;
    private List<String> BSList;
    private ShMyDialog dialog;

    public static AddPracticalStatusFragment newInstance() {
        return new AddPracticalStatusFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentAddPracticalStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BSList = new ArrayList<>();

        getBundleData();
        getWorkStatuses();
        editWorkStatus();
        btnListener();

    }

    public void btnListener() {

        binding.btnSaveAddLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {

//                        if (binding.tvLanguage.getText().toString().isEmpty() || binding.tvReadingSkill.getText().toString().isEmpty()|| binding.tvSpeakingSkill.getText().toString().isEmpty() ||  binding.tvWritingSkill.getText().toString().isEmpty()) {
//                            Toast.makeText(getContext(), "empty fields", Toast.LENGTH_SHORT).show();
//                        } else {
                        Toast.makeText(getContext(), "you saved the work status", Toast.LENGTH_SHORT).show();
//                        }

                        dialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        Toast.makeText(getContext(), "you may edit the work status", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, getString(R.string.save_language));
                dialog.show(getParentFragmentManager(), "dialog tag");
            }
        });


    }

    private void editWorkStatus() {
        binding.tvPracticalStatus.setOnClickListener(view -> {
            showBtmSheet(R.string.practical_status, BSList, binding.tvPracticalStatus, true);
        });
    }

    private void getWorkStatuses() {
        mViewModel = new ViewModelProvider(this).get(AddPracticalStatusViewModel.class);
        mViewModel.getAllWorkStatuses().observe(getViewLifecycleOwner(), workStatuses -> {
            if (workStatuses != null) {
                for (WorkStatus status : workStatuses) {
                    BSList.add(status.getWORKSTATUSNAME());
                }
            } else {
                Toast.makeText(getContext(), "list is empty", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
//            binding.tvLanguage.setText(bundle.getString("language"));
//            binding.tvSpeakingSkill.setText(bundle.getString("speaking_skill"));
//            binding.tvWritingSkill.setText(bundle.getString("writing_skill"));
//            binding.tvReadingSkill.setText(bundle.getString("reading_skill"));
        }
    }


    public void showBtmSheet(int title, List<String> list, TextView tv_change, Boolean isWorkStatus) {

        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_view);
        BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
        MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
        titleTv.setText(title);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(itemsAdapter);
        dialog.show();

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            if (isWorkStatus) {
                if (adapterView.getItemAtPosition(i).toString().equals(getResources().getString(R.string.works))) {
                    binding.LLPracticalStatus.setVisibility(View.VISIBLE);
                } else {
                    binding.LLPracticalStatus.setVisibility(View.INVISIBLE);
                }
            }
            tv_change.setText(adapterView.getItemAtPosition(i).toString());
            dialog.cancel();
        });
    }


}
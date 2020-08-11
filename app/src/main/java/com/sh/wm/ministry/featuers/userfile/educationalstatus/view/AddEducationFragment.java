package com.sh.wm.ministry.featuers.userfile.educationalstatus.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.ConfirmDialog;

import com.sh.wm.ministry.databinding.FragmentAddEducationBinding;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel.AddEducationViewModel;

public class AddEducationFragment extends Fragment implements ConfirmDialog.Listener {
    private FragmentAddEducationBinding binding;
    private ConfirmDialog confirmDialog;
    private TextInputEditText eduType;
    private TextInputEditText eduStatus;
    private TextInputEditText eduInstitutionEt;
    private TextInputEditText eduTrainProgEt;
    private TextInputEditText eduSpeclizedEt;
    private TextInputEditText eduDepartmentEt;
    private TextView eduInstitutionTv;
    private TextView eduTrainProgTv;
    private TextView eduSpeclizedTv;
    private TextView eduDepartmentTv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddEducationBinding.inflate(inflater, container, false);
        eduType = binding.etEducationTypeEducatinalStatus;
        eduStatus = binding.etEducationStatusEducatinalStatus;

        eduInstitutionEt = binding.etEducationalInstitution;
        eduTrainProgEt = binding.etTrainningProgramEdu;
        eduSpeclizedEt = binding.etEducationSpecialization;
        eduDepartmentEt = binding.etEducationDepartment;

        eduInstitutionTv = binding.tvEducationalInstitution;
        eduTrainProgTv = binding.tvTrainningProgramEdu;
        eduSpeclizedTv = binding.tvEducationSpecialization;
        eduDepartmentTv = binding.tvEducationDepartment;
        setViewsVisibility(View.GONE);
        confirmDialog = new ConfirmDialog(this, getContext(), "");
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AddEducationViewModel mViewModel = new ViewModelProvider(this).get(AddEducationViewModel.class);
        setEduType();
        setEduStatus();
        binding.btnSaveNewEducationAddEducation.setOnClickListener(view -> {
            confirmDialog.presentForList(getString(R.string.do_want_to_add_new_education));
        });

    }

    private void setEduType() {
        eduType.setInputType(0);
        eduType.setOnClickListener(view -> {

            BottomSheetDialog dialog = new BottomSheetDialog(getContext());
            dialog.setContentView(R.layout.bottom_sheet_view);

            BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
            MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
            titleTv.setText(R.string.kind_of_education);
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bottomsheet_spinner_edu_type));
            listView.setAdapter(itemsAdapter);
            dialog.show();
            listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                switch (i) {
                    case 0:
                        eduType.setText(adapterView.getItemAtPosition(i).toString());
                        setViewsVisibility(View.VISIBLE);
                        break;
                    case 1:
                        eduType.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                    case 2:
                        eduType.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                    case 3:
                        eduType.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                    case 4:
                        eduType.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                }
                dialog.cancel();
            });
        });
    }

    private void setEduStatus() {
        eduStatus.setInputType(0);
        eduStatus.setOnClickListener(view -> {

            BottomSheetDialog dialog = new BottomSheetDialog(getContext());
            dialog.setContentView(R.layout.bottom_sheet_view);

            BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
            MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
            titleTv.setText(R.string.educational_status);
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bottomsheet_spinner_edu_status));
            listView.setAdapter(itemsAdapter);
            dialog.show();
            listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                switch (i) {
                    case 0:
                        eduStatus.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                    case 1:
                        eduStatus.setText(adapterView.getItemAtPosition(i).toString());
                        break;
                }
                dialog.cancel();
            });
        });
    }

    private void setViewsVisibility(int status) {
        eduInstitutionEt.setVisibility(status);
        eduTrainProgEt.setVisibility(status);
        eduSpeclizedEt.setVisibility(status);
        eduDepartmentEt.setVisibility(status);

        eduInstitutionTv.setVisibility(status);
        eduTrainProgTv.setVisibility(status);
        eduSpeclizedTv.setVisibility(status);
        eduDepartmentTv.setVisibility(status);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onOk() {

    }

    @Override
    public void onCancel() {

    }
}

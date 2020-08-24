package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.BottomSheetSearshList;
import com.sh.wm.ministry.databinding.FragmentFileComplaintForm1Binding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel.WorkerCompilationFormTwoViewModel;


public class WorkerCompilationFormOneFragment extends Fragment {

    private FragmentFileComplaintForm1Binding binding;
    private OnFragmentInteractionListener mListener;
    private WorkerCompilationFormTwoViewModel workerCompilationFormTwoViewModel;
    private Observer<ConstructByName> constructByNameObserver;
    private BottomSheetSearshList bottomSheetSearshList;
    private BottomSheetDialog bottomSheetDialog;
    private static final String TAG = WorkerCompilationFormOneFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constructByNameObserver = constructByName -> {
            if (constructByName != null) {
                Log.d(TAG, "onChanged: " + constructByName.getConstructs().get(1));
            } else {
                Log.d(TAG, "onChanged: no data");
                Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFileComplaintForm1Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        bottomSheetDialog = new BottomSheetDialog(getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workerCompilationFormTwoViewModel = new ViewModelProvider(this).get(WorkerCompilationFormTwoViewModel.class);

        binding.btnComplaintNext.setOnClickListener(view1 -> {


            mListener.onFragmentInteraction(21);
        });


        binding.edNuFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetSearshList = new BottomSheetSearshList(getActivity(), bottomSheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searshByNumber(String num_facility) {

                          workerCompilationFormTwoViewModel.getConstruct(binding.edNuFacility.getText().toString()).observe(getViewLifecycleOwner(), constructByNameObserver);

                    }
                });

                bottomSheetSearshList.openDialog("sohaib");
            }
        });

        binding.edNuFacility.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (i2 == 3) {

                    Toast.makeText(getActivity(), "you can do it the request now ", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
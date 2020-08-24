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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.BottomSheetSearshList;
import com.sh.wm.ministry.databinding.FragmentFileComplaintForm1Binding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel.WorkerCompilationFormTwoViewModel;

import java.util.ArrayList;


public class WorkerCompilationFormOneFragment extends Fragment {

    private FragmentFileComplaintForm1Binding binding;
    private OnFragmentInteractionListener mListener;
    private WorkerCompilationFormTwoViewModel workerCompilationFormTwoViewModel;
    private Observer<ConstructByName> constructByNameObserver;
    private BottomSheetSearshList bottomSheetSearshList;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetSearshList.MyTestAdapter myTestAdapter;
    private ImageView imNoData,imNoData2;
   private ProgressBar  progressBar;




    private static final String TAG = WorkerCompilationFormOneFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constructByNameObserver = constructByName -> {
            if (constructByName != null) {

                bottomSheetSearshList.setMyList(constructByName.getConstructs());
                bottomSheetSearshList.setBottomSheetDialog(bottomSheetDialog);
                bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                myTestAdapter = new BottomSheetSearshList.MyTestAdapter(new BottomSheetSearshList.MyTestAdapter.MyClass() {
                    @Override
                    public void MyMethod(Construct constructByName) {
                        binding.edNuFacility.setText(constructByName.getCONSTRUCTNAMEUSING());
                        binding.edOwnerWorkName.setText(constructByName.getCONSTRUCTIONOWNER().getOWNERNAME());
                        binding.edPhone.setText(constructByName.getCONSTRUCTMOBILE());
                        binding.edActive.setText(constructByName.getCONSTRUCTMAINECON());
                        binding.edFacilityAddress.setText(constructByName.getCONSTRUCTADDRESS());
                    }
                });
                progressBar.setVisibility(View.GONE);

                bottomSheetSearshList.setAdapter(myTestAdapter);
            } else {

                Log.d(TAG, "onChanged: no data");
                Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
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

                bottomSheetDialog.setContentView(R.layout.bottom_sheet_eaarch);
                EditText textView = bottomSheetDialog.findViewById(R.id.search_view);
                bottomSheetSearshList = bottomSheetDialog.findViewById(R.id.recycler_view);
                imNoData = bottomSheetDialog.findViewById(R.id.image_no_data);
                 progressBar = bottomSheetDialog.findViewById(R.id.progressbar);
                textView.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (i2 == 3) {
                            progressBar.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity(), "=> "+ i2, Toast.LENGTH_SHORT).show();
                            workerCompilationFormTwoViewModel.getConstruct(textView.getText().toString()).observe(getViewLifecycleOwner(), constructByNameObserver);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                bottomSheetDialog.show();

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
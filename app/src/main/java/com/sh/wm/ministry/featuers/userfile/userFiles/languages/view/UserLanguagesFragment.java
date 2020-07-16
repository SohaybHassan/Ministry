package com.sh.wm.ministry.featuers.userfile.userFiles.languages.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.databinding.FragmentUserLanguagesBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.UserLanguage;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.viewmodel.UserLanguagesViewModel;

import java.util.List;

public class UserLanguagesFragment extends Fragment implements UserLanguagesAdapter.OnEditClickListener {

    private UserLanguagesViewModel mViewModel;
    private FragmentUserLanguagesBinding binding;
    private RecyclerView myRecyclerView;
    private OnFragmentInteractionListener mListener;

    public static UserLanguagesFragment newInstance() {
        return new UserLanguagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserLanguagesBinding.inflate(inflater, container, false);

        binding.LLLayoutUserLanguages.setVisibility(View.INVISIBLE);
        binding.fabAddLanguagesUserLanguages.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvLanguagesUserLanguages;

        binding.fabAddLanguagesUserLanguages.setOnClickListener(view -> {
            mListener.onFragmentInteraction(91);
        });
        binding.btnAddLanguagesUserLanguages.setOnClickListener(view -> {
            mListener.onFragmentInteraction(91);
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserLanguagesViewModel.class);
        mViewModel.getUserLanguages().observe(getViewLifecycleOwner(), userLanguagesModel -> {
            if (userLanguagesModel != null) {
                if (userLanguagesModel.getUserLanguage() != null) {
                    List<UserLanguage> userLanguage = userLanguagesModel.getUserLanguage();
                    UserLanguagesAdapter adapter= new UserLanguagesAdapter(userLanguage, this);
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    myRecyclerView.setAdapter(adapter);
                    binding.LLLayoutUserLanguages.setVisibility(View.GONE);
                    binding.fabAddLanguagesUserLanguages.setVisibility(View.VISIBLE);
                } else {
                    binding.LLLayoutUserLanguages.setVisibility(View.VISIBLE);
                    binding.fabAddLanguagesUserLanguages.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onEditClick(UserLanguage userLanguage) {
        Bundle bundle=new Bundle();
        bundle.putString("language",userLanguage.getLANGUAGENAME());
        bundle.putString("speaking_skill",userLanguage.getUSERLANGCONVERSATIONPER());
        bundle.putString("writing_skill",userLanguage.getUSERLANGWRITEPERCENTAGE());
        bundle.putString("reading_skill",userLanguage.getUSERLANGREADPERCENTAGE());
        mListener.onFragmentInteraction(92,bundle);
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


}
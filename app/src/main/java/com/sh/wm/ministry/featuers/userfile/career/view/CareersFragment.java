package com.sh.wm.ministry.featuers.userfile.career.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.databinding.FragmentCareersBinding;
import com.sh.wm.ministry.featuers.userfile.career.adapter.UserCareersAdapter;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareer;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.career.viewmodel.CareersViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.List;

public class CareersFragment extends Fragment {

    private FragmentCareersBinding binding;
    private RecyclerView myRecyclerView;

    public static CareersFragment newInstance() {
        return new CareersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCareersBinding.inflate(inflater, container, false);
        binding.tvNoCareerCareers.setVisibility(View.INVISIBLE);
        binding.rvCareersCareers.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvCareersCareers;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CareersViewModel mViewModel = new ViewModelProvider(this).get(CareersViewModel.class);
        mViewModel.getUserCareers(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), new Observer<UserCareerModel>() {
            @Override
            public void onChanged(UserCareerModel userCareerModel) {
                if (userCareerModel != null) {
                    if (userCareerModel.getUserCareer() != null) {
                        List<UserCareer> userCareers = userCareerModel.getUserCareer();
                        UserCareersAdapter adapter = new UserCareersAdapter(getContext(), userCareers);
                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        myRecyclerView.setAdapter(adapter);
                        binding.rvCareersCareers.setVisibility(View.VISIBLE);
                        binding.tvNoCareerCareers.setVisibility(View.INVISIBLE);
                    } else {
                        binding.rvCareersCareers.setVisibility(View.INVISIBLE);
                        binding.tvNoCareerCareers.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}

